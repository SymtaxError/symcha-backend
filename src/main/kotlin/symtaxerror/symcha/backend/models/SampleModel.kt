package symtaxerror.symcha.backend.models

import java.util.*

data class SampleModel(
    val id: UUID,
    val name: String,
    val values: List<Int>
)