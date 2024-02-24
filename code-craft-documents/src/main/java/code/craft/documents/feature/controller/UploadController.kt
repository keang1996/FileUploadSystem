package code.craft.documents.feature.controller

import code.craft.documents.feature.service.UploadService
import code.craft.documents.model.FileUploadResponse
import code.craft.documents.model.ResponseModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api")
class UploadController (
        private val uploadService: UploadService) {
    @PostMapping("/v1/upload")
    fun uploadDoc(@RequestParam("file") multipartFile: MultipartFile): ResponseEntity<ResponseModel<FileUploadResponse>> {
        return ResponseEntity.ok(uploadService.upload(multipartFile))
    }
}
