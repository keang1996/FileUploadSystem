package code.craft.documents.Constants

import code.craft.documents.model.StatusDetail

enum class StatusEnum(val code: String, val header: String, val description: String) {
    SUCCESS(code = "200", header = "success", description = "success"),
    BAD_REQUEST(code = "400", header = "bad request", description = "bad request"),
    INTERNAL_ERROR(code = "5001", header = "internal error", description = "have error in system"),
    EXTERNAL_ERROR(code = "5002", header = "external error", description = "have error at third party");

    fun getStatusDetail() = StatusDetail(code, header, description)
}