package com.kaiserpudding.novelservice.db

import com.kaiserpudding.novelservice.api.dto.Novel
import com.kaiserpudding.novelservice.api.dto.TriggerResult
import com.kaiserpudding.novelservice.db.model.NovelEntity
import java.util.*

fun Optional<NovelEntity>.toNovel(): Novel? {
    return if (isPresent) {
        val novel = get()
        Novel(novel.id.toString(), novel.status, novel.fileId)
    } else {
        null
    }
}

fun NovelEntity.toTriggerResult(): TriggerResult {
    return TriggerResult(id)
}