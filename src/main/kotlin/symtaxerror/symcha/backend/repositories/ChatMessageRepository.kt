package symtaxerror.symcha.backend.repositories

import io.ebean.Database
import org.springframework.stereotype.Repository
import symtaxerror.symcha.backend.entities.ChatMessageEntity

@Repository
class ChatMessageRepository(
    val db: Database
) {
    fun insert(chatMessageEntity: ChatMessageEntity) {
        db.insert(chatMessageEntity)
    }

    fun getById(id: String) =
        db.find(ChatMessageEntity::class.java, id)?.toModel()

    fun getByRecepientId(recipientId: String) =
        db.find(ChatMessageEntity::class.java)
            .where().eq("recipient_id", recipientId)
            .findList()
            .map { it.toModel() }

}