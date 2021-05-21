package com.kaiserpudding.novelservice.worker

import com.kaiserpudding.novelservice.api.jms.NovelConfigMessage
import com.kaiserpudding.novelservice.api.service.FileService
import com.kaiserpudding.novelservice.db.NovelRepository
import com.kaiserpudding.novelservice.infratructure.AmqConfigurator
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component
import java.nio.file.Files
import java.util.*
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.nameWithoutExtension

@ExperimentalPathApi
@Component
class NovelMessageListener(
    @Autowired private val novelRepository: NovelRepository,
    @Autowired private val fileService: FileService
) {

    companion object {
        private val LOG = LoggerFactory.getLogger(NovelMessageListener::class.java)
    }

    private val extractor = Extractor()

    @JmsListener(destination = AmqConfigurator.NOVEL_QUEUE)
    fun processNovel(config: NovelConfigMessage) {
        LOG.info("Received novel job with config: '$config'")

        runBlocking {
            if (config.tableOfContents) {
                LOG.info("Multi download not implemented yet")
            } else {
                LOG.info("Single download starting")
                val tmpDir = Files.createTempDirectory("novel")
                val file = Files.createTempFile(tmpDir, "novel", ".html")

                extractor.extractSingle(config.url, file.toFile())
                extractor.convert(file.nameWithoutExtension, "epub", tmpDir.toFile())

                val fileId = fileService.saveNovel(file)
                val novel = novelRepository.findById(UUID.fromString(config.novelId))
                novel.ifPresentOrElse(
                    {
                        it.fileId = fileId
                        novelRepository.save(it)
                    },
                    { LOG.error("File with id '${config.novelId}' was not found") }
                )
            }
        }
    }

}