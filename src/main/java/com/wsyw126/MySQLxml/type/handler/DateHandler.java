package com.wsyw126.MySQLxml.type.handler;

import com.wsyw126.MySQLxml.type.AbstractTypeHandler;
import com.wsyw126.MySQLxml.utils.DateUtil;

import java.util.Date;

public class DateHandler extends AbstractTypeHandler {

    @Override
    protected boolean aboutToHandle(Class<?> type) {
        return type == Date.class;
    }

    @Override
    protected String innerToString(Class<?> type, Object value) {
        return DateUtil.format((Date) value, DateUtil.MSFormat);
    }

    @Override
    protected Object innerToObject(Class<?> type, String value) {

        return DateUtil.parse(value, DateUtil.MSFormat);
    }
}
