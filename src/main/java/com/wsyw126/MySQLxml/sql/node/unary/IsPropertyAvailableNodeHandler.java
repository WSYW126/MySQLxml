package com.wsyw126.MySQLxml.sql.node.unary;

import com.wsyw126.MySQLxml.sql.SQLNode;
import org.w3c.dom.Node;

/**
 * @author xinzhi
 */
public class IsPropertyAvailableNodeHandler extends UnaryNodeHandler {

    @Override
    public SQLNode handle(Node node) {
        IsPropertyAvailableNode isPropertyAvailableNode = new IsPropertyAvailableNode();
        super.handle(isPropertyAvailableNode, node);
        return isPropertyAvailableNode;
    }

}
