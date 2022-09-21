package symtaxerror.symcha.backend.entities

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(schema = "test", name = "sample_values")
data class SampleValueEntity(
    @Id
    val id: UUID,
    val sampleId: UUID,
    val value: Int
)
