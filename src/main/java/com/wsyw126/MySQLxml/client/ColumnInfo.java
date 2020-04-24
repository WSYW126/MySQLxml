package com.wsyw126.MySQLxml.client;

import com.wsyw126.MySQLxml.config.SQLTableSchema;
import com.wsyw126.MySQLxml.exception.SQLException;
import com.wsyw126.MySQLxml.utils.StringUtil;
import com.wsyw126.MySQLxml.utils.Util;
import com.wsyw126.MySQLxml.utils.XmlUtil;
import org.w3c.dom.Node;

import java.lang.reflect.Field;

/**
 * POJO's field and db table's column mapping info.
 */
public class ColumnInfo {

    /**
     * parse column info from node.
     */
    static ColumnInfo parseNode(Class<?> type, Node node,
                                SQLTableSchema sqlTableSchema) {
        Util.checkNull(node);
        Util.checkNull(sqlTableSchema);

        if (!"field".equals(node.getNodeName())) {
            return null;
        }

        String name = XmlUtil.getAttr(node, "name");
        if (StringUtil.isEmptyString(name)) {
            throw new SQLException("column info miss name. type = "
                    + type);
        }

        Field field = null;
        try {
            field = type.getDeclaredField(name);
            field.setAccessible(true);
        } catch (Exception e) {
            throw new SQLException(
                    "can't find named field in type. type = " + type
                            + " name = " + name, e);
        }

        String column = XmlUtil.getAttr(node, "column");
        if (StringUtil.isEmptyString(column)) {
            //use name as qualifier.
            column = field.getName();
        }

        ColumnInfo columnInfo = new ColumnInfo();
        columnInfo.type = type;
        columnInfo.field = field;
        columnInfo.column = column;

        return columnInfo;
    }

    /**
     * parse column info in air.
     */
    static ColumnInfo parseInAir(Class<?> type, Field field) {

        //use field name as qualifier.
        String column = field.getName();

        ColumnInfo columnInfo = new ColumnInfo();
        columnInfo.type = type;
        columnInfo.field = field;
        columnInfo.column = column;

        return columnInfo;

    }

    /**
     * Parse ColumnInfo from POJO's field.
     *
     * @param type  POJO's class type.
     * @param field POJO' field.
     * @return ColumnInfo.
     */
    static ColumnInfo parse(Class<?> type, Field field) {
        SQLColumn sqlColumn = field.getAnnotation(SQLColumn.class);
        if (sqlColumn == null) {
            return null;
        }

        String column = sqlColumn.column();

        if (StringUtil.isEmptyString(column)) {
            throw new SQLException("qualifier is null or empty. type="
                    + type + " field=" + field);
        }

        ColumnInfo columnInfo = new ColumnInfo();
        columnInfo.type = type;
        columnInfo.field = field;
        columnInfo.column = column;

        return columnInfo;
    }

    /**
     * POJO's class type.
     */
    Class<?> type;
    /**
     * POJO's field.
     */
    Field field;
    /**
     * db column.
     */
    String column;

    private ColumnInfo() {
    }

    @Override
    public String toString() {
        return "type=" + type + " field=" + field
                + " column=" + column;
    }
}