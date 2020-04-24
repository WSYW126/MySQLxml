package com.wsyw126.MySQLxml.client;

import com.wsyw126.MySQLxml.config.SQLColumnSchema;
import com.wsyw126.MySQLxml.config.SQLTableConfig;
import com.wsyw126.MySQLxml.config.SimpleSQLRuntimeSetting;
import com.wsyw126.MySQLxml.exception.SQLException;
import com.wsyw126.MySQLxml.type.TypeHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangjunpeng
 * @version $Id: SQLClient.java, v 0.1 2020年04月24日 上午11:25 yangjunpeng Exp $
 */
public abstract class SQLClientBase implements SQLClient {
    protected SQLTableConfig sqlTableConfig;
    protected SimpleSQLRuntimeSetting simpleHbaseRuntimeSetting = new SimpleSQLRuntimeSetting();


    public SQLTableConfig getHbaseTableConfig() {
        return sqlTableConfig;
    }

    /**
     * Find type info.
     */
    protected TypeInfo findTypeInfo(Class<?> type) {
        return getHbaseTableConfig().findTypeInfo(type);
    }

    /**
     * Find SQLColumnSchema by column.
     */
    protected SQLColumnSchema columnSchema(String column) {
        return sqlTableConfig.getSqlTableSchema().findColumnSchema(
                column);
    }

    /**
     * convert sql result to DO.
     *
     * @param sqlResult sql result.
     * @param type      POJO type.
     * @return DO.
     */
    protected <T> T convertToSimpleSQLDOWithKeyResult(
            HashMap<String, String> sqlResult, Class<? extends T> type) {

        String column = null;

        try {

            TypeInfo typeInfo = findTypeInfo(type);
            T result = type.newInstance();
            for (Map.Entry<String, String> stringStringEntry : sqlResult.entrySet()) {
                String value = stringStringEntry.getValue();
                column = stringStringEntry.getKey();
                ColumnInfo columnInfo = typeInfo.findColumnInfo(column);

                SQLColumnSchema sqlColumnSchema = columnSchema(columnInfo.column);


                TypeHandler typeHandler = sqlColumnSchema.getTypeHandler();
                Object o = typeHandler.toObject(sqlColumnSchema.getType(), value);

                if (o != null) {
                    columnInfo.field.set(result, o);
                }
            }

            return result;

        } catch (Exception e) {
            throw new SQLException(
                    "convert result exception. column=" + column + " result="
                            + sqlResult + " type=" + type, e);
        }
    }

    /**
     * Setter method for property <tt>sqlTableConfig</tt>.
     *
     * @param sqlTableConfig value to be assigned to property sqlTableConfig
     */
    public void setSqlTableConfig(SQLTableConfig sqlTableConfig) {
        this.sqlTableConfig = sqlTableConfig;
    }
}