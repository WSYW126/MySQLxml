package com.wsyw126.MySQLxml.sql.node.binary;

import com.wsyw126.MySQLxml.config.SimpleSQLRuntimeSetting;
import com.wsyw126.MySQLxml.sql.SQLNodeType;

import java.util.Map;

/**
 * @author xinzhi
 */
public class IsNotEqualNode extends BinaryNode {

    protected IsNotEqualNode() {
        super(SQLNodeType.IsNotEqual);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para,
                                           SimpleSQLRuntimeSetting runtimeSetting) {
        Object propertyObject = para.get(getProperty());
        Object compareObject = runtimeSetting.interpret(
                propertyObject.getClass(), getCompareValue());
        return !propertyObject.equals(compareObject);
    }
}
