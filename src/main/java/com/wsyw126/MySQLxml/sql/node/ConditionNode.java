package com.wsyw126.MySQLxml.sql.node;

import com.wsyw126.MySQLxml.config.SimpleSQLRuntimeSetting;
import com.wsyw126.MySQLxml.sql.SQLNode;
import com.wsyw126.MySQLxml.sql.SQLNodeType;
import com.wsyw126.MySQLxml.utils.StringUtil;

import java.util.Map;

/**
 * @author xinzhi
 */
abstract public class ConditionNode extends PrependNode {

    protected ConditionNode(SQLNodeType sqlNodeType) {
        super(sqlNodeType);
    }

    /**
     * isConditionSatisfied.
     */
    abstract protected boolean isConditionSatisfied(Map<String, Object> para,
                                                    SimpleSQLRuntimeSetting runtimeSetting);

    @Override
    final public void applyParaMap(Map<String, Object> para, StringBuilder sb,
                                   Map<Object, Object> context,
                                   SimpleSQLRuntimeSetting runtimeSetting) {
        if (isConditionSatisfied(para, runtimeSetting)) {
            //if this is dynamic node's child node, when the first time isConditionSatisfied to be true,
            //use dynamic node's non-empty prepend value to override this node's prepend value.
            String prepend = getPrependValue();

            SQLNode parent = this.getParent();
            if (parent != null
                    && parent.getSqlNodeType() == SQLNodeType.Dynamic
                    && !context.containsKey(parent)) {

                context.put(parent, "override prepend once");

                String parentPrepend = ((DynamicNode) parent).getPrependValue();
                if (StringUtil.isNotEmptyString(parentPrepend)) {
                    prepend = parentPrepend;
                }
            }

            if (prepend != null) {
                sb.append(BlankSpace);
                sb.append(prepend);
            }

            for (SQLNode sqlNode : subNodeList) {
                sqlNode.applyParaMap(para, sb, context, runtimeSetting);
            }
        }
    }
}
