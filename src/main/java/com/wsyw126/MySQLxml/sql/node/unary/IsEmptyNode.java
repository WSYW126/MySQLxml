package com.wsyw126.MySQLxml.sql.node.unary;

import com.wsyw126.MySQLxml.config.SimpleSQLRuntimeSetting;
import com.wsyw126.MySQLxml.exception.SQLException;
import com.wsyw126.MySQLxml.sql.SQLNodeType;

import java.util.Collection;
import java.util.Map;

/**
 * @author xinzhi
 */
public class IsEmptyNode extends UnaryNode {

    protected IsEmptyNode() {
        super(SQLNodeType.IsEmpty);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para,
                                           SimpleSQLRuntimeSetting runtimeSetting) {
        if (para.containsKey(getProperty())) {
            Object value = para.get(getProperty());
            if (value == null) {
                return true;
            }
            if (value instanceof String) {
                return String.class.cast(value).isEmpty();
            }
            if (value instanceof Collection) {
                return Collection.class.cast(value).isEmpty();
            }
        }
        throw new SQLException("IsEmptyNode invalid value.");
    }
}
