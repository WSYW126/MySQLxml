package com.wsyw126.MySQLxml.sql.node.text;

import com.wsyw126.MySQLxml.sql.SQLNode;
import com.wsyw126.MySQLxml.sql.SQLNodeType;

/**
 * @author xinzhi
 */
abstract public class BaseTextNode extends SQLNode {

    private String textValue;

    protected BaseTextNode(SQLNodeType sqlNodeType) {
        super(sqlNodeType);
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String value) {
        this.textValue = value;
    }
}
