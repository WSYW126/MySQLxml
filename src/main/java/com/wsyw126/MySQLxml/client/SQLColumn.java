package com.wsyw126.MySQLxml.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * POJO field - table column annotation.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLColumn {

    /**
     * column name.
     *
     * @return column.
     */
    public String column();
}
