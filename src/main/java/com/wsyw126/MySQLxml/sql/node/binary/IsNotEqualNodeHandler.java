package com.wsyw126.MySQLxml.sql.node.binary;

import com.wsyw126.MySQLxml.sql.SQLNode;
import org.w3c.dom.Node;

/**
 * @author xinzhi
 */
public class IsNotEqualNodeHandler extends BinaryNodeHandler {

    @Override
    public SQLNode handle(Node node) {
        IsNotEqualNode isNotEqualNode = new IsNotEqualNode();
        super.handle(isNotEqualNode, node);
        return isNotEqualNode;
    }
}
