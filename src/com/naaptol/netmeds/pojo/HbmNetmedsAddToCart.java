package com.naaptol.netmeds.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class HbmNetmedsAddToCart implements Serializable {

    /** identifier field */
    private Long cartItemsId;

    /** nullable persistent field */
    private Long specificItemQuantity;

    /** nullable persistent field */
    private BigDecimal specificItemPrice;

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
    private com.naaptol.netmeds.pojo.HbmNetmedsCustomer hbmNetmedsCustomerByCustomerId;

    /** persistent field */
    private com.naaptol.netmeds.pojo.HbmNetmedsProduct hbmNetmedsProductByProductId;

    /** full constructor */
    public HbmNetmedsAddToCart(Long specificItemQuantity, BigDecimal specificItemPrice, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, String isActive, com.naaptol.netmeds.pojo.HbmNetmedsOrder hbmNetmedsOrderByOrderId, com.naaptol.netmeds.pojo.HbmNetmedsCustomer hbmNetmedsCustomerByCustomerId, HbmNetmedsProduct hbmNetmedsProductByProductId) {
        this.specificItemQuantity = specificItemQuantity;
        this.specificItemPrice = specificItemPrice;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.isActive = isActive;
        this.hbmNetmedsOrderByOrderId = hbmNetmedsOrderByOrderId;
        this.hbmNetmedsCustomerByCustomerId = hbmNetmedsCustomerByCustomerId;
        this.hbmNetmedsProductByProductId = hbmNetmedsProductByProductId;
    }

    /** default constructor */
    public HbmNetmedsAddToCart() {
    }

    public Long getCartItemsId() {
        return this.cartItemsId;
    }

    public void setCartItemsId(Long cartItemsId) {
        this.cartItemsId = cartItemsId;
    }

    public Long getSpecificItemQuantity() {
        return this.specificItemQuantity;
    }

    public void setSpecificItemQuantity(Long specificItemQuantity) {
        this.specificItemQuantity = specificItemQuantity;
    }

    public BigDecimal getSpecificItemPrice() {
        return this.specificItemPrice;
    }

    public void setSpecificItemPrice(BigDecimal specificItemPrice) {
        this.specificItemPrice = specificItemPrice;
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

    public com.naaptol.netmeds.pojo.HbmNetmedsCustomer getHbmNetmedsCustomerByCustomerId() {
        return this.hbmNetmedsCustomerByCustomerId;
    }

    public void setHbmNetmedsCustomerByCustomerId(com.naaptol.netmeds.pojo.HbmNetmedsCustomer hbmNetmedsCustomerByCustomerId) {
        this.hbmNetmedsCustomerByCustomerId = hbmNetmedsCustomerByCustomerId;
    }
    
    public com.naaptol.netmeds.pojo.HbmNetmedsProduct getHbmNetmedsProductByProductId() {
        return this.hbmNetmedsProductByProductId;
    }

    public void setHbmNetmedsProductByProductId(com.naaptol.netmeds.pojo.HbmNetmedsProduct hbmNetmedsProductByProductId) {
        this.hbmNetmedsProductByProductId = hbmNetmedsProductByProductId;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cartItemsId", getCartItemsId())
            .toString();
    }

}
