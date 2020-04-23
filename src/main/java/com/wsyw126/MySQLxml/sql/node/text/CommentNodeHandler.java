package com.wsyw126.MySQLxml.sql.node.text;

import com.wsyw126.MySQLxml.sql.SQLNode;
import org.w3c.dom.Node;

/**
 * @author xinzhi
 */
public class CommentNodeHandler extends BaseTextNodeHandler {

    @Override
    public SQLNode handle(Node node) {
        CommentNode commentNode = new CommentNode();
        super.handle(commentNode, node);
        return commentNode;
    }

}
