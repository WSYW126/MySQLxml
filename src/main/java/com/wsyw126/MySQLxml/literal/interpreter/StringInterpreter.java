package com.wsyw126.MySQLxml.literal.interpreter;

import com.wsyw126.MySQLxml.literal.AbstractLiteralInterpreter;

/**
 * StringInterpreter.
 */
public class StringInterpreter extends AbstractLiteralInterpreter {

    @Override
    public Class getTypeCanInterpret() {
        return String.class;
    }

    @Override
    protected Object interpret_internal(String literalValue) {
        return literalValue;
    }
}
