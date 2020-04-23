package com.wsyw126.MySQLxml.sql.node.unary;

import com.wsyw126.MySQLxml.config.SimpleSQLRuntimeSetting;
import com.wsyw126.MySQLxml.sql.SQLNodeType;

import java.util.Map;

/**
 * @author xinzhi
 */
public class IsNotNullNode extends UnaryNode {

    protected IsNotNullNode() {
        super(SQLNodeType.IsNotNull);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para,
                                           SimpleSQLRuntimeSetting runtimeSetting) {
        return para.containsKey(getProperty())
                && para.get(getProperty()) != null;
    }
}
