package com.kaiserpudding.novelservice.api.service

import java.nio.file.Path

interface FileService {

    fun getNovel(id: String): Path?
}