package com.wsyw126.MySQLxml.type;


import com.wsyw126.MySQLxml.exception.SQLException;
import com.wsyw126.MySQLxml.utils.ClassUtil;
import com.wsyw126.MySQLxml.utils.Util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * The holder of typeHandler's instance.
 */
public class TypeHandlerHolder {

    /**
     * TypeHandler'Type -> TypeHandler's instance cache.
     */
    private static ConcurrentMap<String, TypeHandler> typeHandlerCache = new ConcurrentHashMap<String, TypeHandler>();

    /**
     * Find TypeHandler instance using type's class name.
     *
     * @param type TypeHandler's class name.
     * @return TypeHandler instance.
     */
    public static TypeHandler findTypeHandler(String type) {
        Util.checkEmptyString(type);

        if (typeHandlerCache.get(type) == null) {
            try {
                Class<?> c = ClassUtil.forName(type);
                typeHandlerCache.putIfAbsent(type,
                        (TypeHandler) c.newInstance());
            } catch (Exception e) {
                throw new SQLException(e);
            }
        }
        return typeHandlerCache.get(type);
    }
}
