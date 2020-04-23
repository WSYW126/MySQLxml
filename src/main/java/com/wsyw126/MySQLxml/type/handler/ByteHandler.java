package com.wsyw126.MySQLxml.type.handler;

import com.wsyw126.MySQLxml.type.AbstractTypeHandler;

public class ByteHandler extends AbstractTypeHandler {

    @Override
    protected boolean aboutToHandle(Class<?> type) {
        return type == byte.class || type == Byte.class;
    }

    @Override
    protected String innerToString(Class<?> type, Object value) {
        return Byte.toString((byte) value);

    }

    @Override
    protected Object innerToObject(Class<?> type, String value) {
        return Byte.parseByte(value);
    }
}
