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
        HashMap<String, Object> para = new HashMap<>();
        para.put("count", "12");


        SQLClient sqlClient = Config.getSqlClient();
        //这里是mock的数据，有时间来改造一下。
        ResourceCounterDO queryById = sqlClient.findObject(ResourceCounterDO.class, "queryByCount", para);
        log.info("queryById =" + queryById);

    }
}