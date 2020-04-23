package com.wsyw126.MySQLxml.sql.node.text;

import com.wsyw126.MySQLxml.sql.SQLNodeHandler;
import org.w3c.dom.Node;

/**
 * @author xinzhi
 */
abstract public class BaseTextNodeHandler implements SQLNodeHandler {

    public void handle(BaseTextNode baseTextNode, Node node) {
        baseTextNode.setTextValue(node.getNodeValue());
    }
}
