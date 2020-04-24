package com.wsyw126.MySQLxml.client;

import com.wsyw126.MySQLxml.config.SQLTableSchema;
import com.wsyw126.MySQLxml.exception.SQLException;
import com.wsyw126.MySQLxml.utils.ClassUtil;
import com.wsyw126.MySQLxml.utils.StringUtil;
import com.wsyw126.MySQLxml.utils.Util;
import com.wsyw126.MySQLxml.utils.XmlUtil;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * POJO type and Hbase table mapping info.
 *
 * @author xinzhi
 */
public class TypeInfo {

    /**
     * Parse TypeInfo from POJO's type.
     *
     * @param type POJO's type.
     * @return TypeInfo.
     */
    public static TypeInfo parse(Class<?> type) {
        Util.checkNull(type);

        TypeInfo typeInfo = new TypeInfo();
        typeInfo.type = type;

        Field[] fields = type.getDeclaredFields();

        for (Field field : fields) {

            field.setAccessible(true);

            ColumnInfo columnInfo = ColumnInfo.parse(type, field);
            if (columnInfo == null) {
                continue;
            }

            typeInfo.columnInfos.add(columnInfo);

        }

        typeInfo.init();

        return typeInfo;
    }

    /**
     * Parse TypeInfo from POJO's type and SQLTableSchema.
     */
    public static TypeInfo parseInAir(Class<?> type,
                                      SQLTableSchema sqlTableSchema) {
        Util.checkNull(type);
        Util.checkNull(sqlTableSchema);

        TypeInfo typeInfo = new TypeInfo();
        typeInfo.type = type;
        Field[] fields = type.getDeclaredFields();

        for (Field field : fields) {

            field.setAccessible(true);

            //don't handle static field.
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }

            ColumnInfo columnInfo = ColumnInfo.parseInAir(type, field);

            if (columnInfo == null) {
                continue;
            }

            typeInfo.columnInfos.add(columnInfo);

        }

        typeInfo.init();

        return typeInfo;
    }

    /**
     * Parse TypeInfo from Node.
     */
    public static TypeInfo parseNode(Node node,
                                     SQLTableSchema hbaseTableSchema) {
        Util.checkNull(node);
        Util.checkNull(hbaseTableSchema);

        TypeInfo typeInfo = new TypeInfo();

        String typeName = XmlUtil.getAttr(node, "className");
        if (StringUtil.isEmptyString(typeName)) {
            throw new SQLException("No class name attr.");
        }

        Class<?> type = ClassUtil.forName(typeName);
        typeInfo.type = type;

        NodeList nodeList = node.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node fieldNode = nodeList.item(i);
            ColumnInfo columnInfo = ColumnInfo.parseNode(type, fieldNode,
                    hbaseTableSchema);
            if (columnInfo == null) {
                continue;
            }
            typeInfo.columnInfos.add(columnInfo);
        }

        typeInfo.init();

        return typeInfo;
    }

    /**
     * POJO's type.
     */
    private Class<?> type;
    /**
     * POJO's ColumnInfo list.
     */
    private List<ColumnInfo> columnInfos = new ArrayList<>();

    /**
     * Column-> ColumnInfo.
     */
    private Map<String, ColumnInfo> columnInfosMap = new HashMap<>();

    private TypeInfo() {
    }

    /**
     * Init this object.
     */
    public void init() {

        Util.checkNull(type);
        Util.checkNull(columnInfos);
        Util.check(!columnInfos.isEmpty());

        for (ColumnInfo columnInfo : columnInfos) {


            if (!columnInfosMap.containsKey(columnInfo.column)) {
                columnInfosMap.put(columnInfo.column, columnInfo);
            }
        }

    }

    /**
     * Find ColumnInfo by column.
     */
    public ColumnInfo findColumnInfo(String column) {
        Util.checkEmptyString(column);

        return columnInfosMap.get(column);
    }

    public Class<?> getType() {
        return type;
    }

    public List<ColumnInfo> getColumnInfos() {
        return columnInfos;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------" + getClass()
                + "-----------------------\n");
        sb.append("type=" + type + "\n");
        for (ColumnInfo columnInfo : columnInfos) {
            sb.append(columnInfo + "\n");
        }
        sb.append("-----------------" + getClass()
                + "-----------------------\n");
        return sb.toString();
    }
}
