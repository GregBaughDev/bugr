import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.server.WebSocketServer
import java.lang.Exception
import java.net.InetSocketAddress

class SocketServer(address: InetSocketAddress): WebSocketServer(address) {
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
    }

}