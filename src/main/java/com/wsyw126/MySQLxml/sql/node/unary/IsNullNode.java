package com.wsyw126.MySQLxml.sql.node.unary;

import com.wsyw126.MySQLxml.config.SimpleSQLRuntimeSetting;
import com.wsyw126.MySQLxml.sql.SQLNodeType;

import java.util.Map;

/**
 * @author xinzhi
 */
public class IsNullNode extends UnaryNode {

    protected IsNullNode() {
        super(SQLNodeType.IsNull);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para,
                                           SimpleSQLRuntimeSetting runtimeSetting) {
        return para.containsKey(getProperty())
                && para.get(getProperty()) == null;
    }
}
