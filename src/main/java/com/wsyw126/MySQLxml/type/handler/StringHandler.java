package com.wsyw126.MySQLxml.type.handler;

import com.wsyw126.MySQLxml.type.AbstractTypeHandler;

public class StringHandler extends AbstractTypeHandler {

    @Override
    protected boolean aboutToHandle(Class<?> type) {
        return type == String.class;
    }

    @Override
    protected String innerToString(Class<?> type, Object value) {
        return (String) value;
    }

    @Override
    protected Object innerToObject(Class<?> type, String value) {
        return value;
    }
}
