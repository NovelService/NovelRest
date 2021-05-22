package com.xiangronglin.novel.rest.application.service.file

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.InputStreamResource
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.fileSize
import kotlin.io.path.inputStream

@ExperimentalPathApi
@RestController
@RequestMapping("/file")
class FileController(
    @Autowired private val fileService: FileService
) {

    companion object {
        private val LOG = LoggerFactory.getLogger(FileController::class.java)
    }

    @GetMapping("/{id}")
    fun downloadFile(@PathVariable(name = "id") id: String): ResponseEntity<Resource> {
        LOG.info("GET file/$id")
        val file = fileService.getNovel(id) ?: return ResponseEntity.notFound().build()

        val resource = InputStreamResource(file.inputStream())

        return ResponseEntity.ok()
            .header("Content-Disposition", "attachment; filename=$id")
            .contentLength(file.fileSize())
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .body(resource)
    }
}