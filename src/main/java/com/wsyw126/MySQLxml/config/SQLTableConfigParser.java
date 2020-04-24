package com.wsyw126.MySQLxml.config;

import com.wsyw126.MySQLxml.sql.SQLNodeParser;
import com.wsyw126.MySQLxml.sql.SQLQuery;
import com.wsyw126.MySQLxml.utils.Util;
import com.wsyw126.MySQLxml.utils.XmlUtil;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * SQLTableConfigParser parser.
 */
public class SQLTableConfigParser {

    /**
     * Parse SQLTableSchema.
     *
     * <pre>
     * Only parse static config data, not runtime config data.
     * </pre>
     */
    public static void parseTableSchema(InputStream inputStream,
                                        SQLTableSchema tableSchema,
                                        List<SQLColumnSchema> sqlColumnSchemas) {

        Util.checkNull(inputStream);
        Util.checkNull(tableSchema);
        Util.checkNull(sqlColumnSchemas);

        Node sqlTableSchemaNode = XmlUtil.findTopLevelNode(inputStream,
                "SQLTableSchema");

        tableSchema.setTableName(XmlUtil.getAttr(sqlTableSchemaNode,
                "tableName"));

        NodeList nodeList = sqlTableSchemaNode.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node columnNode = nodeList.item(i);
            if (!columnNode.getNodeName().equals("SQLColumnSchema")) {
                continue;
            }
            SQLColumnSchema columnSchema = new SQLColumnSchema();
            columnSchema.setTypeName(XmlUtil.getAttr(columnNode, "typeName"));
            columnSchema.setColumn(XmlUtil.getAttr(columnNode, "column"));
            columnSchema.setTypeHandlerName(XmlUtil.getAttr(columnNode,
                    "handler"));

            sqlColumnSchemas.add(columnSchema);
        }
    }

    /**
     * Parse SQLQuery.
     */
    public static List<SQLQuery> parseSQLQuery(InputStream inputStream) {
        Util.checkNull(inputStream);
        Node statementsNode = XmlUtil.findTopLevelNode(inputStream,
                "statements");
        return parseSQLQueryList(statementsNode);
    }

    /**
     * Parse SQLQuery.
     */
    public static List<SQLQuery> parseSQLQuery(String filePath) {
        Util.checkEmptyString(filePath);
        Node statementsNode = XmlUtil.findTopLevelNodeInFile(filePath,
                "statements");
        return parseSQLQueryList(statementsNode);
    }

    /**
     * Parse SQLQuery.
     */
    public static List<SQLQuery> parseSQLQueryWithRawSQL(String sql,
                                                         String id) {

        Util.checkEmptyString(sql);
        String content = "<SimpleSQL><statements><statement id=\"" + id
                + "\">";
        content = content + sql;
        content = content + "</statement></statements></SimpleSQL>";

        Node statementsNode = XmlUtil.findTopLevelNodeInString(content,
                "statements");

        return parseSQLQueryList(statementsNode);
    }

    private static List<SQLQuery> parseSQLQueryList(Node statementsNode) {
        List<SQLQuery> sqlQueries = new ArrayList<>();
        if (statementsNode == null) {
            return sqlQueries;
        }

        NodeList nodeList = statementsNode.getChildNodes();
        if (nodeList == null || nodeList.getLength() == 0) {
            return sqlQueries;
        }

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (!node.getNodeName().equals("statement")) {
                continue;
            }

            String id = XmlUtil.getAttr(node, "id");
            SQLQuery sqlQuery = new SQLQuery(id,
                    SQLNodeParser.parse(node));
            sqlQueries.add(sqlQuery);
        }

        return sqlQueries;
    }

}
