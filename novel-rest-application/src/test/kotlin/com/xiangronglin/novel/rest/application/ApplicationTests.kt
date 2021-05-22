package com.xiangronglin.novel.rest.application

import com.xiangronglin.novel.rest.application.infratructure.ConfigManager
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.nio.file.Paths

@SpringBootTest
class ApplicationTests {

    companion object {
        @BeforeAll
        @JvmStatic
        fun beforeAll() {
            val configFile =
                Paths.get("src", "test", "resources", "novel-service-config.yml").toAbsolutePath().toString()
            System.setProperty(ConfigManager.NOVEL_CONFIG_FILE_KEY, configFile)
        }
    }

    @Test
    fun contextLoads() {
    }

}
