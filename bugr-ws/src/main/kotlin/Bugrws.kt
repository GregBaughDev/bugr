import org.java_websocket.server.WebSocketServer
import java.net.InetSocketAddress

fun main(args: Array<String>) {
    println("*****************")
    println("WS server started")
    println("*****************")

    val host: String = "localhost"
    val port: Int = 8887

    val server: WebSocketServer = SocketServer(InetSocketAddress(host, port))
    server.run()
}
