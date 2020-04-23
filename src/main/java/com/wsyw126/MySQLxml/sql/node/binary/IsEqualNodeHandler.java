package com.wsyw126.MySQLxml.sql.node.binary;

import com.wsyw126.MySQLxml.sql.SQLNode;
import org.w3c.dom.Node;

/**
 * @author xinzhi
 */
public class IsEqualNodeHandler extends BinaryNodeHandler {

    @Override
    public SQLNode handle(Node node) {
        IsEqualNode isEqualNode = new IsEqualNode();
        super.handle(isEqualNode, node);
        return isEqualNode;
    }
}
