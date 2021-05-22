package com.kaiserpudding.novelservice.service.file

import com.kaiserpudding.novelservice.api.service.FileService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.nio.file.Path
import java.util.*
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.absolutePathString
import kotlin.io.path.copyTo
import kotlin.io.path.createDirectories
import kotlin.io.path.extension
import kotlin.io.path.isRegularFile
import kotlin.io.path.notExists

@ExperimentalPathApi
@Service
class FileServiceImpl : FileService {

    companion object {
        private const val NOVEL_FOLDER_KEY = "NOVEL_FOLDER_KEY"
        private const val DEFAULT_NOVEL_FOLDER = "/novel"
    }

    init {
        resolveNovelFolder().createDirectories()
    }

    override fun getNovel(id: String): Path? {
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