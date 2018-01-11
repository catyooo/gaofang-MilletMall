package com.shop.vo;

import java.util.Date;
import java.util.List;

/**
 * @Author 康健
 * @Date 2017/8/11 8:12
 */
public class KindVO {
    private Long specificationId;

    private Long categoryId;

    private String name;

    private List<KindAttribute> kindAttributes;

    public Long getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Long specificationId) {
        this.specificationId = specificationId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<KindAttribute> getKindAttributes() {
        return kindAttributes;
    }

    public void setKindAttributes(List<KindAttribute> kindAttributes) {
        this.kindAttributes = kindAttributes;
    }
}
