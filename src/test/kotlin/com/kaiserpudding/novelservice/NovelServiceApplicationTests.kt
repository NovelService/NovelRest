package com.kaiserpudding.novelservice

import com.kaiserpudding.novelservice.infratructure.ConfigManager
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.nio.file.Paths

@SpringBootTest
class NovelServiceApplicationTests {

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
