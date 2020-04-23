package com.wsyw126.MySQLxml.sql.node;

import com.wsyw126.MySQLxml.sql.SQLNode;
import org.w3c.dom.Node;

/**
 * @author xinzhi
 */
public class DynamicNodeHandler extends PrependNodeHandler {

    @Override
    public SQLNode handle(Node node) {
        DynamicNode dynamicNode = new DynamicNode();
        super.handle(dynamicNode, node);
        return dynamicNode;
    }
}