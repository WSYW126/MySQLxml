package com.wsyw126.MySQLxml.config;

import com.wsyw126.MySQLxml.exception.SQLException;
import com.wsyw126.MySQLxml.utils.StringUtil;
import com.wsyw126.MySQLxml.utils.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * HbaseTable's schema.
 *
 * <pre>
 * Including all meta data of hbase table.
 * </pre>
 *
 * @author xinzhi
 */
public class SQLTableSchema {

    // ------------xml config-------------------
    /**
     * tableName. not null.
     */
    @ConfigAttr
    private String tableName;

    // ------------runtime-------------------

    /**
     * column-> SQLColumnSchema.
     */
    private Map<String, SQLColumnSchema> columnSchemas = new TreeMap<>();


    /**
     * init.
     */
    public void init(List<SQLColumnSchema> sqlColumnSchemas) {

        Util.checkEmptyString(tableName);

        if (sqlColumnSchemas.isEmpty()) {
            throw new SQLException("no SQLColumnSchemas.");
        }

        for (SQLColumnSchema columnSchema : sqlColumnSchemas) {
            if (StringUtil.isEmptyString(columnSchema.getTableName())) {
                columnSchema.setTableName(tableName);
            }

            columnSchema.init();

            SQLColumnSchema temMap = columnSchemas
                    .get(columnSchema.getColumn());
            if (temMap == null) {
                columnSchemas.put(columnSchema.getColumn(), columnSchema);
            }
        }
    }

    /**
     * Find SQLColumnSchema by column.
     */
    public SQLColumnSchema findColumnSchema(String column) {
        Util.checkEmptyString(column);

        SQLColumnSchema result = columnSchemas.get(column);

        if (result == null) {
            throw new SQLException("no SQLColumnSchema found.");
        }

        return result;
    }


    /**
     * Find all SQLColumnSchemas.
     */
    public List<SQLColumnSchema> findAllColumnSchemas() {
        List<SQLColumnSchema> result = new ArrayList<SQLColumnSchema>();

        for (SQLColumnSchema sqlColumnSchema : columnSchemas.values()) {
            result.add(sqlColumnSchema);
        }
        return result;
    }


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------table--------------------------\n");
        StringUtil.append(sb, "tableName", tableName);
        for (SQLColumnSchema columnSchema : columnSchemas.values()) {
            StringUtil.append(sb, "columnSchema", columnSchema);
        }
        sb.append("---------------table--------------------------\n");
        return sb.toString();
    }
}
