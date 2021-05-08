package com.kaiserpudding.novelservice.infratructure

import com.sksamuel.hoplite.Masked

data class Config(
    val dbConfig: DbConfig
)

data class DbConfig(
    val url: String,
    val username: String,
    val password: Masked
)