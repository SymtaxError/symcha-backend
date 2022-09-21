package symtaxerror.symcha.backend.entities

import symtaxerror.symcha.backend.models.SampleModel
import java.util.*
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(schema = "test", name = "samples")
data class SampleEntity(
    @Id
    val id: UUID,
    val name: String,
    @OneToMany(cascade = [CascadeType.ALL])
    val values: List<SampleValueEntity>
) {
    fun toModel() = SampleModel(id, name, values.map { it.value })
}

@Entity
@Table(schema = "test", name = "samples")
data class SampleInsertableEntity(
    @Id
    val id: UUID,
    val name: String
) {
    companion object {
        fun fromModel(model: SampleModel) = SampleInsertableEntity(model.id, model.name)
    }
}