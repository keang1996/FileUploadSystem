package code.craft.documents.feature.service

import code.craft.documents.Constants.StatusEnum
import code.craft.documents.Utils.getLogger
import code.craft.documents.feature.repository.UploadRepository
import code.craft.documents.model.FileDetails
import code.craft.documents.model.FileUploadResponse
import code.craft.documents.model.ResponseModel
import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.storage.BlobId
import com.google.cloud.storage.BlobInfo
import com.google.cloud.storage.StorageOptions
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.util.*


private const val BUCKET_NAME = "fileuploadservice-49838.appspot.com"
private const val MEDIA = "media"
private const val FILE_PATH = "documents"

//Url format = https://firebasestorage.googleapis.com/v0/b/{bucketName}/o/{filePath}?alt={mediaType}
private const val DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/$BUCKET_NAME/o/"

@Service
class UploadService(
        val uploadRepository: UploadRepository
) {

    val log = getLogger { }

    fun convertToFile(multipartFile: MultipartFile): Pair<File, String> {
        val tempFile = File(multipartFile.originalFilename ?: error("should have file name"))
        val extension = getExtension(tempFile.name)
        FileOutputStream(tempFile).use { fos ->
            fos.write(multipartFile.bytes)
            fos.close()
        }
        return Pair(tempFile, extension)
    }

    @Throws(IOException::class)
    fun uploadFile(file: File, fileName: String): FileDetails {
        val filePath = "$FILE_PATH/$fileName"
        val blobId = BlobId.of(BUCKET_NAME, filePath)
        val blobInfo = BlobInfo.newBuilder(blobId).setContentType(MEDIA).build()

        val inputStream = UploadService::class.java.getClassLoader().getResourceAsStream("firebase-adminsdk.json")!!
        val credentials = GoogleCredentials.fromStream(inputStream)

        val storage = StorageOptions.newBuilder().setCredentials(credentials).build().service

        storage.create(blobInfo, Files.readAllBytes(file.toPath()))
        if (!file.delete()) {
            log.warn("can not delete file in temp")
        }
        val filePathEncoded: String = URLEncoder.encode(filePath, StandardCharsets.UTF_8)
        return FileDetails(
                fileName = fileName,
                filePath = filePathEncoded,
                fileType = file.extension,
                downloadUrl = "$DOWNLOAD_URL$filePathEncoded?alt=$MEDIA"
        )
    }

    fun getExtension(fileName: String) = "." + File(fileName).takeIf { it.extension.isNotEmpty() }?.extension

    fun upload(multipartFile: MultipartFile): ResponseModel<FileUploadResponse> {
        return try {
            val file = convertToFile(multipartFile)
            val fileName = UUID.randomUUID().toString() + file.second

            val fileDetails = uploadFile(file.first, fileName)

            uploadRepository.saveDocument(fileDetails)

            log.info("Upload Success")
            ResponseModel(StatusEnum.SUCCESS.getStatusDetail(), FileUploadResponse(fileDetails.downloadUrl))
        } catch (e: IOException) {
            log.error(e.message)
            ResponseModel(StatusEnum.EXTERNAL_ERROR.getStatusDetail())
        } catch (e: Exception) {
            log.error(e.message)
            ResponseModel(StatusEnum.INTERNAL_ERROR.getStatusDetail())
        }
    }
}
