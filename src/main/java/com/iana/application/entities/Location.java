package com.iana.application.entities;

import javax.persistence.*;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location_id")
    private Long locationId;

    @Column(name ="IANA_CODE")
    private Long ianaCode;

    @Column(name ="SPLC_CODE")
    private String splcCode;

    public Location() {
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getIanaCode() {
        return ianaCode;
    }

    public void setIanaCode(Long ianaCode) {
        this.ianaCode = ianaCode;
    }

    public String getSplcCode() {
        return splcCode;
    }

    public void setSplcCode(String splcCode) {
        this.splcCode = splcCode;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", ianaCode=" + ianaCode +
                ", splcCode='" + splcCode + '\'' +
                '}';
    }
}
