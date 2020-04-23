package com.wsyw126.MySQLxml.type;


import com.wsyw126.MySQLxml.exception.SQLException;
import com.wsyw126.MySQLxml.utils.Util;

/**
 * The skeleton implementation of TypeHandler.
 */
abstract public class AbstractTypeHandler implements TypeHandler {

    /**
     * Should this handler handle specified java type?
     */
    abstract protected boolean aboutToHandle(Class<?> type);

    abstract protected String innerToString(Class<?> type, Object value);

    abstract protected Object innerToObject(Class<?> type, String bytes);

    @Override
    public String toString(Class<?> type, Object value) {
        Util.checkNull(type);

        if (!aboutToHandle(type)) {
            throw new SQLException("wrong type to handle. type = "
                    + type);
        }

        if (value == null) {
            return null;
        }

        return innerToString(type, value);
    }

    @Override
    public Object toObject(Class<?> type, String value) {
        Util.checkNull(type);

        if (!aboutToHandle(type)) {
            throw new SQLException("wrong type to handle. type = "
                    + type);
        }

        Util.checkNull(value);

        return innerToObject(type, value);
    }

}
