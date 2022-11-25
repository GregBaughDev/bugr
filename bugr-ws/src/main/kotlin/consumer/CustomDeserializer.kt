package consumer

import com.fasterxml.jackson.databind.ObjectMapper
import consumer.config.MessageDto
import org.apache.kafka.common.serialization.Deserializer

class CustomDeserializer: Deserializer<MessageDto> {
    private val objectMapper: ObjectMapper = ObjectMapper()

    override fun deserialize(topic: String?, data: ByteArray?): MessageDto {
        return objectMapper.readValue(data?.let { String(it) }, MessageDto::class.java)
    }
}