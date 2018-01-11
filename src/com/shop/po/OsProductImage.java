package com.shop.po;

import java.util.Date;

public class OsProductImage {
    private Long picImgId;

    private Long productId;

    private String picImg;

    private Byte sort;

    private Byte status;

    private Date createTime;

    public Long getPicImgId() {
        return picImgId;
    }

    public void setPicImgId(Long picImgId) {
        this.picImgId = picImgId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getPicImg() {
        return picImg;
    }

    public void setPicImg(String picImg) {
        this.picImg = picImg == null ? null : picImg.trim();
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}