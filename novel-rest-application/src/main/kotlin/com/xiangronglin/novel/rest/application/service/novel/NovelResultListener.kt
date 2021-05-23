package com.xiangronglin.novel.rest.application.service.novel

import com.xiangronglin.novel.rest.application.db.NovelRepository
import com.xiangronglin.novel.worker.api.NovelResultMessage
import com.xiangronglin.novel.worker.api.Queue
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component
import java.util.*

@Component
class NovelResultListener(
    @Autowired private val novelRepository: NovelRepository
) {

    companion object {
        private val LOG = LoggerFactory.getLogger(NovelResultListener::class.java)
    }

    @JmsListener(destination = Queue.NOVEL_RESULT)
    fun processResult(result: NovelResultMessage) {
        LOG.info("Received novel result : '$result'")

        val novel = novelRepository.findById(UUID.fromString(result.novelId)).get()
        novel.status = result.status.toString()
        novel.fileId = result.fileKey

        novelRepository.save(novel)
    }
}