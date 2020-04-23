package com.wsyw126.MySQLxml.literal.interpreter;

import com.wsyw126.MySQLxml.literal.AbstractLiteralInterpreter;

/**
 * IntegerInterpreter.
 */
public class IntegerInterpreter extends AbstractLiteralInterpreter {

    @Override
    public Class getTypeCanInterpret() {
        return Integer.class;
    }

    @Override
    protected Object interpret_internal(String literalValue) {
        return Integer.parseInt(literalValue);
    }

}
