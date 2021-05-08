package com.kaiserpudding.novelservice.service

import com.kaiserpudding.novelservice.api.dto.Novel
import com.kaiserpudding.novelservice.api.dto.TriggerConfig
import com.kaiserpudding.novelservice.api.dto.TriggerResult
import com.kaiserpudding.novelservice.api.service.NovelService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/novel")
class NovelController(@Autowired val novelService: NovelService) {

    companion object {
        private val LOG = LoggerFactory.getLogger(NovelController::class.java)
    }

    @PostMapping("/trigger")
    fun trigger(@RequestBody config: TriggerConfig): TriggerResult {
        LOG.info("POST novel/trigger. config: '$config'")
        return novelService.trigger(config)
    }

    @GetMapping("/{id}")
    fun getNovel(@PathVariable(name = "id") id: UUID): Novel? {
        LOG.info("GET novel/$id")
        return novelService.get(id)
    }
}