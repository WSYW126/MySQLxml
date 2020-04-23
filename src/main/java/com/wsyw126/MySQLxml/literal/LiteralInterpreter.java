package com.wsyw126.MySQLxml.literal;


/**
 * Convert literal value to object of specified type.
 *
 * <pre>
 * In general, one literal interpreter interpret one specified java type.
 * A java type and its boxer type would be interpreted in one interpreter.
 * </pre>
 */
public interface LiteralInterpreter {

    /**
     * Interpret literalValue to java object.
     *
     * @param literalValue literalValue.
     * @return java object.
     */
    public Object interpret(String literalValue);

    /**
     * Type to interpret.
     *
     * @return Type to interpret.
     */

    public Class getTypeCanInterpret();
}
