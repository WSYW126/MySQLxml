package com.wsyw126.MySQLxml.type.handler;

import com.wsyw126.MySQLxml.type.AbstractTypeHandler;

public class EnumHandler extends AbstractTypeHandler {

    @Override
    protected boolean aboutToHandle(Class<?> type) {
        return type.isEnum();
    }

    @Override
    protected String innerToString(Class<?> type, Object value) {
        String name = ((Enum<?>) value).name();
        return name;
    }

    @Override
    protected Object innerToObject(Class type, String value) {
        return Enum.valueOf(type, value);
    }
}
