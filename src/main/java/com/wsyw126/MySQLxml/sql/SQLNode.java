package com.wsyw126.MySQLxml.sql;


import com.wsyw126.MySQLxml.config.SimpleSQLRuntimeSetting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

abstract public class SQLNode {

    /**
     * BlankSpace.
     */
    protected static final String BlankSpace = " ";

    /**
     * parent sql node.
     */

    protected SQLNode parent;

    /**
     * SQLNodeType.
     */
    protected SQLNodeType sqlNodeType;

    /**
     * Children nodes list.
     */
    protected List<SQLNode> subNodeList = new ArrayList<>();

    protected SQLNode(SQLNodeType sqlNodeType) {

        this.sqlNodeType = sqlNodeType;
    }

    /**
     * After apply the parameter map, the sql string value of this SQL node.
     *
     * @param para    parameter map.
     * @param sb      result collector.
     * @param context the context.
     */
    public abstract void applyParaMap(Map<String, Object> para,
                                      StringBuilder sb,
                                      Map<Object, Object> context,
                                      SimpleSQLRuntimeSetting runtimeSetting);

    public void addSubSQLNode(SQLNode sqlNode) {
        subNodeList.add(sqlNode);
    }

    public SQLNode getParent() {
        return parent;
    }

    public void setParent(SQLNode parent) {
        this.parent = parent;
    }

    public SQLNodeType getSqlNodeType() {
        return sqlNodeType;
    }
}
