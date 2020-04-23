package com.wsyw126.MySQLxml.config;

import com.wsyw126.MySQLxml.literal.LiteralInterpreter;
import com.wsyw126.MySQLxml.literal.interpreter.BooleanInterpreter;
import com.wsyw126.MySQLxml.literal.interpreter.ByteInterpreter;
import com.wsyw126.MySQLxml.literal.interpreter.CharInterpreter;
import com.wsyw126.MySQLxml.literal.interpreter.DateInterpreter;
import com.wsyw126.MySQLxml.literal.interpreter.DoubleInterpreter;
import com.wsyw126.MySQLxml.literal.interpreter.FloatInterpreter;
import com.wsyw126.MySQLxml.literal.interpreter.IntegerInterpreter;
import com.wsyw126.MySQLxml.literal.interpreter.LongInterpreter;
import com.wsyw126.MySQLxml.literal.interpreter.ShortInterpreter;
import com.wsyw126.MySQLxml.literal.interpreter.StringInterpreter;
import com.wsyw126.MySQLxml.utils.ClassUtil;
import com.wsyw126.MySQLxml.utils.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SimpleSQLRuntimeSetting.
 */
public class SimpleSQLRuntimeSetting {
    /**
     * LiteralInterpreter list.
     */
    private List<LiteralInterpreter> literalInterpreterList;

    private Map<Class, LiteralInterpreter> literalInterpreterCache = new HashMap<>();
    private Map<Class, LiteralInterpreter> buildInliteralInterpreterCache = new HashMap<>();

    public SimpleSQLRuntimeSetting() {


        List<LiteralInterpreter> buildInLiteralInterpreterList = new ArrayList<>();
        buildInLiteralInterpreterList.add(new BooleanInterpreter());
        buildInLiteralInterpreterList.add(new ByteInterpreter());
        buildInLiteralInterpreterList.add(new CharInterpreter());
        buildInLiteralInterpreterList.add(new DateInterpreter());
        buildInLiteralInterpreterList.add(new DoubleInterpreter());
        buildInLiteralInterpreterList.add(new FloatInterpreter());
        buildInLiteralInterpreterList.add(new IntegerInterpreter());
        buildInLiteralInterpreterList.add(new LongInterpreter());
        buildInLiteralInterpreterList.add(new ShortInterpreter());
        buildInLiteralInterpreterList.add(new StringInterpreter());

        for (LiteralInterpreter interpreter : buildInLiteralInterpreterList) {
            Class type = ClassUtil.tryConvertToBoxClass(interpreter
                    .getTypeCanInterpret());
            buildInliteralInterpreterCache.put(type, interpreter);
        }
    }

    public Object interpret(Class type, String literalValue) {
        Util.checkNull(type);
        Util.checkNull(literalValue);

        Class temType = ClassUtil.tryConvertToBoxClass(type);

        if (literalInterpreterCache.containsKey(temType)) {
            return literalInterpreterCache.get(temType).interpret(literalValue);
        }

        if (buildInliteralInterpreterCache.containsKey(temType)) {
            return buildInliteralInterpreterCache.get(temType).interpret(
                    literalValue);
        }

        Object result = null;
        if (temType.isEnum()) {
            result = Enum.valueOf(type, literalValue);
        }
        Util.checkNull(result);

        return result;
    }

    public List<LiteralInterpreter> findAllLiteralInterpreter() {
        Map<Class, LiteralInterpreter> tem = new HashMap<>();
        tem.putAll(buildInliteralInterpreterCache);
        tem.putAll(literalInterpreterCache);
        return new ArrayList<>(tem.values());
    }

    public List<LiteralInterpreter> getLiteralInterpreterList() {
        return literalInterpreterList;
    }

    public void setLiteralInterpreterList(
            List<LiteralInterpreter> literalInterpreterList) {
        this.literalInterpreterList = literalInterpreterList;
        if (this.literalInterpreterList != null) {
            for (LiteralInterpreter interpreter : this.literalInterpreterList) {
                Class type = ClassUtil.tryConvertToBoxClass(interpreter
                        .getTypeCanInterpret());
                literalInterpreterCache.put(type, interpreter);
            }
        }
    }
}
