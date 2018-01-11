package com.shop.vo;

import com.shop.po.OsOrderProduct;
import com.shop.po.OsOrderShipment;
import com.shop.po.OsOrderStatus;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author 康健
 * @Date 2017/8/13 8:32
 */
public class OrderVO {

    private Long orderId;

    private Long orderNumber;

    private Long userId;

    private Byte payType;

    private Byte shipmentTime;

    private Byte shipmentType;

    private BigDecimal shipmentAmount;

    private Byte invoiceType;

    private String invoiceTitle;

    private Byte orderStatus;

    private Date createTime;

    private Date updateTime;

    private BigDecimal orderAmount;

    private Integer orderScore;

    private BigDecimal payAmount;

    private Integer buyNumber;

    private OsOrderShipment osOrderShipment;

    private ArrayList<OsOrderProduct> orderProducts;

    private ArrayList<OsOrderStatus> orderStatusList;//按最近时间排序

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public Byte getShipmentTime() {
        return shipmentTime;
    }

    public void setShipmentTime(Byte shipmentTime) {
        this.shipmentTime = shipmentTime;
    }

    public Byte getShipmentType() {
        return shipmentType;
    }

    public void setShipmentType(Byte shipmentType) {
        this.shipmentType = shipmentType;
    }

    public BigDecimal getShipmentAmount() {
        return shipmentAmount;
    }

    public void setShipmentAmount(BigDecimal shipmentAmount) {
        this.shipmentAmount = shipmentAmount;
    }

    public Byte getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Byte invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
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

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getOrderScore() {
        return orderScore;
    }

    public void setOrderScore(Integer orderScore) {
        this.orderScore = orderScore;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }

    public ArrayList<OsOrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(ArrayList<OsOrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public ArrayList<OsOrderStatus> getOrderStatusList() {
        return orderStatusList;
    }

    public void setOrderStatusList(ArrayList<OsOrderStatus> orderStatusList) {
        this.orderStatusList = orderStatusList;
    }

    public OsOrderShipment getOsOrderShipment() {
        return osOrderShipment;
    }

    public void setOsOrderShipment(OsOrderShipment osOrderShipment) {
        this.osOrderShipment = osOrderShipment;
    }
}
