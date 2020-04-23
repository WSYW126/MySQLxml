package com.wsyw126.MySQLxml.sql.node.unary;

import com.wsyw126.MySQLxml.sql.SQLNode;
import org.w3c.dom.Node;

/**
 * @author xinzhi
 */
public class IsEmptyNodeHandler extends UnaryNodeHandler {

    @Override
    public SQLNode handle(Node node) {
        IsEmptyNode isEmptyNode = new IsEmptyNode();
        super.handle(isEmptyNode, node);
        return isEmptyNode;
    }

}
