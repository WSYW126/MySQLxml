package com.wsyw126.MySQLxml.utils;

import com.wsyw126.MySQLxml.client.SQLClient;
import com.wsyw126.MySQLxml.client.SQLClientImpl;
import com.wsyw126.MySQLxml.config.SQLTableConfig;

public class Config {
    private static volatile SQLClient sqlClient;


    final public static String TestSqlNodeXmlFile = "data/testSqlNode.xml";
    final public static String TestSqlNode_MYRecord2_XmlFile = "data/myRecord2.xml";


    static {

        SQLTableConfig sqlTableConfig = new SQLTableConfig();
        sqlTableConfig.setConfigResource(new CachedFileSystemResource(
                TestSqlNode_MYRecord2_XmlFile));
        sqlTableConfig.init();

        SQLClientImpl sqlClient1 = new SQLClientImpl();
        sqlClient1.setSqlTableConfig(sqlTableConfig);
        sqlClient = sqlClient1;
    }

    /**
     * Getter method for property <tt>sqlClient</tt>.
     *
     * @return property value of sqlClient
     */
    public static SQLClient getSqlClient() {
        return sqlClient;
    }
}
