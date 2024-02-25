package code.craft.email.feature

import code.craft.email.model.EmailRequest
import code.craft.email.model.RespondModel
import code.craft.email.service.EmailService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class EmailController(
        val emailService: EmailService
) {
    @PostMapping("/v1/send")
    fun sendEmail(
            @RequestBody emailRequest: EmailRequest
    ):ResponseEntity<RespondModel<String>> {
        return ResponseEntity.ok(emailService.sendEmail(emailRequest.emailTo))
    }
}