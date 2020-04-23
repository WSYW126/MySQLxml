package com.wsyw126.MySQLxml.literal.interpreter;

import com.wsyw126.MySQLxml.literal.AbstractLiteralInterpreter;

/**
 * DoubleInterpreter.
 */
public class DoubleInterpreter extends AbstractLiteralInterpreter {

    @Override
    public Class getTypeCanInterpret() {
        return Double.class;
    }

    @Override
    protected Object interpret_internal(String literalValue) {
        return Double.parseDouble(literalValue);
    }
}