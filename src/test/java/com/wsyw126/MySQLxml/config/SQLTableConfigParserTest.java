package com.wsyw126.MySQLxml.config;

import com.wsyw126.MySQLxml.sql.SQLNode;
import com.wsyw126.MySQLxml.sql.SQLQuery;
import com.wsyw126.MySQLxml.utils.Config;
import junit.framework.Assert;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLTableConfigParserTest {
    /**
     * log.
     */
    final private static Logger log = Logger.getLogger(SQLTableConfigParserTest.class);

    protected StringBuilder sb = new StringBuilder();
    protected Map<String, Object> para = new HashMap<String, Object>();
    protected Map<Object, Object> context = new HashMap<Object, Object>();


    protected SQLNode findStatementSQLNode(String id) {
        List<SQLQuery> sqlQueries = SQLTableConfigParser
                .parseSQLQuery(Config.TestSqlNodeXmlFile);
        for (SQLQuery query : sqlQueries) {
            if (query.getId().equals(id)) {
                return query.getSqlNode();
            }
        }
        return null;
    }


    protected void assertEqualSQL(String s1, String s2) {
        String[] s1Array = s1.split("[ \n\r\t]");
        List<String> s1List = new ArrayList<String>();
        for (String s : s1Array) {
            if (!s.isEmpty()) {
                s1List.add(s);
            }
        }

        String[] s2Array = s2.split("[ \n\r\t]");
        List<String> s2List = new ArrayList<String>();
        for (String s : s2Array) {
            if (!s.isEmpty()) {
                s2List.add(s);
            }
        }

        log.info("s1 List=" + s1List);
        log.info("s2 List=" + s2List);

        Assert.assertTrue(s1List.size() == s2List.size());
        for (int i = 0; i < s1List.size(); i++) {
            Assert.assertEquals(s1List.get(i), s2List.get(i));
        }
    }

}