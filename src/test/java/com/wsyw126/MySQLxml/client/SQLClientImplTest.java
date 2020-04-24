package com.wsyw126.MySQLxml.client;

import com.wsyw126.MySQLxml.model.ResourceCounterDO;
import com.wsyw126.MySQLxml.utils.Config;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class SQLClientImplTest {
    /**
     * log.
     */
    final private static Logger log = Logger.getLogger(SQLClientImplTest.class);

    @Test
    void findObject() {
        SQLClient sqlClient = Config.getSqlClient();
        ResourceCounterDO queryById = sqlClient.findObject(ResourceCounterDO.class, "queryById", new HashMap<>());
        log.info("queryById =" + queryById);

    }
}