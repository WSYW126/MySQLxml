package com.wsyw126.MySQLxml.utils;


public class CompareUtil {

    private CompareUtil() {
    }

    /**
     * compare one and other.
     *
     * @return a negative integer, zero, or a positive integer as object one is
     * less than, equal to, or greater than the object other.
     */
    public static int compare(Object one, Object other) {
        Util.checkNull(one);
        Util.checkNull(other);

        Comparable cOne = (Comparable) one;
        return cOne.compareTo(other);
    }
}
