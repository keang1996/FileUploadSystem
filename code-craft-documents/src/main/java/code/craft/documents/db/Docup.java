/*
 * This file is generated by jOOQ.
 */
package code.craft.documents.db;


import code.craft.documents.db.tables.DocumentInfo;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Docup extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>docup</code>
     */
    public static final Docup DOCUP = new Docup();

    /**
     * The table <code>docup.document_info</code>.
     */
    public final DocumentInfo DOCUMENT_INFO = DocumentInfo.DOCUMENT_INFO;

    /**
     * No further instances allowed
     */
    private Docup() {
        super("docup", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            DocumentInfo.DOCUMENT_INFO
        );
    }
}