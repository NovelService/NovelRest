package com.kaiserpudding.novelservice.infratructure

import org.apache.activemq.ActiveMQConnectionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.annotation.EnableJms
import org.springframework.jms.core.JmsTemplate


@EnableJms
@Configuration
class AmqConfigurator {

    companion object {
        const val NOVEL_QUEUE = "novel"
    }

    @Autowired
    private lateinit var configManager: ConfigManager

    @Bean
    fun connectionFactory(): ActiveMQConnectionFactory {
        val connectionFactory = ActiveMQConnectionFactory()

        val amqConfig = configManager.config.amq
        connectionFactory.brokerURL = amqConfig.url
        connectionFactory.userName = amqConfig.username
        connectionFactory.password = amqConfig.password.value
        connectionFactory.trustedPackages = listOf("com.kaiserpudding.novelservice")
        return connectionFactory
    }

    @Bean
    fun jmsTemplate(): JmsTemplate {
        val template = JmsTemplate(connectionFactory())
        template.defaultDestinationName = NOVEL_QUEUE
        return template
    }
}