package com.xiangronglin.novel.rest.application.db.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "novel")
data class NovelEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID = UUID.randomUUID(),

    @Column
    var status: String = "received",

    @Column
    var fileId: String? = null
)
