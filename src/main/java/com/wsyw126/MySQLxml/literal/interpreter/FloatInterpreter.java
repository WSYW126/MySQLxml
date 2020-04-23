package com.wsyw126.MySQLxml.literal.interpreter;

import com.wsyw126.MySQLxml.literal.AbstractLiteralInterpreter;

public class FloatInterpreter extends AbstractLiteralInterpreter {

    @Override
    public Class getTypeCanInterpret() {
        return Float.class;
    }

    @Override
    protected Object interpret_internal(String literalValue) {
        return Float.parseFloat(literalValue);
    }
}