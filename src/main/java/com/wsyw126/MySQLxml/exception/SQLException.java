package com.wsyw126.MySQLxml.exception;

public class SQLException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SQLException(String message) {
        super(message);
    }

    public SQLException(String message, Throwable cause) {
        super(message, cause);
    }

    public SQLException(Throwable cause) {
        super(cause);
    }
}
