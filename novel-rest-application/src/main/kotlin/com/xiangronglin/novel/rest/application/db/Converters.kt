package com.xiangronglin.novel.rest.application.db

import com.xiangronglin.novel.rest.api.Novel
import com.xiangronglin.novel.rest.api.TriggerResult
import com.xiangronglin.novel.rest.application.db.model.NovelEntity
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