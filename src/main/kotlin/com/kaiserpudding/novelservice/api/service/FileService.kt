package com.kaiserpudding.novelservice.api.service

import java.nio.file.Path

interface FileService {

    fun saveNovel(file: Path): String

    fun getNovel(id: String): Path
}