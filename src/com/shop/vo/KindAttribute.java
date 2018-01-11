package com.shop.vo;

import java.util.Date;

/**
 * @Author 康健
 * @Date 2017/8/11 8:14
 */
public class KindAttribute {

    private Long specAttrId;

    private Long specificationId;

    private String name;

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
        this.name = name;
    }
}
