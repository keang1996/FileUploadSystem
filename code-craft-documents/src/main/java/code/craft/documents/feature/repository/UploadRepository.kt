package code.craft.documents.feature.repository

import code.craft.documents.db.tables.DocumentInfo.DOCUMENT_INFO
import code.craft.documents.model.FileDetails
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class UploadRepository(
        val dsl: DSLContext
) {
    fun saveDocument(fileDetails: FileDetails) =
            dsl.insertInto(DOCUMENT_INFO, DOCUMENT_INFO.FILE_NAME, DOCUMENT_INFO.FILE_PATH, DOCUMENT_INFO.FILE_TYPE, DOCUMENT_INFO.DOWNLOAD_URL)
                .values(fileDetails.fileName, fileDetails.filePath, fileDetails.fileType, fileDetails.downloadUrl)
                .execute() == 1
}
