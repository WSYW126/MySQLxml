package com.wsyw126.MySQLxml.config;

import com.wsyw126.MySQLxml.exception.SQLException;
import com.wsyw126.MySQLxml.type.DefaultTypeHandlers;
import com.wsyw126.MySQLxml.type.TypeHandler;
import com.wsyw126.MySQLxml.type.TypeHandlerHolder;
import com.wsyw126.MySQLxml.utils.ClassUtil;
import com.wsyw126.MySQLxml.utils.StringUtil;
import com.wsyw126.MySQLxml.utils.Util;
import org.apache.log4j.Logger;

/**
 * Table's column's schema.
 *
 * <pre>
 * Including all meta data of Table column.
 * </pre>
 */
public class SQLColumnSchema {
    /**
     * log.
     */
    private static Logger log = Logger.getLogger(SQLColumnSchema.class);

    // ----------config------
    /**
     * tableName.
     */
    @ConfigAttr
    private String tableName;

    /**
     * column.
     */
    @ConfigAttr
    private String column;

    /**
     * javaType.
     */
    @ConfigAttr
    private String typeName;
    /**
     * typeHandler's type.
     */
    @ConfigAttr
    private String typeHandlerName;

    // -----------runtime------
    /**
     * javaType.
     */
    private Class<?> type;
    /**
     * TypeHandler instance.
     */
    private TypeHandler typeHandler;

    /**
     * Init.
     */
    public void init() {

        Util.checkEmptyString(tableName);
        Util.checkEmptyString(column);
        Util.checkEmptyString(typeName);

        try {
            type = ClassUtil.forName(typeName);
            Util.checkNull(type);

            if (StringUtil.isEmptyString(typeHandlerName)) {
                typeHandler = DefaultTypeHandlers.findDefaultHandler(type);
                typeHandlerName = typeHandler.getClass().getName();
            } else {
                typeHandler = TypeHandlerHolder
                        .findTypeHandler(typeHandlerName);
            }

            Util.checkNull(typeHandlerName);
            Util.checkNull(typeHandler);

        } catch (Exception e) {
            log.error(e);
            throw new SQLException(e);
        }
    }

    /**
     * Getter method for property <tt>tableName</tt>.
     *
     * @return property value of tableName
     */
    public String getTableName() {
        return tableName;
    }


    /**
     * Setter method for property <tt>tableName</tt>.
     *
     * @param tableName value to be assigned to property tableName
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * Getter method for property <tt>column</tt>.
     *
     * @return property value of column
     */
    public String getColumn() {
        return column;
    }

    /**
     * Setter method for property <tt>column</tt>.
     *
     * @param column value to be assigned to property column
     */
    public void setColumn(String column) {
        this.column = column;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeHandlerName() {
        return typeHandlerName;
    }

    public void setTypeHandlerName(String typeHandlerName) {
        this.typeHandlerName = typeHandlerName;
    }

    public Class<?> getType() {
        return type;
    }

    public TypeHandler getTypeHandler() {
        return typeHandler;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[tableName=" + tableName + ",");
        sb.append("column=" + column + ",");
        sb.append("typeName=" + typeName + ",");
        sb.append("typeHandlerName=" + typeHandlerName + "]");
        return sb.toString();
    }
}
