package com.shop.po;

import java.util.Date;

public class OsSpecificationAttribute {
    private Long specAttrId;

    private Long specificationId;

    private String name;

    private Date createTime;

    public Long getSpecAttrId() {
        return specAttrId;
    }

    public void setSpecAttrId(Long specAttrId) {
        this.specAttrId = specAttrId;
    }

    public Long getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Long specificationId) {
        this.specificationId = specificationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}