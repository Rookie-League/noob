package com.ohohoho.noob.module.constant.domain;

import javax.persistence.Table;

/**
 * ClassName: InsertNewConstant
 */
@Table(name = "constant")
public class ConstantParentId {

    public ConstantParentId(Long parentId) {
        setParentId(parentId);
    }

    private Long parentId;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
