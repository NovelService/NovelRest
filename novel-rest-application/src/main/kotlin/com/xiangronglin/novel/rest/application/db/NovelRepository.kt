package com.xiangronglin.novel.rest.application.db

import com.xiangronglin.novel.rest.application.db.model.NovelEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface NovelRepository : CrudRepository<NovelEntity, UUID>