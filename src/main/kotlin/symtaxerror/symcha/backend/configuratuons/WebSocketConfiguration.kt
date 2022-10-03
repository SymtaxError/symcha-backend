package symtaxerror.symcha.backend.configuratuons

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.socket.config.annotation.*
import org.springframework.web.socket.server.HandshakeInterceptor
import java.lang.Exception

@Configuration
@EnableWebSocket
class WebSocketConfiguration(
    private val webSocketHandler: WebSocketHandler
) : WebSocketConfigurer {
    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(webSocketHandler, "/ws").addInterceptors(paramsInterceptor())
    }

    @Bean
    fun paramsInterceptor(): HandshakeInterceptor {
        return object : HandshakeInterceptor {
            override fun beforeHandshake(
                request: ServerHttpRequest,
                response: ServerHttpResponse,
                wsHandler: org.springframework.web.socket.WebSocketHandler,
                attributes: MutableMap<String, Any>
            ): Boolean {
                return true
            }

            override fun afterHandshake(
                request: ServerHttpRequest,
                response: ServerHttpResponse,
                wsHandler: org.springframework.web.socket.WebSocketHandler,
                exception: Exception?
            ) {
                println("Handshake ended")
            }
        }
    }
}