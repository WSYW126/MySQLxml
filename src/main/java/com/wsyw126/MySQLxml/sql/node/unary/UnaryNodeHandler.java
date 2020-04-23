package com.wsyw126.MySQLxml.sql.node.unary;

import com.wsyw126.MySQLxml.sql.node.PrependNodeHandler;
import com.wsyw126.MySQLxml.utils.XmlUtil;
import org.w3c.dom.Node;

/**
 * @author xinzhi
 */
abstract public class UnaryNodeHandler extends PrependNodeHandler {

    public void handle(UnaryNode unaryNode, Node node) {
        unaryNode.setProperty(XmlUtil.getAttr(node, "property"));
        super.handle(unaryNode, node);
    }
}
