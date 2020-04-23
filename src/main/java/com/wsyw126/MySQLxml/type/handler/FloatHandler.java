package com.wsyw126.MySQLxml.type.handler;

import com.wsyw126.MySQLxml.type.AbstractTypeHandler;

public class FloatHandler extends AbstractTypeHandler {

    @Override
    protected boolean aboutToHandle(Class<?> type) {
        return type == float.class || type == Float.class;
    }

    @Override
    protected String innerToString(Class<?> type, Object value) {
        return Float.toString((Float) value);
    }

    @Override
    protected Object innerToObject(Class<?> type, String value) {
        return Float.parseFloat(value);
    }
}
