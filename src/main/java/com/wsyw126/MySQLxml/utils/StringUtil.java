package com.wsyw126.MySQLxml.utils;

import java.util.List;
import java.util.Map;


public class StringUtil {

    private StringUtil() {
    }

    /**
     * String is null or empty string.
     */
    public static boolean isEmptyString(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * String is NOT null or empty string.
     */
    public static boolean isNotEmptyString(String str) {
        return !isEmptyString(str);
    }

    /**
     * Appends message and value to StringBuiler.
     */
    public static void append(StringBuilder sb, String msg,
                              Object value) {
        Util.checkNull(sb);

        sb.append(msg + "=" + value + "\n");
    }

    /**
     * Appends message and map to StringBuilder.
     */
    public static void append(StringBuilder sb, String msg,
                              Map<String, String> map) {
        Util.checkNull(sb);

        sb.append(msg + "\n");
        if (map != null) {
            for (String key : map.keySet()) {
                sb.append(key + "=" + map.get(key) + "\n");
            }
        }
    }

    /**
     * Appends message and list to StringBuilder.
     */
    public static void append(StringBuilder sb, String msg,
                              List<String> list) {
        Util.checkNull(sb);

        sb.append(msg + "\n");
        if (list != null) {
            for (String s : list) {
                sb.append(s + "\n");
            }
        }
    }

    /**
     * Reverse string.
     */
    public static String reverse(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return new StringBuilder(str).reverse().toString();
    }
}
