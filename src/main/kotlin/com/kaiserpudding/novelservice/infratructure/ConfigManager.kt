package com.kaiserpudding.novelservice.infratructure

import com.sksamuel.hoplite.ConfigLoader
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import java.nio.file.Path

@Configuration
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
class ConfigManager {

    companion object {
        private const val NOVEL_CONFIG_FILE_KEY = "NOVEL_SERVICE_CONFIG_FILE"

    }

    final val config: Config

    init {
        val file = Path.of(System.getenv(NOVEL_CONFIG_FILE_KEY))
        config = ConfigLoader().loadConfigOrThrow(file)
    }
}