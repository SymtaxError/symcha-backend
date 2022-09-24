package symtaxerror.symcha.backend.models

import java.sql.Timestamp

data class ChatMessage(
    val id: String,
    val senderId: String,
    val recipientId: String,
    val content: String,
    val date: Timestamp,
)
