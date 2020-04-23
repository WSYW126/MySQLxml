package com.wsyw126.MySQLxml.sql.node;

import com.wsyw126.MySQLxml.config.SimpleSQLRuntimeSetting;
import com.wsyw126.MySQLxml.sql.SQLNode;
import com.wsyw126.MySQLxml.sql.SQLNodeType;
import com.wsyw126.MySQLxml.utils.Util;

import java.util.Map;

/**
 * @author xinzhi
 */
public class StatementNode extends SQLNode {
    protected StatementNode() {
        super(SQLNodeType.Statement);
    }

    @Override
    public void applyParaMap(Map<String, Object> para, StringBuilder sb,
                             Map<Object, Object> context,
                             SimpleSQLRuntimeSetting runtimeSetting) {
        Util.checkNull(sb);
        Util.checkNull(context);
        Util.checkNull(runtimeSetting);

        for (SQLNode sqlNode : subNodeList) {
            sqlNode.applyParaMap(para, sb, context, runtimeSetting);
        }

    }

}
