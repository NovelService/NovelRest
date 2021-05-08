package com.kaiserpudding.novelservice.api.service

import com.kaiserpudding.novelservice.api.dto.Novel
import com.kaiserpudding.novelservice.api.dto.TriggerConfig
import com.kaiserpudding.novelservice.api.dto.TriggerResult
import java.util.*

interface NovelService {
    fun trigger(triggerConfig: TriggerConfig): TriggerResult
    fun get(id: UUID): Novel?
}