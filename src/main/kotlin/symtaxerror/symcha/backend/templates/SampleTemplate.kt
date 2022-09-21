package symtaxerror.symcha.backend.templates

import symtaxerror.symcha.backend.models.SampleModel
import java.util.*

data class SampleTemplate(
    val id: UUID,
    val name: String,
    val values: List<Int>
) {
    fun toModel() = SampleModel(id, name, values)

    companion object {
        fun fromModel(model: SampleModel) = SampleTemplate(model.id, model.name, model.values)
    }
}
