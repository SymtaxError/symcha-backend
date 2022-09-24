package symtaxerror.symcha.backend.entities

import symtaxerror.symcha.backend.models.ChatMessage
import java.sql.Timestamp
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(schema = "test", name = "messages")
data class ChatMessageEntity(
    @Id
    val id: String,
    val senderId: String,
    val recipientId: String,
    val content: String,
    val date: Timestamp,
) {
    companion object {
        fun fromModel(model: ChatMessage) =
            ChatMessageEntity(
                id = model.id,
                senderId = model.senderId,
                recipientId = model.recipientId,
                content = model.content,
                date = model.date
            )
    }

    fun toModel() =
        ChatMessage(
            id = this.id,
            senderId = this.senderId,
            recipientId = this.recipientId,
            content = this.content,
            date = this.date
        )
}
