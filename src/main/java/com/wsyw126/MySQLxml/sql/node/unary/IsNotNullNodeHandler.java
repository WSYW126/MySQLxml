package com.wsyw126.MySQLxml.sql.node.unary;

import com.wsyw126.MySQLxml.sql.SQLNode;
import org.w3c.dom.Node;

/**
 * @author xinzhi
 */
public class IsNotNullNodeHandler extends UnaryNodeHandler {

    @Override
    public SQLNode handle(Node node) {
        IsNotNullNode isNotNullNode = new IsNotNullNode();
        super.handle(isNotNullNode, node);
        return isNotNullNode;
    }

}
