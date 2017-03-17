package com.ohohoho.noob.module.constant.domain;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * ClassName: InsertNewConstant
 */
@Table(name = "constant")
public class InsertNewConstant {

    /**
     * 常量的键，会在程序中声明，已用于获取value或者子常量
     */
    @Column(name = "`key`")
    private String key;

    /**
     * 常量的值
     */
    @Column(name = "`value`")
    private String value;

    /**
     * 备注
     */
    private String remark;

    private String operUser;

    private Long parentId;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOperUser() {
        return operUser;
    }

    public void setOperUser(String operUser) {
        this.operUser = operUser;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
