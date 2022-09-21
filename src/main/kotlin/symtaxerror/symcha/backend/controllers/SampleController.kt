package symtaxerror.symcha.backend.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import symtaxerror.symcha.backend.services.SampleService
import symtaxerror.symcha.backend.templates.SampleTemplate

@RestController
@RequestMapping("/samples")
class SampleController(
    val sampleService: SampleService
) {
    @GetMapping
    fun getAllSamples(): List<SampleTemplate> = sampleService.getAll().map { SampleTemplate.fromModel(it) }

    @PostMapping
    fun saveOrUpdateSample(sample: SampleTemplate) {
        sampleService.saveOrUpdate(sample.toModel())
    }
}