package consumer

import consumer.config.MessageDto
import consumer.config.TopicConfig
import org.apache.kafka.clients.consumer.KafkaConsumer

class Consumer(val consumer: KafkaConsumer<String, MessageDto>) {
    fun subscribeConsumer(): Unit {
        return consumer.subscribe(arrayListOf(TopicConfig.bugr.toString()))
    }
}