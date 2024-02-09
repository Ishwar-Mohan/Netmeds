package com.naaptol.netmeds.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class HbmNetmedsOrdersDetail implements Serializable {

    /** identifier field */
    private Long orderDetailsId;

    /** nullable persistent field */
    private Long quantity;

    /** persistent field */
    private BigDecimal price;

    /** nullable persistent field */
    private String shippingAddress;

    /** nullable persistent field */
    private String paymentType;

    /** persistent field */
    private String createdBy;

    /** nullable persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private String modifiedBy;

    /** nullable persistent field */
    private Date modifiedDate;

    /** nullable persistent field */
    private String isActive;

    /** persistent field */
    private com.naaptol.netmeds.pojo.HbmNetmedsOrder hbmNetmedsOrderByOrderId;

    /** persistent field */
    private com.naaptol.netmeds.pojo.HbmNetmedsProduct hbmNetmedsProductByProductId;

    /** full constructor */
    public HbmNetmedsOrdersDetail(Long quantity, BigDecimal price, String shippingAddress, String paymentType, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, String isActive, com.naaptol.netmeds.pojo.HbmNetmedsOrder hbmNetmedsOrderByOrderId, com.naaptol.netmeds.pojo.HbmNetmedsProduct hbmNetmedsProductByProductId) {
        this.quantity = quantity;
        this.price = price;
        this.shippingAddress = shippingAddress;
        this.paymentType = paymentType;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.isActive = isActive;
        this.hbmNetmedsOrderByOrderId = hbmNetmedsOrderByOrderId;
        this.hbmNetmedsProductByProductId = hbmNetmedsProductByProductId;
    }

    /** default constructor */
    public HbmNetmedsOrdersDetail() {
    }

    public Long getOrderDetailsId() {
        return this.orderDetailsId;
    }

    public void setOrderDetailsId(Long orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getShippingAddress() {
        return this.shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getIsActive() {
        return this.isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public com.naaptol.netmeds.pojo.HbmNetmedsOrder getHbmNetmedsOrderByOrderId() {
        return this.hbmNetmedsOrderByOrderId;
    }

    public void setHbmNetmedsOrderByOrderId(com.naaptol.netmeds.pojo.HbmNetmedsOrder hbmNetmedsOrderByOrderId) {
        this.hbmNetmedsOrderByOrderId = hbmNetmedsOrderByOrderId;
    }

    public com.naaptol.netmeds.pojo.HbmNetmedsProduct getHbmNetmedsProductByProductId() {
        return this.hbmNetmedsProductByProductId;
    }

    public void setHbmNetmedsProductByProductId(com.naaptol.netmeds.pojo.HbmNetmedsProduct hbmNetmedsProductByProductId) {
        this.hbmNetmedsProductByProductId = hbmNetmedsProductByProductId;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("orderDetailsId", getOrderDetailsId())
            .toString();
    }

}
