package com.wsyw126.MySQLxml.sql;

import org.w3c.dom.Node;

public interface SQLNodeHandler {

    /**
     * Convert DOM's node to SQLNode.
     */
    public SQLNode handle(Node node);
}
