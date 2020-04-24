package com.wsyw126.MySQLxml.config;

import com.wsyw126.MySQLxml.client.TypeInfo;
import com.wsyw126.MySQLxml.model.ResourceCounterDO;
import com.wsyw126.MySQLxml.utils.CachedFileSystemResource;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

class SQLTableConfigTest {

    /**
     * log.
     */
    final private static Logger log = Logger.getLogger(SQLTableConfig.class);

    static SQLTableConfig sqlTableConfig = new SQLTableConfig();


    @Test
    void init() {
        sqlTableConfig.setConfigResource(new CachedFileSystemResource(
                "data/myRecord.xml"));

        sqlTableConfig.init();
    }

    @Test
    void findTypeInfo() {
        sqlTableConfig.setConfigResource(new CachedFileSystemResource(
                "data/myRecord.xml"));
        sqlTableConfig.init();

        //通过注释进行初始化
        TypeInfo typeInfo = sqlTableConfig.findTypeInfo(ResourceCounterDO.class);
        log.info("typeInfo = " + typeInfo);
    }

    @Test
    void findTypeInfo2() {
        sqlTableConfig.setConfigResource(new CachedFileSystemResource(
                "data/myRecord2.xml"));
        sqlTableConfig.init();

        //通过xml进行初始化
        TypeInfo typeInfo = sqlTableConfig.findTypeInfo(ResourceCounterDO.class);
        log.info("typeInfo = " + typeInfo);
    }

    @Test
    void addSQLQueryList() {
    }

    @Test
    void getSqlTableSchema() {
    }

    @Test
    void getQueryMap() {

    }
}