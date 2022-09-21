package symtaxerror.symcha.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SymchaBackendApplication

fun main(args: Array<String>) {
    runApplication<SymchaBackendApplication>(*args)
}
