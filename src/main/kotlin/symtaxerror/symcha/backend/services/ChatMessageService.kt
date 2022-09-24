package symtaxerror.symcha.backend.services

import org.springframework.stereotype.Service
import symtaxerror.symcha.backend.entities.ChatMessageEntity
import symtaxerror.symcha.backend.models.ChatMessage
import symtaxerror.symcha.backend.repositories.ChatMessageRepository

@Service
class ChatMessageService(
    val chatMessageRepository: ChatMessageRepository,
) {
    fun save(chatMessage: ChatMessage) =
        chatMessageRepository.insert(ChatMessageEntity.fromModel(chatMessage))

    fun get(id: String) =
        chatMessageRepository.getById(id)

    fun getForUser(userId: String) =
        chatMessageRepository.getByRecepientId(userId)
}