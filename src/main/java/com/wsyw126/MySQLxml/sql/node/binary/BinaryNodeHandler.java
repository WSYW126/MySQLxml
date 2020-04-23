package com.wsyw126.MySQLxml.sql.node.binary;

import com.wsyw126.MySQLxml.sql.node.PrependNodeHandler;
import com.wsyw126.MySQLxml.utils.XmlUtil;
import org.w3c.dom.Node;

/**
 * @author xinzhi
 */
abstract public class BinaryNodeHandler extends PrependNodeHandler {

    public void handle(BinaryNode binaryNode, Node node) {
        binaryNode.setProperty(XmlUtil.getAttr(node, "property"));
        binaryNode.setCompareValue(XmlUtil.getAttr(node, "compareValue"));
        super.handle(binaryNode, node);
    }
}
