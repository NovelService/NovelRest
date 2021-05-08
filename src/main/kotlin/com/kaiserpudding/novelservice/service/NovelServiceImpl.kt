package com.kaiserpudding.novelservice.service

import com.kaiserpudding.novelservice.api.dto.Novel
import com.kaiserpudding.novelservice.api.dto.TriggerConfig
import com.kaiserpudding.novelservice.api.dto.TriggerResult
import com.kaiserpudding.novelservice.api.service.NovelService
import com.kaiserpudding.novelservice.db.NovelRepository
import com.kaiserpudding.novelservice.db.model.NovelEntity
import com.kaiserpudding.novelservice.db.toNovel
import com.kaiserpudding.novelservice.db.toTriggerResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class NovelServiceImpl(@Autowired private val novelRepository: NovelRepository) : NovelService {
    override fun trigger(config: TriggerConfig): TriggerResult {
        val result = novelRepository.save(NovelEntity())
//        TODO send amq message
        return result.toTriggerResult()
    }

    override fun get(id: UUID): Novel? {
        return novelRepository.findById(id).toNovel()
    }
}