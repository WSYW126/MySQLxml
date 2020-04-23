package com.wsyw126.MySQLxml.utils;

import com.wsyw126.MySQLxml.exception.SQLException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * XmlUtil.
 */
public class XmlUtil {

    private XmlUtil() {
    }

    /**
     * Find top level node.
     */
    public static Node findTopLevelNodeInFile(String filePath, String nodeName) {
        Util.checkEmptyString(filePath);
        try {
            return findTopLevelNode(new BufferedInputStream(
                    new FileInputStream(new File(filePath))), nodeName);
        } catch (FileNotFoundException e) {
            throw new SQLException("error.", e);
        }
    }

    /**
     * Find top level node.
     */

    public static Node findTopLevelNodeInString(String content, String nodeName) {
        Util.checkEmptyString(content);
        return findTopLevelNode(new ByteArrayInputStream(content.getBytes()),
                nodeName);
    }

    /**
     * Find top level node.
     */

    public static Node findTopLevelNode(InputStream inputStream, String nodeName) {
        List<Node> nodeList = findTopLevelNodes(inputStream, nodeName);
        if (nodeList.size() == 1) {
            return nodeList.get(0);
        } else {
            return null;
        }
    }

    /**
     * Find top level nodes.
     */
    public static List<Node> findTopLevelNodes(InputStream inputStream,
                                               String nodeName) {

        List<Node> nodeList = new ArrayList<Node>();

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setIgnoringElementContentWhitespace(true);
            dbf.setIgnoringComments(true);

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(inputStream);
            Node rootNode = doc.getDocumentElement();
            NodeList childNodes = rootNode.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                if (childNodes.item(i).getNodeName().equals(nodeName)) {
                    nodeList.add(childNodes.item(i));
                }
            }
        } catch (Exception e) {
            throw new SQLException("parse error.", e);
        }

        return nodeList;
    }

    /**
     * Get attribute node value of node or null if attribute doesn't exist.
     */

    public static String getAttr(Node node, String attrName) {

        Util.checkNull(node);
        Util.checkEmptyString(attrName);

        NamedNodeMap columnAttrs = node.getAttributes();
        if (columnAttrs == null) {
            return null;
        }
        Node attrNode = columnAttrs.getNamedItem(attrName);
        if (attrNode == null) {
            return null;
        }
        return attrNode.getNodeValue();
    }
}
