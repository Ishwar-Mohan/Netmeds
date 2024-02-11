package com.naaptol.netmeds.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class HbmNetmedsCategory implements Serializable 
{
    /** identifier field */
    private Long categoryId;

    /** nullable persistent field */
    private String categoryName;

    /** nullable persistent field */
    private Long fkCategoryId;

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
    private Set hbmNetmedsProductsByCategoryId;

    /** full constructor */
    public HbmNetmedsCategory(String categoryName, Long fkCategoryId, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, String isActive, Set hbmNetmedsProductsByCategoryId) 
    {
        this.categoryName = categoryName;
        this.fkCategoryId = fkCategoryId;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.isActive = isActive;
        this.hbmNetmedsProductsByCategoryId = hbmNetmedsProductsByCategoryId;
    }

    /** default constructor */
    public HbmNetmedsCategory() {}

    public Long getCategoryId() 
    {
        return this.categoryId;
    }

    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public String getCategoryName()
    {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) 
    {
        this.categoryName = categoryName;
    }

    public Long getFkCategoryId() 
    {
        return this.fkCategoryId;
    }

    public void setFkCategoryId(Long fkCategoryId)
    {
        this.fkCategoryId = fkCategoryId;
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

    public Set getHbmNetmedsProductsByCategoryId()
    {
        return this.hbmNetmedsProductsByCategoryId;
    }

    public void setHbmNetmedsProductsByCategoryId(Set hbmNetmedsProductsByCategoryId) 
    {
        this.hbmNetmedsProductsByCategoryId = hbmNetmedsProductsByCategoryId;
    }

    public String toString() 
    {
        return new ToStringBuilder(this)
            .append("categoryId", getCategoryId())
            .toString();
    }
}
