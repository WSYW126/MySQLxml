package com.wsyw126.MySQLxml.sql.node.unary;

import com.wsyw126.MySQLxml.sql.SQLNode;
import org.w3c.dom.Node;

/**
 * @author xinzhi
 */
public class IsNotEmptyNodeHandler extends UnaryNodeHandler {

    @Override
    public SQLNode handle(Node node) {
        IsNotEmptyNode isNotEmptyNode = new IsNotEmptyNode();
        super.handle(isNotEmptyNode, node);
        return isNotEmptyNode;
    }

}
