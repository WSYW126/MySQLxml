package com.wsyw126.MySQLxml.sql;

import org.w3c.dom.Node;

public enum SQLNodeType {
    //text.
    CDATASection("#cdata-section"),

    Text("#text"),

    Comment("#comment"),

    //top level statement.
    Statement("statement"),

    //dynamic node.
    Dynamic("dynamic"),

    //binary condition node.
    IsEqual("isEqual"),

    IsNotEqual("isNotEqual"),

    IsGreaterThan("isGreaterThan"),

    IsGreaterEqual("isGreaterEqual"),

    IsLessThan("isLessThan"),

    IsLessEqual("isLessEqual"),

    //unary condition node.
    IsNull("isNull"),

    IsNotNull("isNotNull"),

    IsEmpty("isEmpty"),

    IsNotEmpty("isNotEmpty"),

    IsPropertyAvailable("isPropertyAvailable"),

    IsNotPropertyAvailable("isNotPropertyAvailable"),;

    /**
     * The name of xml's node.
     */
    private String xmlNodeName;

    private SQLNodeType(String xmlNodeName) {
        this.xmlNodeName = xmlNodeName;
    }

    public static SQLNodeType findSQLNodeType(Node node) {


        for (SQLNodeType sqlNodeType : SQLNodeType.values()) {
            if (node.getNodeName().equals(sqlNodeType.xmlNodeName)) {
                return sqlNodeType;
            }
        }

        throw new RuntimeException("parse err. node = " + node);
    }

}
