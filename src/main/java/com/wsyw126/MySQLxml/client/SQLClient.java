package com.wsyw126.MySQLxml.client;

import java.util.Map;

/**
 * @author yangjunpeng
 * @version $Id: SQLClient.java, v 0.1 2020年04月24日 上午11:25 yangjunpeng Exp $
 */
public interface SQLClient {
    <T> T findObject(Class<? extends T> type, String id, Map<String, Object> para);
}