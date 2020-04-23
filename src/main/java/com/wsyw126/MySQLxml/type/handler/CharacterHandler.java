package com.wsyw126.MySQLxml.type.handler;

import com.wsyw126.MySQLxml.type.AbstractTypeHandler;
import com.wsyw126.MySQLxml.utils.Util;

public class CharacterHandler extends AbstractTypeHandler {

    @Override
    protected boolean aboutToHandle(Class<?> type) {
        return type == char.class || type == Character.class;
    }

    @Override
    protected String innerToString(Class<?> type, Object value) {
        return ((Character) value).toString();
    }

    @Override
    protected Object innerToObject(Class<?> type, String value) {
        Util.checkLength(value, 1);
        return value.charAt(0);
    }
}
