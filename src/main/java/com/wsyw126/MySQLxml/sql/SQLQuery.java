package com.wsyw126.MySQLxml.sql;


import com.wsyw126.MySQLxml.utils.Util;

/**
 * SQLQuery.
 */
public class SQLQuery {

    private String id;
    private SQLNode sqlNode;

    public SQLQuery(String id, SQLNode sqlNode) {
        Util.checkEmptyString(id);
        Util.checkNull(sqlNode);

        this.id = id;
        this.sqlNode = sqlNode;
    }

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Getter method for property <tt>sqlNode</tt>.
     *
     * @return property value of sqlNode
     */
    public SQLNode getSqlNode() {
        return sqlNode;
    }
}
