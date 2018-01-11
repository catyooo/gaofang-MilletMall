package com.shop.po;

import java.util.Date;

public class OsProductParameter {
    private Long productParameterId;

    private Long productId;

    private String name;

    private String value;

    private Integer sort;

    private Date createTime;

    private Date updateTime;

    public Long getProductParameterId() {
        return productParameterId;
    }

    public void setProductParameterId(Long productParameterId) {
        this.productParameterId = productParameterId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}