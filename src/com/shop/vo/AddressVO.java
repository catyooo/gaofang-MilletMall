package com.shop.vo;

import java.util.Date;

/**
 * @Author 康健
 * @Date 2017/8/13 15:02
 */
public class AddressVO {
    private Long addressId;

    private String userName;

    private String userTag;

    private String userPhone;

    private String userAdress;

    private Integer userZipcode;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTag() {
        return userTag;
    }

    public void setUserTag(String userTag) {
        this.userTag = userTag;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAdress() {
        return userAdress;
    }

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
    }

    public Integer getUserZipcode() {
        return userZipcode;
    }

    public void setUserZipcode(Integer userZipcode) {
        this.userZipcode = userZipcode;
    }
}
