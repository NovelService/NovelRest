package com.xiangronglin.novel.rest.api

data class Novel(
    val id: String,
    val status: String,
    val fileId: String?
)