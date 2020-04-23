package com.wsyw126.MySQLxml.type.handler;

import com.wsyw126.MySQLxml.type.AbstractTypeHandler;

public class LongHandler extends AbstractTypeHandler {

    @Override
    protected boolean aboutToHandle(Class<?> type) {
        return type == long.class || type == Long.class;
    }

    @Override
    protected String innerToString(Class<?> type, Object value) {
        return Long.toString((Long) value);
    }

    @Override
    protected Object innerToObject(Class<?> type, String value) {
        return Long.parseLong(value);
    }
}
