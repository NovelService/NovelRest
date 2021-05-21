package com.kaiserpudding.novelservice.api.dto

data class Novel(
    val id: String,
    val status: String,
    val fileId: String?
)