package com.wsyw126.MySQLxml.sql.node;

import com.wsyw126.MySQLxml.config.SimpleSQLRuntimeSetting;
import com.wsyw126.MySQLxml.sql.SQLNode;
import com.wsyw126.MySQLxml.sql.SQLNodeType;

import java.util.Map;

public class DynamicNode extends PrependNode {

    protected DynamicNode() {
        super(SQLNodeType.Dynamic);
    }

    @Override
    public void applyParaMap(Map<String, Object> para, StringBuilder sb,
                             Map<Object, Object> context,
                             SimpleSQLRuntimeSetting runtimeSetting) {

        for (SQLNode sqlNode : subNodeList) {
            sqlNode.applyParaMap(para, sb, context, runtimeSetting);
        }

    }

}
