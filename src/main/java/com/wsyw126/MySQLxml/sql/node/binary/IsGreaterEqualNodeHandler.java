package com.wsyw126.MySQLxml.sql.node.binary;

import com.wsyw126.MySQLxml.sql.SQLNode;
import org.w3c.dom.Node;

/**
 * @author xinzhi
 */
public class IsGreaterEqualNodeHandler extends BinaryNodeHandler {

    @Override
    public SQLNode handle(Node node) {
        IsGreaterEqualNode isGreaterEqualNode = new IsGreaterEqualNode();
        super.handle(isGreaterEqualNode, node);
        return isGreaterEqualNode;
    }
}
