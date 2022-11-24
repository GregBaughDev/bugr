import consumer.Consumer
import consumer.config.BugrConsumerConfig
import consumer.config.TopicConfig
import org.apache.kafka.clients.consumer.ConsumerRecords
import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.server.WebSocketServer
import java.lang.Exception
import java.net.InetSocketAddress
import java.time.Duration

class SocketServer(address: InetSocketAddress): WebSocketServer(address) {
    private val consumerConfig: BugrConsumerConfig = BugrConsumerConfig()
    private val consumer: Consumer = Consumer(consumerConfig.consumer())

    override fun onOpen(conn: WebSocket?, handshake: ClientHandshake?) {
        conn?.send("Welcome to the server")
    }

    override fun onClose(conn: WebSocket?, code: Int, reason: String?, remote: Boolean) {
        println("Connection closed")
    }

    override fun onMessage(conn: WebSocket?, message: String?) {
        println(message)
    }

    override fun onError(conn: WebSocket?, ex: Exception?) {
        println("Socket error")
    }

    override fun onStart() {
        println("Server started")
        consumer.subscribeConsumer()
        while (true) {
            var records: ConsumerRecords<String, Any> = consumer.consumer.poll(Duration.ofMillis(1000))
            for (record in records) {
                println(record)
            }
        }
    }

}