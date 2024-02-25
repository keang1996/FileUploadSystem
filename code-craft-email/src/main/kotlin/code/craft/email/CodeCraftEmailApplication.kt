package code.craft.email

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CodeCraftEmailApplication

fun main(args: Array<String>) {
    runApplication<CodeCraftEmailApplication>(*args)
}
