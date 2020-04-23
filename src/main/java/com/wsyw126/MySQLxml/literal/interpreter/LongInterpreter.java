package com.wsyw126.MySQLxml.literal.interpreter;

import com.wsyw126.MySQLxml.literal.AbstractLiteralInterpreter;

/**
 * LongInterperter.
 */
public class LongInterpreter extends AbstractLiteralInterpreter {

    @Override
    public Class getTypeCanInterpret() {
        return Long.class;
    }

    @Override
    protected Object interpret_internal(String literalValue) {
        return Long.parseLong(literalValue);
    }
}
