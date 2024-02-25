package code.craft.email.model

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(SnakeCaseStrategy::class)
data class RespondModel<T>(
        val status: StatusDetails,
        val data: T?
)

data class StatusDetails(
        val code: String,
        val header: String,
        val description: String
)