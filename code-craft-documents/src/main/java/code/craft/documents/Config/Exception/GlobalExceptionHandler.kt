package code.craft.documents.Config.Exception

import code.craft.documents.Constants.StatusEnum
import code.craft.documents.Utils.getLogger
import code.craft.documents.model.ResponseModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.multipart.MultipartException

@ControllerAdvice
class GlobalExceptionHandler {

    val log = getLogger {  }

    @ExceptionHandler(MultipartException::class)
    fun badRequestHandler(e: Exception): ResponseEntity<ResponseModel<Any>> {
        log.error(e.message)
        return ResponseEntity(ResponseModel(StatusEnum.BAD_REQUEST.getStatusDetail()), HttpStatus.BAD_REQUEST)
    }
}