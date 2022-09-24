package symtaxerror.symcha.backend.controllers

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller
import symtaxerror.symcha.backend.models.ChatMessage
import symtaxerror.symcha.backend.services.ChatMessageService

@Controller
class ChatController(
    val messagingTemplate: SimpMessagingTemplate,
    val chatMessageService: ChatMessageService
) {
    @MessageMapping("/chat")
    fun processMessage(@Payload chatMessage: ChatMessage) {
        chatMessageService.save(chatMessage)
        messagingTemplate.convertAndSendToUser(
            chatMessage.recipientId,
            "/queue/messages",
            chatMessage
        )
    }
}