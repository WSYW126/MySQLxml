package com.wsyw126.MySQLxml.sql.node;

import com.wsyw126.MySQLxml.sql.SQLNode;
import com.wsyw126.MySQLxml.sql.SQLNodeType;

/**
 * @author xinzhi
 */
abstract public class PrependNode extends SQLNode {

    private String prependValue;

    protected PrependNode(SQLNodeType sqlNodeType) {
        super(sqlNodeType);
    }

    public String getPrependValue() {
        return prependValue;
    }

    public void setPrependValue(String prependValue) {
        this.prependValue = prependValue;
    }
}
