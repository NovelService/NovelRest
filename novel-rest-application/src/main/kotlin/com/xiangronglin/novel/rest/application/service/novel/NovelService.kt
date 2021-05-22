package com.xiangronglin.novel.rest.application.service.novel

import com.xiangronglin.novel.rest.api.Novel
import com.xiangronglin.novel.rest.api.TriggerConfig
import com.xiangronglin.novel.rest.api.TriggerResult
import com.xiangronglin.novel.worker.api.NovelConfigMessage
import com.xiangronglin.novel.rest.application.db.NovelRepository
import com.xiangronglin.novel.rest.application.db.model.NovelEntity
import com.xiangronglin.novel.rest.application.db.toNovel
import com.xiangronglin.novel.rest.application.db.toTriggerResult
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.core.JmsTemplate
import org.springframework.stereotype.Service
import java.util.*

@Service
class NovelService(
    @Autowired private val novelRepository: NovelRepository,
    @Autowired private val jmsTemplate: JmsTemplate
)  {

    companion object {
        private val LOG = LoggerFactory.getLogger(NovelService::class.java)
    }

     fun trigger(triggerConfig: TriggerConfig): TriggerResult {
        val result = novelRepository.save(NovelEntity())

        val message = NovelConfigMessage(result.id.toString(), triggerConfig.url, triggerConfig.tableOfContents)
        LOG.info("Sending message to default queue. $message")
        jmsTemplate.convertAndSend(message)

        return result.toTriggerResult()
    }

    fun get(id: UUID): Novel? {
        return novelRepository.findById(id).toNovel()
    }
}