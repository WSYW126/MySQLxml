package com.wsyw126.MySQLxml.literal.interpreter;

import com.wsyw126.MySQLxml.literal.AbstractLiteralInterpreter;

/**
 * ByteInterpreter.
 */
public class ByteInterpreter extends AbstractLiteralInterpreter {

    @Override
    public Class getTypeCanInterpret() {
        return Byte.class;
    }

    @Override
    protected Object interpret_internal(String literalValue) {
        return Byte.parseByte(literalValue);
    }
}