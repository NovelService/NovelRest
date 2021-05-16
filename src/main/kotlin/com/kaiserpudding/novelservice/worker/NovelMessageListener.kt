package com.kaiserpudding.novelservice.worker

import com.kaiserpudding.novelservice.api.jms.NovelConfigMessage
import com.kaiserpudding.novelservice.api.service.NovelService
import com.kaiserpudding.novelservice.infratructure.AmqConfigurator
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component
import java.nio.file.Files

@Component
class NovelMessageListener(@Autowired val novelService: NovelService) {

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
                LOG.info(file.toAbsolutePath().toString())
                extractor.extractSingle(config.url, file.toFile())
                extractor.convert(file.toFile().nameWithoutExtension, "epub", tmpDir.toFile())
            }
        }
    }

}