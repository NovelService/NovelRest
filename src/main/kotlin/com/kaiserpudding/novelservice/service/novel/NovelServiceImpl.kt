package com.kaiserpudding.novelservice.service.novel

import com.kaiserpudding.novel.worker.api.NovelConfigMessage
import com.kaiserpudding.novelservice.api.dto.Novel
import com.kaiserpudding.novelservice.api.dto.TriggerConfig
import com.kaiserpudding.novelservice.api.dto.TriggerResult
import com.kaiserpudding.novelservice.api.service.NovelService
import com.kaiserpudding.novelservice.db.NovelRepository
import com.kaiserpudding.novelservice.db.model.NovelEntity
import com.kaiserpudding.novelservice.db.toNovel
import com.kaiserpudding.novelservice.db.toTriggerResult
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.core.JmsTemplate
import org.springframework.stereotype.Service
import java.util.*

@Service
class NovelServiceImpl(
    @Autowired private val novelRepository: NovelRepository,
    @Autowired private val jmsTemplate: JmsTemplate
) : NovelService {

    companion object {
        private val LOG = LoggerFactory.getLogger(NovelServiceImpl::class.java)
    }

    override fun trigger(triggerConfig: TriggerConfig): TriggerResult {
        val result = novelRepository.save(NovelEntity())

        val message = NovelConfigMessage(result.id.toString(), triggerConfig.url, triggerConfig.tableOfContents)
        LOG.info("Sending message to default queue. $message")
        jmsTemplate.convertAndSend(message)

        return result.toTriggerResult()
    }

    override fun get(id: UUID): Novel? {
        return novelRepository.findById(id).toNovel()
    }
}