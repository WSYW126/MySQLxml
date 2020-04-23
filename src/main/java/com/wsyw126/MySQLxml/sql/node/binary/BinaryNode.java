package com.wsyw126.MySQLxml.sql.node.binary;

import com.wsyw126.MySQLxml.sql.SQLNodeType;
import com.wsyw126.MySQLxml.sql.node.ConditionNode;

/**
 * @author xinzhi
 */
abstract public class BinaryNode extends ConditionNode {

    private String property;
    private String compareValue;

    protected BinaryNode(SQLNodeType sqlNodeType) {
        super(sqlNodeType);
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getCompareValue() {
        return compareValue;
    }

    public void setCompareValue(String compareValue) {
        this.compareValue = compareValue;
    }

}
