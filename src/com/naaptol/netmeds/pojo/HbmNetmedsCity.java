package com.naaptol.netmeds.pojo;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class HbmNetmedsCity implements Serializable {

    /** identifier field */
    private Long cityId;

    /** nullable persistent field */
    private String cityName;

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
    private com.naaptol.netmeds.pojo.HbmNetmedsState hbmNetmedsState;

    /** full constructor */
    public HbmNetmedsCity(String cityName, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, String isActive, com.naaptol.netmeds.pojo.HbmNetmedsState hbmNetmedsState) {
        this.cityName = cityName;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.isActive = isActive;
        this.hbmNetmedsState = hbmNetmedsState;
    }

    /** default constructor */
    public HbmNetmedsCity() {
    }

    public Long getCityId() {
        return this.cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    public com.naaptol.netmeds.pojo.HbmNetmedsState getHbmNetmedsState() {
        return this.hbmNetmedsState;
    }

    public void setHbmNetmedsState(com.naaptol.netmeds.pojo.HbmNetmedsState hbmNetmedsState) {
        this.hbmNetmedsState = hbmNetmedsState;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityId", getCityId())
            .toString();
    }

}
