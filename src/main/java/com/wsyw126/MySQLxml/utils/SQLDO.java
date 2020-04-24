package com.wsyw126.MySQLxml.utils;

import java.util.HashMap;

/**
 * @author yangjunpeng
 * @version $Id: SQLDO.java, v 0.1 2020年04月24日 上午11:45 yangjunpeng Exp $
 */
public class SQLDO {
    private static HashMap<String, String> sqlResult = new HashMap<>();
    static {
        sqlResult.put("COUNT", "12");
        sqlResult.put("GMT_MODIFY", "2020-04-24_11:47:50:123");
        sqlResult.put("GMT_CREATE", "2020-04-24_11:47:50:123");
    }


    /**
     * Getter method for property <tt>sqlResult</tt>.
     *
     * @return property value of sqlResult
     */
    public static HashMap<String, String> getSqlResult() {
        return sqlResult;
    }
}