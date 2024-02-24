/*
 * This file is generated by jOOQ.
 */
package code.craft.documents.db.tables.records;


import code.craft.documents.db.tables.DocumentInfo;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class DocumentInfoRecord extends UpdatableRecordImpl<DocumentInfoRecord> implements Record6<Integer, String, String, String, String, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>docup.document_info.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>docup.document_info.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>docup.document_info.file_name</code>.
     */
    public void setFileName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>docup.document_info.file_name</code>.
     */
    public String getFileName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>docup.document_info.file_type</code>.
     */
    public void setFileType(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>docup.document_info.file_type</code>.
     */
    public String getFileType() {
        return (String) get(2);
    }

    /**
     * Setter for <code>docup.document_info.file_path</code>.
     */
    public void setFilePath(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>docup.document_info.file_path</code>.
     */
    public String getFilePath() {
        return (String) get(3);
    }

    /**
     * Setter for <code>docup.document_info.download_url</code>.
     */
    public void setDownloadUrl(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>docup.document_info.download_url</code>.
     */
    public String getDownloadUrl() {
        return (String) get(4);
    }

    /**
     * Setter for <code>docup.document_info.created_date</code>.
     */
    public void setCreatedDate(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>docup.document_info.created_date</code>.
     */
    public LocalDateTime getCreatedDate() {
        return (LocalDateTime) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, String, String, String, LocalDateTime> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Integer, String, String, String, String, LocalDateTime> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return DocumentInfo.DOCUMENT_INFO.ID;
    }

    @Override
    public Field<String> field2() {
        return DocumentInfo.DOCUMENT_INFO.FILE_NAME;
    }

    @Override
    public Field<String> field3() {
        return DocumentInfo.DOCUMENT_INFO.FILE_TYPE;
    }

    @Override
    public Field<String> field4() {
        return DocumentInfo.DOCUMENT_INFO.FILE_PATH;
    }

    @Override
    public Field<String> field5() {
        return DocumentInfo.DOCUMENT_INFO.DOWNLOAD_URL;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return DocumentInfo.DOCUMENT_INFO.CREATED_DATE;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getFileName();
    }

    @Override
    public String component3() {
        return getFileType();
    }

    @Override
    public String component4() {
        return getFilePath();
    }

    @Override
    public String component5() {
        return getDownloadUrl();
    }

    @Override
    public LocalDateTime component6() {
        return getCreatedDate();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getFileName();
    }

    @Override
    public String value3() {
        return getFileType();
    }

    @Override
    public String value4() {
        return getFilePath();
    }

    @Override
    public String value5() {
        return getDownloadUrl();
    }

    @Override
    public LocalDateTime value6() {
        return getCreatedDate();
    }

    @Override
    public DocumentInfoRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public DocumentInfoRecord value2(String value) {
        setFileName(value);
        return this;
    }

    @Override
    public DocumentInfoRecord value3(String value) {
        setFileType(value);
        return this;
    }

    @Override
    public DocumentInfoRecord value4(String value) {
        setFilePath(value);
        return this;
    }

    @Override
    public DocumentInfoRecord value5(String value) {
        setDownloadUrl(value);
        return this;
    }

    @Override
    public DocumentInfoRecord value6(LocalDateTime value) {
        setCreatedDate(value);
        return this;
    }

    @Override
    public DocumentInfoRecord values(Integer value1, String value2, String value3, String value4, String value5, LocalDateTime value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DocumentInfoRecord
     */
    public DocumentInfoRecord() {
        super(DocumentInfo.DOCUMENT_INFO);
    }

    /**
     * Create a detached, initialised DocumentInfoRecord
     */
    public DocumentInfoRecord(Integer id, String fileName, String fileType, String filePath, String downloadUrl, LocalDateTime createdDate) {
        super(DocumentInfo.DOCUMENT_INFO);

        setId(id);
        setFileName(fileName);
        setFileType(fileType);
        setFilePath(filePath);
        setDownloadUrl(downloadUrl);
        setCreatedDate(createdDate);
        resetChangedOnNotNull();
    }
}
