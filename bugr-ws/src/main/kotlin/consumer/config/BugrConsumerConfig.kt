package consumer.config

import consumer.CustomDeserializer
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer

class BugrConsumerConfig {
    private val bootstrapServers: String = "localhost:9092"

    private fun consumerConfig(): Map<String, Any> {
        var props = mutableMapOf<String, Any>()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServers
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        return props
    }

    fun consumer(): KafkaConsumer<String, Any> {
        return KafkaConsumer<String, Any>(consumerConfig())
    }

//    fun createConsumer(): KafkaConsumer<String, Any> {
//        return consumer(consumerConfig())
//    }
}