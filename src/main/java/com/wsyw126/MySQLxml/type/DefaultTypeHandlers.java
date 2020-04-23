package com.wsyw126.MySQLxml.type;

import com.wsyw126.MySQLxml.type.handler.BooleanHandler;
import com.wsyw126.MySQLxml.type.handler.ByteHandler;
import com.wsyw126.MySQLxml.type.handler.CharacterHandler;
import com.wsyw126.MySQLxml.type.handler.DateHandler;
import com.wsyw126.MySQLxml.type.handler.DoubleHandler;
import com.wsyw126.MySQLxml.type.handler.EnumHandler;
import com.wsyw126.MySQLxml.type.handler.FloatHandler;
import com.wsyw126.MySQLxml.type.handler.IntegerHandler;
import com.wsyw126.MySQLxml.type.handler.LongHandler;
import com.wsyw126.MySQLxml.type.handler.ShortHandler;
import com.wsyw126.MySQLxml.type.handler.StringHandler;
import com.wsyw126.MySQLxml.utils.ClassUtil;
import com.wsyw126.MySQLxml.utils.Util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Default TypeHandler.
 */
public class DefaultTypeHandlers {
    private static EnumHandler enumHandler = new EnumHandler();
    private static Map<Class<?>, TypeHandler> defaultHandlers = new HashMap<Class<?>, TypeHandler>();

    static {
        defaultHandlers.put(String.class, new StringHandler());
        defaultHandlers.put(Date.class, new DateHandler());

        defaultHandlers.put(Boolean.class, new BooleanHandler());

        defaultHandlers.put(Character.class, new CharacterHandler());

        defaultHandlers.put(Byte.class, new ByteHandler());
        defaultHandlers.put(Short.class, new ShortHandler());
        defaultHandlers.put(Integer.class, new IntegerHandler());
        defaultHandlers.put(Long.class, new LongHandler());
        defaultHandlers.put(Float.class, new FloatHandler());
        defaultHandlers.put(Double.class, new DoubleHandler());
    }

    public static TypeHandler findDefaultHandler(Class<?> type) {
        Util.checkNull(type);

        type = ClassUtil.tryConvertToBoxClass(type);

        if (type.isEnum()) {
            return enumHandler;
        }

        return defaultHandlers.get(type);
    }
}
