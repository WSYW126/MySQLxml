package com.wsyw126.MySQLxml.type.handler;

import com.wsyw126.MySQLxml.type.AbstractTypeHandler;

public class IntegerHandler extends AbstractTypeHandler {

    @Override
    protected boolean aboutToHandle(Class<?> type) {
        return type == int.class || type == Integer.class;
    }

    @Override
    protected String innerToString(Class<?> type, Object value) {
        return Integer.toString((Integer) value);

    }

    @Override
    protected Object innerToObject(Class<?> type, String value) {
        return Integer.parseInt(value);
    }

}
