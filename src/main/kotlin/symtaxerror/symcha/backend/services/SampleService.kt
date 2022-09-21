package symtaxerror.symcha.backend.services

import org.springframework.stereotype.Service
import symtaxerror.symcha.backend.models.SampleModel
import symtaxerror.symcha.backend.repositories.SampleRepository

@Service
class SampleService(
    val sampleRepository: SampleRepository
) {
    fun getAll(): List<SampleModel> = sampleRepository.getAll()

    fun saveOrUpdate(sample: SampleModel) {
        sampleRepository.save(sample)
    }
}