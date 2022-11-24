package consumer

import consumer.config.TopicConfig
import org.apache.kafka.clients.consumer.KafkaConsumer

class Consumer(val consumer: KafkaConsumer<String, Any>) {
    fun subscribeConsumer(): Unit {
        consumer.subscribe(arrayListOf(TopicConfig.bugr.toString()))
    }
}