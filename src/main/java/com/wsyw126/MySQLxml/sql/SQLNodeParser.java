package com.wsyw126.MySQLxml.sql;

import com.wsyw126.MySQLxml.sql.node.DynamicNodeHandler;
import com.wsyw126.MySQLxml.sql.node.StatementNodeHandler;
import com.wsyw126.MySQLxml.sql.node.binary.IsEqualNodeHandler;
import com.wsyw126.MySQLxml.sql.node.binary.IsGreaterEqualNodeHandler;
import com.wsyw126.MySQLxml.sql.node.binary.IsGreaterThanNodeHandler;
import com.wsyw126.MySQLxml.sql.node.binary.IsLessEqualNodeHandler;
import com.wsyw126.MySQLxml.sql.node.binary.IsLessThanNodeHandler;
import com.wsyw126.MySQLxml.sql.node.binary.IsNotEqualNodeHandler;
import com.wsyw126.MySQLxml.sql.node.text.CDATASectionNodeHandler;
import com.wsyw126.MySQLxml.sql.node.text.CommentNodeHandler;
import com.wsyw126.MySQLxml.sql.node.text.TextNodeHandler;
import com.wsyw126.MySQLxml.sql.node.unary.IsEmptyNodeHandler;
import com.wsyw126.MySQLxml.sql.node.unary.IsNotEmptyNodeHandler;
import com.wsyw126.MySQLxml.sql.node.unary.IsNotNullNodeHandler;
import com.wsyw126.MySQLxml.sql.node.unary.IsNotPropertyAvailableNodeHandler;
import com.wsyw126.MySQLxml.sql.node.unary.IsNullNodeHandler;
import com.wsyw126.MySQLxml.sql.node.unary.IsPropertyAvailableNodeHandler;
import com.wsyw126.MySQLxml.utils.Util;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.Map;

/**
 * SQLNodeParser.
 */
public class SQLNodeParser {

    private static Map<SQLNodeType, SQLNodeHandler> sqlNodeHandlers = new HashMap<>();

    static {
        register(SQLNodeType.Statement, new StatementNodeHandler());

        register(SQLNodeType.Text, new TextNodeHandler());
        register(SQLNodeType.Comment, new CommentNodeHandler());
        register(SQLNodeType.CDATASection, new CDATASectionNodeHandler());

        register(SQLNodeType.Dynamic, new DynamicNodeHandler());

        register(SQLNodeType.IsNull, new IsNullNodeHandler());
        register(SQLNodeType.IsNotNull, new IsNotNullNodeHandler());

        register(SQLNodeType.IsEmpty, new IsEmptyNodeHandler());
        register(SQLNodeType.IsNotEmpty, new IsNotEmptyNodeHandler());

        register(SQLNodeType.IsPropertyAvailable,
                new IsPropertyAvailableNodeHandler());
        register(SQLNodeType.IsNotPropertyAvailable,
                new IsNotPropertyAvailableNodeHandler());

        register(SQLNodeType.IsEqual, new IsEqualNodeHandler());
        register(SQLNodeType.IsNotEqual, new IsNotEqualNodeHandler());

        register(SQLNodeType.IsGreaterThan, new IsGreaterThanNodeHandler());
        register(SQLNodeType.IsGreaterEqual, new IsGreaterEqualNodeHandler());

        register(SQLNodeType.IsLessThan, new IsLessThanNodeHandler());
        register(SQLNodeType.IsLessEqual, new IsLessEqualNodeHandler());

    }

    private static void register(SQLNodeType sqlNodeType,
                                 SQLNodeHandler sqlNodeHandler) {
        sqlNodeHandlers.put(sqlNodeType, sqlNodeHandler);
    }

    public static SQLNode parse(Node node) {

        Util.checkNull(node);

        SQLNodeType sqlNodeType = SQLNodeType.findSQLNodeType(node);
        SQLNodeHandler sqlNodeHandler = sqlNodeHandlers.get(sqlNodeType);
        SQLNode sqlNode = sqlNodeHandler.handle(node);
        NodeList nodeList = node.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node subNode = nodeList.item(i);
            SQLNode subSqlNode = parse(subNode);
            subSqlNode.setParent(sqlNode);
            sqlNode.addSubSQLNode(subSqlNode);
        }

        return sqlNode;
    }
}
