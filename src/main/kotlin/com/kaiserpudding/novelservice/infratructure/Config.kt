package com.kaiserpudding.novelservice.infratructure

import com.sksamuel.hoplite.Masked

data class Config(
    val db: DbConfig,
    val amq: AmqConfig
)

data class DbConfig(
    val url: String,
    val username: String,
    val password: Masked
)

data class AmqConfig(
    val url: String,
    val username: String,
    val password: Masked
)