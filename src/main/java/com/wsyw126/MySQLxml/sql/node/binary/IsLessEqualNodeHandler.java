package com.wsyw126.MySQLxml.sql.node.binary;

import com.wsyw126.MySQLxml.sql.SQLNode;
import org.w3c.dom.Node;

/**
 * @author xinzhi
 */
public class IsLessEqualNodeHandler extends BinaryNodeHandler {

    @Override
    public SQLNode handle(Node node) {
        IsLessEqualNode isLessEqualNode = new IsLessEqualNode();
        super.handle(isLessEqualNode, node);
        return isLessEqualNode;
    }
}
