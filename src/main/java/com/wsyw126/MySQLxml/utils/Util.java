package com.wsyw126.MySQLxml.utils;


import com.wsyw126.MySQLxml.exception.SQLException;

import java.io.Closeable;
import java.io.IOException;


public class Util {

    private Util() {
    }

    /**
     * Check boolean is NOT false.
     */
    public static void check(boolean bool) {
        if (bool == false) {
            throw new SQLException("bool is false.");
        }
    }

    /**
     * Check object is NOT null.
     */
    public static void checkNull(Object obj) {
        if (obj == null) {
            throw new SQLException("obj  is null.");
        }
    }

    /**
     * Check for string is NOT null or empty string.
     */
    public static void checkEmptyString(String str) {
        if (StringUtil.isEmptyString(str)) {
            throw new SQLException("str is null or empty.");
        }
    }

    /**
     * Check the value's length.
     */
    public static void checkLength(byte[] values, int length) {
        Util.checkNull(values);

        if (values.length != length) {
            throw new SQLException("checkLength error. values.length="
                    + values.length + " length=" + length);
        }
    }

    /**
     * Check string's length.
     */
    public static void checkLength(String str, int length) {
        Util.checkNull(str);

        if (str.length() != length) {
            throw new SQLException("checkLength error. str=" + str
                    + " length=" + length);
        }
    }

    /**
     * Check for 2 objects have identity type.
     */
    public static void checkIdentityType(Object one, Object other) {
        checkNull(one);
        checkNull(other);

        if (one.getClass() != other.getClass()) {
            throw new SQLException("not same type. one = " + one
                    + " other = " + other);
        }
    }

    /**
     * Check for 2 objects are equal.
     */
    public static void checkEquals(Object one, Object other) {
        if (one == other) {
            return;
        }

        if (one == null || other == null) {
            throw new SQLException("null object. one = " + one
                    + " other = " + other);
        }
        if (!one.equals(other)) {
            throw new SQLException("not equal object. one = " + one
                    + " other = " + other);
        }
    }

    /**
     * Close Closeable.
     */
    public static void close(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            throw new SQLException("close closeable exception.", e);
        }
    }
}
