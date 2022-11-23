package com.bugr.api.bugrapi.producer.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class TopicConfig {
    @Bean
    fun bugrTopic(): NewTopic {
        return TopicBuilder.name("bugr").build();
    }
}