package com.wsyw126.MySQLxml.sql.node;

import com.wsyw126.MySQLxml.sql.SQLNodeHandler;
import com.wsyw126.MySQLxml.utils.XmlUtil;
import org.w3c.dom.Node;

abstract public class PrependNodeHandler implements SQLNodeHandler {

    public void handle(PrependNode prependNode, Node node) {
        prependNode.setPrependValue(XmlUtil.getAttr(node, "prepend"));
    }
}
