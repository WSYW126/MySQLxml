package com.wsyw126.MySQLxml.sql.node.unary;

import com.wsyw126.MySQLxml.config.SimpleSQLRuntimeSetting;
import com.wsyw126.MySQLxml.sql.SQLNodeType;

import java.util.Map;

/**
 * @author xinzhi
 */
public class IsPropertyAvailableNode extends UnaryNode {

    protected IsPropertyAvailableNode() {
        super(SQLNodeType.IsPropertyAvailable);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para,
                                           SimpleSQLRuntimeSetting runtimeSetting) {
        return para.containsKey(getProperty());
    }

}