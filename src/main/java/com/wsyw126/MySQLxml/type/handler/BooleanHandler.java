package com.wsyw126.MySQLxml.type.handler;


import com.wsyw126.MySQLxml.type.AbstractTypeHandler;

public class BooleanHandler extends AbstractTypeHandler {

    @Override
    protected boolean aboutToHandle(Class<?> type) {
        return type == boolean.class || type == Boolean.class;
    }

    @Override
    protected String innerToString(Class<?> type, Object value) {
        return ((Boolean) value).toString();
    }

    @Override
    protected Object innerToObject(Class<?> type, String value) {
        return Boolean.parseBoolean(value);
    }

}
