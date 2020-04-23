package com.wsyw126.MySQLxml.literal.interpreter;

import com.wsyw126.MySQLxml.literal.AbstractLiteralInterpreter;


/**
 * BooleanInterpreter.
 */
public class BooleanInterpreter extends AbstractLiteralInterpreter {

    @Override
    public Class getTypeCanInterpret() {
        return Boolean.class;
    }

    @Override
    protected Object interpret_internal(String literalValue) {
        return Boolean.parseBoolean(literalValue);
    }
}