package com.ohohoho.noob.module.authority.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * ClassName: Constant
 */
@Table(name = "constant")
public class Constant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    private LocalDateTime operTime;

    private String operUser;

    private Long parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getOperTime() {
        return operTime;
    }

    public void setOperTime(LocalDateTime operTime) {
        this.operTime = operTime;
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
