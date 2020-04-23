package com.wsyw126.MySQLxml.sql.node.text;

import com.wsyw126.MySQLxml.config.SimpleSQLRuntimeSetting;
import com.wsyw126.MySQLxml.sql.SQLNodeType;

import java.util.Map;

/**
 * @author xinzhi
 */
public class CDATASectionNode extends BaseTextNode {

    protected CDATASectionNode() {
        super(SQLNodeType.CDATASection);
    }

    @Override
    public void applyParaMap(Map<String, Object> para, StringBuilder sb,
                             Map<Object, Object> context,
                             SimpleSQLRuntimeSetting runtimeSetting) {
        if (getTextValue() != null) {
            sb.append(BlankSpace);
            sb.append(getTextValue());
        }
    }
}
