package com.kaiserpudding.novelservice.worker

import com.kaiserpudding.novelservice.api.jms.NovelConfigMessage
import com.kaiserpudding.novelservice.infratructure.AmqConfigurator
import org.slf4j.LoggerFactory
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

@Component
class NovelMessageListener {

    companion object {
        private val LOG = LoggerFactory.getLogger(NovelMessageListener::class.java)
    }

    @JmsListener(destination = AmqConfigurator.NOVEL_QUEUE)
    fun processNovel(config: NovelConfigMessage) {
        LOG.info("Received novel job with config: '$config'")
    }

}