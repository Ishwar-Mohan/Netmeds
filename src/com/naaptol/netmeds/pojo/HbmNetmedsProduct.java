package com.naaptol.netmeds.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class HbmNetmedsProduct implements Serializable 
{
    /** identifier field */
    private Long productId;

    /** nullable persistent field */
    private String productName;

    /** nullable persistent field */
    private String description;

    /** nullable persistent field */
    private String manufacturer;

    /** nullable persistent field */
    private String productImages;

    /** nullable persistent field */
    private BigDecimal mrp;

    /** nullable persistent field */
    private BigDecimal price;

    /** persistent field */
    private Integer stock;

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
    private com.naaptol.netmeds.pojo.HbmNetmedsCategory hbmNetmedsCategoryByCategoryId;

    /** persistent field */
    private Set hbmNetmedsAddToCartsByProductId;

    /** persistent field */
    private Set hbmNetmedsOrdersDetailsByProductId;

    /** full constructor */
    public HbmNetmedsProduct(String productName, String description, String manufacturer, String productImages, BigDecimal mrp, BigDecimal price, Integer stock, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, String isActive, com.naaptol.netmeds.pojo.HbmNetmedsCategory hbmNetmedsCategoryByCategoryId, Set hbmNetmedsAddToCartsByProductId, Set hbmNetmedsOrdersDetailsByProductId) 
    {
        this.productName = productName;
        this.description = description;
        this.manufacturer = manufacturer;
        this.productImages = productImages;
        this.mrp = mrp;
        this.price = price;
        this.stock = stock;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.isActive = isActive;
        this.hbmNetmedsCategoryByCategoryId = hbmNetmedsCategoryByCategoryId;
        this.hbmNetmedsAddToCartsByProductId = hbmNetmedsAddToCartsByProductId;
        this.hbmNetmedsOrdersDetailsByProductId = hbmNetmedsOrdersDetailsByProductId;
    }

    /** default constructor */
    public HbmNetmedsProduct() {}

    public Long getProductId() 
    {
        return this.productId;
    }

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public String getProductName() 
    {
        return this.productName;
    }

    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getDescription() 
    {
        return this.description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getManufacturer() 
    {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) 
    {
        this.manufacturer = manufacturer;
    }

    public String getProductImages() 
    {
        return this.productImages;
    }

    public void setProductImages(String productImages)
    {
        this.productImages = productImages;
    }

    public BigDecimal getMrp() 
    {
        return this.mrp;
    }

    public void setMrp(BigDecimal mrp) 
    {
        this.mrp = mrp;
    }

    public BigDecimal getPrice()
    {
        return this.price;
    }

    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public Integer getStock()
    {
        return this.stock;
    }

    public void setStock(Integer stock) 
    {
        this.stock = stock;
    }

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) 
    {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate()
    {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) 
    {
        this.createdDate = createdDate;
    }

    public String getModifiedBy()
    {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) 
    {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() 
    {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) 
    {
        this.modifiedDate = modifiedDate;
    }

    public String getIsActive() 
    {
        return this.isActive;
    }

    public void setIsActive(String isActive) 
    {
        this.isActive = isActive;
    }

    public com.naaptol.netmeds.pojo.HbmNetmedsCategory getHbmNetmedsCategoryByCategoryId()
    {
        return this.hbmNetmedsCategoryByCategoryId;
    }

    public void setHbmNetmedsCategoryByCategoryId(com.naaptol.netmeds.pojo.HbmNetmedsCategory hbmNetmedsCategoryByCategoryId)
    {
        this.hbmNetmedsCategoryByCategoryId = hbmNetmedsCategoryByCategoryId;
    }

    public Set getHbmNetmedsAddToCartsByProductId()
    {
        return this.hbmNetmedsAddToCartsByProductId;
    }

    public void setHbmNetmedsAddToCartsByProductId(Set hbmNetmedsAddToCartsByProductId) 
    {
        this.hbmNetmedsAddToCartsByProductId = hbmNetmedsAddToCartsByProductId;
    }

    public Set getHbmNetmedsOrdersDetailsByProductId()
    {
        return this.hbmNetmedsOrdersDetailsByProductId;
    }

    public void setHbmNetmedsOrdersDetailsByProductId(Set hbmNetmedsOrdersDetailsByProductId)
    {
        this.hbmNetmedsOrdersDetailsByProductId = hbmNetmedsOrdersDetailsByProductId;
    }

    public String toString() 
    {
        return new ToStringBuilder(this)
            .append("productId", getProductId())
            .toString();
    }
}
