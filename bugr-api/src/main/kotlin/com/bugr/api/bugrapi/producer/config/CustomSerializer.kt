package com.bugr.api.bugrapi.producer.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Serializer

class CustomSerializer: Serializer<MessageDto> {
    private val objectMapper: ObjectMapper = ObjectMapper()

    override fun serialize(topic: String?, data: MessageDto?): ByteArray {
        return objectMapper.writeValueAsBytes(data)
    }
}