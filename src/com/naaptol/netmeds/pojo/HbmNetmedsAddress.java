package com.naaptol.netmeds.pojo;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class HbmNetmedsAddress implements Serializable
{
    /** identifier field */
    private Long addressId;

    /** nullable persistent field */
    private String address;

    /** nullable persistent field */
    private String city;

    /** nullable persistent field */
    private String state;

    /** nullable persistent field */
    private String pincode;

    /** nullable persistent field */
    private String landmark;
    
    /** nullable persistent field */
    private HbmNetmedsCustomer customer;

    /** nullable persistent field */
    private String createdBy;

    /** nullable persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private String modifiedBy;

    /** nullable persistent field */
    private Date modifiedDate;

    /** nullable persistent field */
    private String isActive;

    /** full constructor */
    public HbmNetmedsAddress(String address, String city, String state, String pincode, String landmark, HbmNetmedsCustomer customer, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, String isActive)
    {
        this.address = address;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.landmark = landmark;
        this.customer = customer;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.isActive = isActive;
    }

    /** default constructor */
    public HbmNetmedsAddress() {}

    public Long getAddressId() 
    {
        return this.addressId;
    }

    public void setAddressId(Long addressId) 
    {
        this.addressId = addressId;
    }

    public String getAddress() 
    {
        return this.address;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getCity() 
    {
        return this.city;
    }

    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getState() 
    {
        return this.state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getPincode() 
    {
        return this.pincode;
    }

    public void setPincode(String pincode)
    {
        this.pincode = pincode;
    }

    public String getLandmark() 
    {
        return this.landmark;
    }

    public void setLandmark(String landmark) 
    {
        this.landmark = landmark;
    }
    
    public HbmNetmedsCustomer getCustomer() 
    {
        return customer;
    }

    public void setCustomer(HbmNetmedsCustomer customer) 
    {
        this.customer = customer;
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

    public Date getModifiedDate() {
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

    public String toString() 
    {
        return new ToStringBuilder(this)
            .append("addressId", getAddressId())
            .toString();
    }
}
