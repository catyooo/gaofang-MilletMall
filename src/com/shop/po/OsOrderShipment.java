package com.shop.po;

import java.util.Date;

public class OsOrderShipment {
    private Long orderShipmentId;

    private Long orderId;

    private String userName;

    private String userPhone;

    private String userAdress;

    private Integer userZipcode;

    private Date updateTime;

    public Long getOrderShipmentId() {
        return orderShipmentId;
    }

    public void setOrderShipmentId(Long orderShipmentId) {
        this.orderShipmentId = orderShipmentId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserAdress() {
        return userAdress;
    }

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress == null ? null : userAdress.trim();
    }

    public Integer getUserZipcode() {
        return userZipcode;
    }

    public void setUserZipcode(Integer userZipcode) {
        this.userZipcode = userZipcode;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}