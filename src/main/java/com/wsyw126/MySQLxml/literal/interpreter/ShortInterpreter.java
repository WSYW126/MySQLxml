package com.wsyw126.MySQLxml.literal.interpreter;

import com.wsyw126.MySQLxml.literal.AbstractLiteralInterpreter;

/**
 * ShortInterpreter.
 */
public class ShortInterpreter extends AbstractLiteralInterpreter {

    @Override
    public Class getTypeCanInterpret() {
        return Short.class;
    }

    @Override
    protected Object interpret_internal(String literalValue) {
        return Short.parseShort(literalValue);
    }
}