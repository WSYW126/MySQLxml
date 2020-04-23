package com.wsyw126.MySQLxml.sql.node.text;

import com.wsyw126.MySQLxml.sql.SQLNode;
import org.w3c.dom.Node;

/**
 * @author xinzhi
 */
public class CDATASectionNodeHandler extends BaseTextNodeHandler {

    @Override
    public SQLNode handle(Node node) {
        CDATASectionNode cdataSectionNode = new CDATASectionNode();
        super.handle(cdataSectionNode, node);
        return cdataSectionNode;
    }

}
