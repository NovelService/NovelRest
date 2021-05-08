package com.kaiserpudding.novelservice.db

import com.kaiserpudding.novelservice.db.model.NovelEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface NovelRepository : CrudRepository<NovelEntity, UUID>