package com.kaiserpudding.novelservice.service

import com.kaiserpudding.novelservice.api.TriggerConfig
import com.kaiserpudding.novelservice.api.TriggerResult
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/novel")
class NovelController {

    companion object {
        private val LOG = LoggerFactory.getLogger(NovelController::class.java)
    }

    @PostMapping("/trigger")
    fun trigger(@RequestBody config: TriggerConfig): TriggerResult {
        LOG.info("POST trigger '$config'" )
        return TriggerResult(1)
    }
}