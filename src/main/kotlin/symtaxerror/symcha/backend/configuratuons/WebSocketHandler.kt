package symtaxerror.symcha.backend.configuratuons

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.treeToValue
import org.springframework.stereotype.Component
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.util.concurrent.CopyOnWriteArrayList

data class SimpleMessage(
    val targetId: String,
    val message: String
)

@Component
class WebSocketHandler(
    private val objectMapper: ObjectMapper
) : TextWebSocketHandler() {
    val sessions: MutableList<WebSocketSession> = CopyOnWriteArrayList();

    override fun afterConnectionEstablished(session: WebSocketSession) {
        println(session)
        sessions.add(session)
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        println(message)
        try {
            val json = objectMapper.readTree(message.asBytes())
            println(json)
            val msg: SimpleMessage = objectMapper.treeToValue(json)
            println(msg)
        } catch (_: Exception) {
            println("incorrect")
        }
    }
}