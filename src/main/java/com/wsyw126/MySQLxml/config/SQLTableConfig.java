package com.wsyw126.MySQLxml.config;

import com.wsyw126.MySQLxml.client.TypeInfo;
import com.wsyw126.MySQLxml.exception.SQLException;
import com.wsyw126.MySQLxml.sql.SQLQuery;
import com.wsyw126.MySQLxml.utils.Util;
import com.wsyw126.MySQLxml.utils.XmlUtil;
import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * SQLTable's config info.
 *
 * <pre>
 * Including following info.
 * 1 TableSchema Table's schema.
 * 2 queryMap SQL collection.
 * 3 mapping JOPO's info.
 * </pre>
 */
public class SQLTableConfig {
    /**
     * log.
     */
    final private static Logger log = Logger.getLogger(SQLTableConfig.class);

    //------------bean config-------------------
    /**
     * Config resource.
     */
    @ConfigAttr
    private Resource configResource;

    //------------bean config-------------------
    private SQLTableSchema sqlTableSchema = new SQLTableSchema();

    private ConcurrentMap<String, SQLQuery> queryMap = new ConcurrentHashMap<>();

    /**
     * type info mapping of class.
     */
    private ConcurrentMap<Class<?>, TypeInfo> mappingTypes = new ConcurrentHashMap<Class<?>, TypeInfo>();

    /**
     * Init this object.
     */
    public void init() {
        Util.checkNull(configResource);

        try {
            List<SQLColumnSchema> sqlColumnSchemas = new ArrayList<>();
            SQLTableConfigParser.parseTableSchema(
                    configResource.getInputStream(), sqlTableSchema,
                    sqlColumnSchemas);
            sqlTableSchema.init(sqlColumnSchemas);

            List<SQLQuery> sqlQueries = SQLTableConfigParser
                    .parseSQLQuery(configResource.getInputStream());

            addSQLQueryList(sqlQueries);

            List<Node> typeInfoNodes = XmlUtil.findTopLevelNodes(
                    configResource.getInputStream(), "MappingType");

            for (Node typeInfoNode : typeInfoNodes) {
                TypeInfo typeInfo = TypeInfo.parseNode(typeInfoNode,
                        sqlTableSchema);
                addTypeInfo(typeInfo);
            }

            log.info(this);

        } catch (Exception e) {
            log.error("parseConfig error.", e);
            throw new SQLException("parseConfig error.", e);
        }
    }

    /**
     * Find type info.
     *
     * <pre>
     * There are 3 ways to config type info .
     * 1 in config xml.
     * 2 use @SQLTable.
     * 3 simplesql will use reflection to discover the mapping.
     * </pre>
     */
    public TypeInfo findTypeInfo(Class<?> type) {
        Util.checkNull(type);
        TypeInfo result = mappingTypes.get(type);

        if (result != null) {
            return result;
        }

        result = TypeInfo.parseInAir(type, sqlTableSchema);
        if (result != null) {
            addTypeInfo(result);
            return result;
        }

        throw new SQLException("can't find type info. type=" + type);
    }

    private void addTypeInfo(TypeInfo typeInfo) {
        log.info("register TypeInfo\n" + typeInfo);
        mappingTypes.putIfAbsent(typeInfo.getType(), typeInfo);
    }

    /**
     * add sqlQueryList.
     */
    public void addSQLQueryList(List<SQLQuery> sqlQueryList) {
        for (SQLQuery sqlQuery : sqlQueryList) {
            queryMap.put(sqlQuery.getId(), sqlQuery);
        }
    }

    public Resource getConfigResource() {
        return configResource;
    }

    public void setConfigResource(Resource configResource) {
        this.configResource = configResource;
    }

    /**
     * Getter method for property <tt>sqlTableSchema</tt>.
     *
     * @return property value of sqlTableSchema
     */
    public SQLTableSchema getSqlTableSchema() {
        return sqlTableSchema;
    }

    public Map<String, SQLQuery> getQueryMap() {
        return queryMap;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(sqlTableSchema.toString());
        return sb.toString();
    }
}
