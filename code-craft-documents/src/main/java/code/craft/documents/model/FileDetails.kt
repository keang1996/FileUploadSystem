package code.craft.documents.model

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

data class FileDetails(
        val fileName: String,
        val fileType: String,
        val filePath: String,
        val downloadUrl: String
)

@JsonNaming(SnakeCaseStrategy::class)
data class FileUploadResponse(
        val downloadUrl: String
)