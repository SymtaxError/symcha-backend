package symtaxerror.symcha.backend.repositories

import io.ebean.Database
import io.ebean.DuplicateKeyException
import org.springframework.stereotype.Repository
import symtaxerror.symcha.backend.entities.SampleEntity
import symtaxerror.symcha.backend.entities.SampleInsertableEntity
import symtaxerror.symcha.backend.models.SampleModel

@Repository
class SampleRepository(
    private val db: Database
) {
    fun save(model: SampleModel): SampleModel {
        SampleInsertableEntity.fromModel(model).also {
            try {
                db.save(it)
            } catch (_: DuplicateKeyException) {
                db.update(it)
            }
        }
        return db.find(SampleEntity::class.java, model.id)?.toModel()
            ?: throw Exception("You should make this one a custom exception")
    }

    fun getAll(): List<SampleModel> =
        db.find(SampleEntity::class.java)
            .findList()
            .map { it.toModel() }
}