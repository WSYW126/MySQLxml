package com.wsyw126.MySQLxml.type.handler;

import com.wsyw126.MySQLxml.type.AbstractTypeHandler;

public class DoubleHandler extends AbstractTypeHandler {

    @Override
    protected boolean aboutToHandle(Class<?> type) {
        return type == double.class || type == Double.class;
    }

    @Override
    protected String innerToString(Class<?> type, Object value) {
        return Double.toString(((Double) value));
    }

    @Override
    protected Object innerToObject(Class<?> type, String value) {
        return Double.parseDouble(value);
    }
}
