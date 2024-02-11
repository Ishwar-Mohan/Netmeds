package com.naaptol.netmeds.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class HbmNetmedsCustomer implements Serializable 
{
    /** identifier field */
    private Long customerId;

    /** nullable persistent field */
    private String firstName;

    /** nullable persistent field */
    private String lastName;

    /** nullable persistent field */
    private String email;

    /** nullable persistent field */
    private String mobileNumber;

    /** nullable persistent field */
    private String password;
    
    /** nullable persistent field */
    private HbmNetmedsAddress address;

    /** persistent field */
    private String isAdmin;

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
    private Set hbmNetmedsOrdersByCustomerId;

    /** persistent field */
    private Set hbmNetmedsAddToCartsByCustomerId;

    /** full constructor */
    public HbmNetmedsCustomer(String firstName, String lastName, String email, String mobileNumber, String password, HbmNetmedsAddress address, String isAdmin, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, String isActive, Set hbmNetmedsOrdersByCustomerId, Set hbmNetmedsAddToCartsByCustomerId)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.address = address;
        this.isAdmin = isAdmin;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.isActive = isActive;
        this.hbmNetmedsOrdersByCustomerId = hbmNetmedsOrdersByCustomerId;
        this.hbmNetmedsAddToCartsByCustomerId = hbmNetmedsAddToCartsByCustomerId;
    }

    /** default constructor */
    public HbmNetmedsCustomer() {}

    public Long getCustomerId()
    {
        return this.customerId;
    }

    public void setCustomerId(Long customerId) 
    {
        this.customerId = customerId;
    }

    public String getFirstName() 
    {
        return this.firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail() 
    {
        return this.email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getMobileNumber() 
    {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }
    
    public HbmNetmedsAddress getAddress() 
    {
        return address;
    }

    public void setAddress(HbmNetmedsAddress address) 
    {
        this.address = address;
    }

    public String getIsAdmin() 
    {
        return this.isAdmin;
    }

    public void setIsAdmin(String isAdmin)
    {
        this.isAdmin = isAdmin;
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

    public Set getHbmNetmedsOrdersByCustomerId()
    {
        return this.hbmNetmedsOrdersByCustomerId;
    }

    public void setHbmNetmedsOrdersByCustomerId(Set hbmNetmedsOrdersByCustomerId) 
    {
        this.hbmNetmedsOrdersByCustomerId = hbmNetmedsOrdersByCustomerId;
    }

    public Set getHbmNetmedsAddToCartsByCustomerId() 
    {
        return this.hbmNetmedsAddToCartsByCustomerId;
    }

    public void setHbmNetmedsAddToCartsByCustomerId(Set hbmNetmedsAddToCartsByCustomerId) 
    {
        this.hbmNetmedsAddToCartsByCustomerId = hbmNetmedsAddToCartsByCustomerId;
    }

    public String toString() 
    {
        return new ToStringBuilder(this)
            .append("customerId", getCustomerId())
            .toString();
    }
}
