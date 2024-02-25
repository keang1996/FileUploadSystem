package code.craft.email.service

import code.craft.email.model.RespondModel
import code.craft.email.model.StatusDetails
import jakarta.mail.Message
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessagePreparator
import org.springframework.stereotype.Service

@Service
class EmailService(
        private val mailSender: JavaMailSender
) {
    fun sendEmail(emailTo: String): RespondModel<String> {
        val mimeMessage = MimeMessagePreparator { mimeMessage ->
            mimeMessage.setRecipients(Message.RecipientType.TO, emailTo)
            mimeMessage.subject = "test"
            mimeMessage.setText("test")
        }

        mailSender.send(mimeMessage)

        return RespondModel(StatusDetails("dd", "dd", "dd"), null)
    }
}