package com.wsyw126.MySQLxml.sql.node.unary;

import com.wsyw126.MySQLxml.sql.SQLNode;
import org.w3c.dom.Node;

/**
 * @author xinzhi
 */
public class IsNotPropertyAvailableNodeHandler extends UnaryNodeHandler {

    @Override
    public SQLNode handle(Node node) {
        IsNotPropertyAvailableNode isNotPropertyAvailableNode = new IsNotPropertyAvailableNode();
        super.handle(isNotPropertyAvailableNode, node);
        return isNotPropertyAvailableNode;
    }
}
