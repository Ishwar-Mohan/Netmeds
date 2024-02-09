package com.naaptol.netmeds.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class HbmNetmedsState implements Serializable {

    /** identifier field */
    private Long stateId;

    /** nullable persistent field */
    private String stateName;

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
    private Set hbmNetmedsCities;

    /** full constructor */
    public HbmNetmedsState(String stateName, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, String isActive, Set hbmNetmedsCities) {
        this.stateName = stateName;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.isActive = isActive;
        this.hbmNetmedsCities = hbmNetmedsCities;
    }

    /** default constructor */
    public HbmNetmedsState() {
    }

    /** minimal constructor */
    public HbmNetmedsState(String createdBy, Set hbmNetmedsCities) {
        this.createdBy = createdBy;
        this.hbmNetmedsCities = hbmNetmedsCities;
    }

    public Long getStateId() {
        return this.stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return this.stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
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

    public Set getHbmNetmedsCities() {
        return this.hbmNetmedsCities;
    }

    public void setHbmNetmedsCities(Set hbmNetmedsCities) {
        this.hbmNetmedsCities = hbmNetmedsCities;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("stateId", getStateId())
            .toString();
    }

}
