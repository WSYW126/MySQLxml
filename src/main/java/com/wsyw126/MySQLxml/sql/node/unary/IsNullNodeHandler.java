package com.wsyw126.MySQLxml.sql.node.unary;

import com.wsyw126.MySQLxml.sql.SQLNode;
import org.w3c.dom.Node;

/**
 * @author xinzhi
 */
public class IsNullNodeHandler extends UnaryNodeHandler {

    @Override
    public SQLNode handle(Node node) {
        IsNullNode isNullNode = new IsNullNode();
        super.handle(isNullNode, node);
        return isNullNode;
    }

}
