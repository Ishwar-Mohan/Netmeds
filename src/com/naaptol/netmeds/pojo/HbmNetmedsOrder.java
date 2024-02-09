package com.naaptol.netmeds.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class HbmNetmedsOrder implements Serializable {

    /** identifier field */
    private Long orderId;

    /** persistent field */
    private Date ordersDate;

    /** persistent field */
    private BigDecimal totalCost;

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
    private com.naaptol.netmeds.pojo.HbmNetmedsCustomer hbmNetmedsCustomerByCustomerId;

    /** persistent field */
    private Set hbmNetmedsAddToCartsByOrderId;;

    /** persistent field */
    private Set hbmNetmedsOrdersDetailsByOrderId;

    /** full constructor */
    public HbmNetmedsOrder(Date ordersDate, BigDecimal totalCost, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, String isActive, com.naaptol.netmeds.pojo.HbmNetmedsCustomer hbmNetmedsCustomerByCustomer, Set hbmNetmedsAddToCartsByOrderId, Set hbmNetmedsOrdersDetailsByOrderId, HbmNetmedsCustomer hbmNetmedsCustomerByCustomerId) {
        this.ordersDate = ordersDate;
        this.totalCost = totalCost;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.isActive = isActive;
        this.hbmNetmedsCustomerByCustomerId = hbmNetmedsCustomerByCustomerId;
        this.hbmNetmedsAddToCartsByOrderId = hbmNetmedsAddToCartsByOrderId;
        this.hbmNetmedsOrdersDetailsByOrderId = hbmNetmedsOrdersDetailsByOrderId;
    }

    /** default constructor */
    public HbmNetmedsOrder() {
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrdersDate() {
        return this.ordersDate;
    }

    public void setOrdersDate(Date date) {
        this.ordersDate = date;
    }

    public BigDecimal getTotalCost() {
        return this.totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
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

    public com.naaptol.netmeds.pojo.HbmNetmedsCustomer getHbmNetmedsCustomerByCustomerId() {
        return this.hbmNetmedsCustomerByCustomerId;
    }

    public void setHbmNetmedsCustomerByCustomerId(com.naaptol.netmeds.pojo.HbmNetmedsCustomer hbmNetmedsCustomerByCustomerId) {
        this.hbmNetmedsCustomerByCustomerId = hbmNetmedsCustomerByCustomerId;
    }

    public Set getHbmNetmedsAddToCartsByOrderId() {
        return this.hbmNetmedsAddToCartsByOrderId;
    }

    public void setHbmNetmedsAddToCartsByOrderId(Set hbmNetmedsAddToCartsByOrderId) {
        this.hbmNetmedsAddToCartsByOrderId = hbmNetmedsAddToCartsByOrderId;
    }

    public Set getHbmNetmedsOrdersDetailsByOrderId() {
        return this.hbmNetmedsOrdersDetailsByOrderId;
    }

    public void setHbmNetmedsOrdersDetailsByOrderId(Set hbmNetmedsOrdersDetailsByOrderId) {
        this.hbmNetmedsOrdersDetailsByOrderId = hbmNetmedsOrdersDetailsByOrderId;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("orderId", getOrderId())
            .toString();
    }

}
