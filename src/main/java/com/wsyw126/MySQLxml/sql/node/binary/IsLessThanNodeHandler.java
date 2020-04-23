package com.wsyw126.MySQLxml.sql.node.binary;

import com.wsyw126.MySQLxml.sql.SQLNode;
import org.w3c.dom.Node;

/**
 * @author xinzhi
 */
public class IsLessThanNodeHandler extends BinaryNodeHandler {

    @Override
    public SQLNode handle(Node node) {
        IsLessThanNode isLessThanNode = new IsLessThanNode();
        super.handle(isLessThanNode, node);
        return isLessThanNode;
    }
}
