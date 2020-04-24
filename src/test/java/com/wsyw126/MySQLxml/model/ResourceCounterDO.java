package com.wsyw126.MySQLxml.model;


import com.wsyw126.MySQLxml.client.SQLColumn;

import java.util.Date;

public class ResourceCounterDO {

    /**
     * 计数
     */
    @SQLColumn(column = "COUNT")
    private Integer count;
    /**
     * 任务创建时间
     */
    @SQLColumn(column = "GMT_CREATE")
    private Date gmtCreate;
    /**
     * 任务修改时间
     */
    @SQLColumn(column = "GMT_MODIFY")
    private Date gmtModify;

    /**
     * Getter method for property <tt>count</tt>.
     *
     * @return property value of count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Setter method for property <tt>count</tt>.
     *
     * @param count value to be assigned to property count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * Getter method for property <tt>gmtCreate</tt>.
     *
     * @return property value of gmtCreate
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * Setter method for property <tt>gmtCreate</tt>.
     *
     * @param gmtCreate value to be assigned to property gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * Getter method for property <tt>gmtModify</tt>.
     *
     * @return property value of gmtModify
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * Setter method for property <tt>gmtModify</tt>.
     *
     * @param gmtModify value to be assigned to property gmtModify
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }


}