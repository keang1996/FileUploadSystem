package code.craft.documents.feature.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class UploadController {
    @PostMapping("/v1/upload")
    fun uploadDoc(): ResponseEntity<String> {
        return ResponseEntity.ok().body("");
    }
}
