package code.craft.documents.model

data class ResponseModel<T>(
        val status: StatusDetail,
        val data: T? = null
)

data class StatusDetail(
        val code: String,
        val header: String,
        val description: String
)
