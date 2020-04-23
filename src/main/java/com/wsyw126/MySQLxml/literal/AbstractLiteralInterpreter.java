package com.wsyw126.MySQLxml.literal;


import com.wsyw126.MySQLxml.utils.Util;

/**
 * The skeleton implementation of LiteralInterpreter.
 *
 * @author xinzhi
 */
abstract public class AbstractLiteralInterpreter implements LiteralInterpreter {

    abstract protected Object interpret_internal(
            String literalValue);


    @Override
    public Object interpret(String literalValue) {

        Util.checkNull(literalValue);
        Object obj = interpret_internal(literalValue);
        Util.checkNull(obj);

        return obj;
    }

}
