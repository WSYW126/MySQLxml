package com.wsyw126.MySQLxml.sql.node.unary;

import com.wsyw126.MySQLxml.sql.SQLNodeType;
import com.wsyw126.MySQLxml.sql.node.ConditionNode;


/**
 * @author xinzhi
 */
abstract public class UnaryNode extends ConditionNode {

    private String property;

    protected UnaryNode(SQLNodeType sqlNodeType) {
        super(sqlNodeType);
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

}
