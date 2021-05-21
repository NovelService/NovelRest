package com.kaiserpudding.novelservice.service.file

import com.kaiserpudding.novelservice.api.service.FileService
import org.springframework.stereotype.Service
import java.nio.file.Path
import java.util.*
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.copyTo
import kotlin.io.path.createDirectories
import kotlin.io.path.extension
import kotlin.io.path.isRegularFile

@ExperimentalPathApi
@Service
class FileServiceImpl : FileService {

    companion object {
        private const val NOVEL_FOLDER_KEY = "NOVEL_FOLDER_KEY"
    }

    override fun saveNovel(file: Path): String {
        if (!file.isRegularFile()) {
            throw IllegalArgumentException("Not a file")
        }
        val filename = UUID.randomUUID().toString() + "." + file.extension
        val destination = resolveNovelFolder().resolve(filename)
        destination.createDirectories()
        file.copyTo(destination, false)

        return filename
    }

    override fun getNovel(filename: String): Path {
        return resolveNovelFolder().resolve(filename)
    }

    private fun resolveNovelFolder(): Path {
        return Path.of(System.getenv(NOVEL_FOLDER_KEY))
    }
}