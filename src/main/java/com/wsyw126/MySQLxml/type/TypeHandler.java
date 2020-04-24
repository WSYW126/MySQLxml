package com.wsyw126.MySQLxml.type;

/**
 * Convert java type object to String[mysql ´æ´¢json´®]
 *
 * <pre>
 * In general, one type handler handle one specified java type.
 * A java type and its boxer type would be handled in one type handler.
 * </pre>
 *
 * @author yjp138557
 */
public interface TypeHandler {

    /**
     * Convert java object to sql's column bytes.
     *
     * @param type  java's type.
     * @param value java's object.
     * @return db column[json]
     */
    public String toString(Class<?> type, Object value);

    /**
     * Convert db column string to java object.
     *
     * @param type  java object's type.
     * @param value string[json].
     * @return java object.
     */

    public Object toObject(Class<?> type, String value);
}
