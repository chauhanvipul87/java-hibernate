package com.iana.application.entities;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name ="user_type")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_TYPE_ID")
    private Long userTypeId;

    @Column(name = "USER_TYPE_NAME")
    private String userTypeName;


    @Column(name = "CREATED_DATE_NORMAL")
    private Date createdDateNormal;

    @Column(name = "CREATED_DATE", columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name = "CREATED_TIME", columnDefinition = "TIME")
    @Temporal(TemporalType.TIME)
    private Date createdTime;


    @Column(name = "MODIFIED_DATETIME" ,columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDateTime;

    @Column(name = "MODIFIED_DATE_WITHOUT_TIME" ,columnDefinition="DATETIME")
    @Temporal(TemporalType.DATE)
    private Date modifiedDateWithoutTime;

    @Column(name = "IS_DELETED")
    private boolean deleted;

    @Column(name = "IS_ACTIVE")
    private Character active;


    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDateTime() {
        return modifiedDateTime;
    }

    public void setModifiedDateTime(Date modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }

    public Date getCreatedDateNormal() {
        return createdDateNormal;
    }

    public void setCreatedDateNormal(Date createdDateNormal) {
        this.createdDateNormal = createdDateNormal;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedDateWithoutTime() {
        return modifiedDateWithoutTime;
    }

    public void setModifiedDateWithoutTime(Date modifiedDateWithoutTime) {
        this.modifiedDateWithoutTime = modifiedDateWithoutTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "userTypeId=" + userTypeId +
                ", userTypeName='" + userTypeName + '\'' +
                ", createdDateNormal=" + createdDateNormal +
                ", createdDate=" + createdDate +
                ", createdTime=" + createdTime +
                ", modifiedDateTime=" + modifiedDateTime +
                ", modifiedDateWithoutTime=" + modifiedDateWithoutTime +
                ", deleted=" + deleted +
                ", active=" + active +
                '}';
    }
}
