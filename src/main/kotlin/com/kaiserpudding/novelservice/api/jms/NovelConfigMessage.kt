package com.kaiserpudding.novelservice.api.jms

import java.io.Serializable

data class NovelConfigMessage(
    val novelId: String,
    val url: String,
    val tableOfContents: Boolean
) : Serializable