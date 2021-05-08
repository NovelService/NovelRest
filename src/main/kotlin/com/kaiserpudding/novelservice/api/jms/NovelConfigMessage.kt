package com.kaiserpudding.novelservice.api.jms

import java.io.Serializable
import java.util.*

data class NovelConfigMessage(
    val novelId: UUID,
    val url: String,
    val tableOfContents: Boolean
) : Serializable