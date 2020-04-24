package com.wsyw126.MySQLxml.sql.node.binary;

import com.wsyw126.MySQLxml.config.SQLTableConfigParserTest;
import com.wsyw126.MySQLxml.config.SimpleSQLRuntimeSetting;
import com.wsyw126.MySQLxml.sql.SQLNode;
import com.wsyw126.MySQLxml.utils.DateUtil;
import org.junit.jupiter.api.Test;


class IsGreaterThanNodeHandlerTest extends SQLTableConfigParserTest {

    @Test
    public void test_0() {
        SQLNode sqlNode = findStatementSQLNode("test_isGreaterThan");
        para.put("name", "alice");
        para.put("age", 11);
        para.put("date", DateUtil.parse("2013-09-01", DateUtil.DayFormat));
        sqlNode.applyParaMap(para, sb, context, new SimpleSQLRuntimeSetting());
        assertEqualSQL("allen", sb.toString());
    }

    @Test
    public void test_1() {
        SQLNode sqlNode = findStatementSQLNode("test_isGreaterThan");
        para.put("name", "bob");
        para.put("age", 30);
        para.put("date", DateUtil.parse("2013-10-01", DateUtil.DayFormat));
        sqlNode.applyParaMap(para, sb, context, new SimpleSQLRuntimeSetting());
        assertEqualSQL("allen", sb.toString());
    }

    @Test
    public void test_2() {
        SQLNode sqlNode = findStatementSQLNode("test_isGreaterThan");
        para.put("name", "cat");
        para.put("age", 40);
        para.put("date", DateUtil.parse("2013-11-01", DateUtil.DayFormat));
        sqlNode.applyParaMap(para, sb, context, new SimpleSQLRuntimeSetting());
        assertEqualSQL("allen AND MARRIED OR AGE OR tree", sb.toString());
    }
}