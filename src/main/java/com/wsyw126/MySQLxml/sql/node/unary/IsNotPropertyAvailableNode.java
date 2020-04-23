package com.wsyw126.MySQLxml.sql.node.unary;

import com.wsyw126.MySQLxml.config.SimpleSQLRuntimeSetting;
import com.wsyw126.MySQLxml.sql.SQLNodeType;

import java.util.Map;

/**
 * @author xinzhi
 */
public class IsNotPropertyAvailableNode extends UnaryNode {

    protected IsNotPropertyAvailableNode() {
        super(SQLNodeType.IsNotPropertyAvailable);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para,
                                           SimpleSQLRuntimeSetting runtimeSetting) {
        return !para.containsKey(getProperty());
    }

}