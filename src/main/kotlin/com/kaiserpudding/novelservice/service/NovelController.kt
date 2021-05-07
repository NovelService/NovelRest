package com.kaiserpudding.novelservice.service

import com.kaiserpudding.novelservice.api.Novel
import com.kaiserpudding.novelservice.api.TriggerConfig
import com.kaiserpudding.novelservice.api.TriggerResult
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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
        LOG.info("POST novel/trigger. config: '$config'" )
        return TriggerResult(1)
    }

    @GetMapping("/{id}")
    fun getNovel(@PathVariable(name = "id") id: Long): Novel {
        LOG.info("GET novel/$id")
        return Novel("done", "url")
    }
}