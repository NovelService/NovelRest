package com.kaiserpudding.novelservice.worker

fun String.replaceInvalidFilenameChar(): String {
    return this.replace("[\\\\/:*?\"<>|]".toRegex(), "_")
}