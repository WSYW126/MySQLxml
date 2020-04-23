package com.wsyw126.MySQLxml.literal.interpreter;

import com.wsyw126.MySQLxml.literal.AbstractLiteralInterpreter;
import com.wsyw126.MySQLxml.utils.Util;


/**
 * CharInterperter.
 */
public class CharInterpreter extends AbstractLiteralInterpreter {

    @Override
    public Class getTypeCanInterpret() {
        return Character.class;
    }

    @Override
    protected Object interpret_internal(String literalValue) {
        Util.checkLength(literalValue, 1);
        return literalValue.charAt(0);
    }
}