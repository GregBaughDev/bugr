package consumer.config

import consumer.CustomDeserializer
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import java.util.Properties

class BugrConsumerConfig {
    private val bootstrapServers: String = "localhost:9092"

    private fun consumerConfig(): Properties {
        var props = Properties()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServers
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = CustomDeserializer::class.java
        props[ConsumerConfig.GROUP_ID_CONFIG] = TopicConfig.bugr.toString()
        return props
    }

    fun consumer(): KafkaConsumer<String, MessageDto> {
        return KafkaConsumer<String, MessageDto>(consumerConfig())
    }
}