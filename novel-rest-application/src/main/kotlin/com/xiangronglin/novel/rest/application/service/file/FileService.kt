package com.xiangronglin.novel.rest.application.service.file

import org.springframework.stereotype.Service
import java.nio.file.Path
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.createDirectories
import kotlin.io.path.notExists

@ExperimentalPathApi
@Service
class FileService {

    companion object {
        private const val NOVEL_FOLDER_KEY = "NOVEL_FOLDER_KEY"
        private const val DEFAULT_NOVEL_FOLDER = "/novel"
    }

    init {
        resolveNovelFolder().createDirectories()
    }

    fun getNovel(id: String): Path? {
        val file = resolveNovelFolder().resolve(id)

        if (file.notExists()) {
            return null
        }

        return file
    }

    private fun resolveNovelFolder(): Path {
        return Path.of(System.getProperty(NOVEL_FOLDER_KEY, DEFAULT_NOVEL_FOLDER))
    }
}