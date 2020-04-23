package com.wsyw126.MySQLxml.sql.node.binary;

import com.wsyw126.MySQLxml.sql.SQLNode;
import org.w3c.dom.Node;

/**
 * @author xinzhi
 */
public class IsGreaterThanNodeHandler extends BinaryNodeHandler {

    @Override
    public SQLNode handle(Node node) {
        IsGreaterThanNode isGreaterThanNode = new IsGreaterThanNode();
        super.handle(isGreaterThanNode, node);
        return isGreaterThanNode;
    }
}
