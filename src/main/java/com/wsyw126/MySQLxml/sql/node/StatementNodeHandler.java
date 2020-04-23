package com.wsyw126.MySQLxml.sql.node;

import com.wsyw126.MySQLxml.sql.SQLNode;
import com.wsyw126.MySQLxml.sql.SQLNodeHandler;
import org.w3c.dom.Node;

/**
 * @author xinzhi
 */
public class StatementNodeHandler implements SQLNodeHandler {

    @Override
    public SQLNode handle(Node node) {
        StatementNode statementNode = new StatementNode();
        return statementNode;
    }
}
