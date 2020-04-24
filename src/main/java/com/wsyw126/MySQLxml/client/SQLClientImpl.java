package com.wsyw126.MySQLxml.client;

import com.wsyw126.MySQLxml.sql.SQLQuery;
import com.wsyw126.MySQLxml.utils.SQLDO;
import com.wsyw126.MySQLxml.utils.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangjunpeng
 * @version $Id: SQLClient.java, v 0.1 2020年04月24日 上午11:25 yangjunpeng Exp $
 */
public class SQLClientImpl extends SQLClientBase {

    @Override
    public <T> T findObject(Class<? extends T> type, String id, Map<String, Object> para) {
        parseSelectFilter(id, para);
        return findObject_internal(type);
    }

    private void parseSelectFilter(String id, Map<String, Object> para) {
        SQLQuery sqlQuery = getHbaseTableConfig().getQueryMap().get(id);
        Util.checkNull(sqlQuery);

        StringBuilder sb = new StringBuilder();
        Map<Object, Object> context = new HashMap<Object, Object>();
        sqlQuery.getSqlNode().applyParaMap(para, sb, context,
                simpleHbaseRuntimeSetting);

        String hql = sb.toString().trim();

    }

    private <T> T findObject_internal(Class<? extends T> type) {
        Util.checkNull(type);


        try {
            // FIXME: 2020/4/24 假设已经返回数据
            return convertToSimpleSQLDOWithKeyResult(SQLDO.getSqlResult(), type);
        } finally {
        }

    }

}