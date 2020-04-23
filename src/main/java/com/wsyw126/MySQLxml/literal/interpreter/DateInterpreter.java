package com.wsyw126.MySQLxml.literal.interpreter;

import com.wsyw126.MySQLxml.literal.AbstractLiteralInterpreter;
import com.wsyw126.MySQLxml.utils.DateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DateInterpreter.
 */
public class DateInterpreter extends AbstractLiteralInterpreter {
    private static List<String> dateFormats = new ArrayList<String>();

    static {
        dateFormats.add(DateUtil.MSFormat);
        dateFormats.add(DateUtil.SecondFormat);
        dateFormats.add(DateUtil.MinuteFormat);
        dateFormats.add(DateUtil.HourFormat);
        dateFormats.add(DateUtil.DayFormat);
    }

    @Override
    public Class getTypeCanInterpret() {
        return Date.class;
    }

    @Override
    protected Object interpret_internal(String literalValue) {
        for (String s : dateFormats) {
            Date date = DateUtil.parse(literalValue, s);
            if (date != null) {
                return date;
            }
        }
        return null;
    }

}
