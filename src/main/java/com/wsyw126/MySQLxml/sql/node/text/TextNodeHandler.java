package com.wsyw126.MySQLxml.sql.node.text;

import com.wsyw126.MySQLxml.sql.SQLNode;
import org.w3c.dom.Node;

/**
 * @author xinzhi
 */
public class TextNodeHandler extends BaseTextNodeHandler {

    @Override
    public SQLNode handle(Node node) {
        TextNode textNode = new TextNode();
        super.handle(textNode, node);
        return textNode;
    }

}
