package com.wsyw126.MySQLxml.type.handler;

import com.wsyw126.MySQLxml.type.AbstractTypeHandler;

public class ShortHandler extends AbstractTypeHandler {

    @Override
    protected boolean aboutToHandle(Class<?> type) {
        return type == short.class || type == Short.class;
    }

    @Override
    protected String innerToString(Class<?> type, Object value) {
        return Short.toString((Short) value);
    }

    @Override
    protected Object innerToObject(Class<?> type, String value) {
        return Short.parseShort(value);
    }
}
