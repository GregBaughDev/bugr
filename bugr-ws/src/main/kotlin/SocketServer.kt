import consumer.Consumer
import consumer.config.BugrConsumerConfig
import consumer.config.MessageDto
import consumer.config.TopicConfig
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
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
        // send a message to the socket -> check the records for the user
        // I think we still need to call the below everyone 1 sec?
        var records: ConsumerRecords<String, MessageDto> = consumer.consumer.poll(Duration.ofMillis(1))
        for (record in records) {
            println("${record.value().chatId}: chatid")
            println("${record.value().userId}: userid")
        }
    }

    override fun onError(conn: WebSocket?, ex: Exception?) {
        println("Socket error")
        ex?.printStackTrace()
    }

    override fun onStart(): Unit = runBlocking {
        println("Server started")
    }

    suspend fun handleConsumer() {
        // Move the below to co-routine
        while (true) {
            delay(10000)
            var records: ConsumerRecords<String, MessageDto> = consumer.consumer.poll(Duration.ofMillis(1))
            for (record in records) {
                println("${record.value().chatId}: chatid")
                println("${record.value().userId}: userid")
            }
        }
    }

}