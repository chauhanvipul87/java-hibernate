package com.iana.application.entities.student_entities;

import javax.persistence.*;

@Embeddable
public class StudentAddress {

    @Column(name ="STREET_NAME")
    private String streetName;


    @Column(name ="CITY")
    private String city;

    @Column(name ="STATE")
    private String state;

    @Column(name ="ZIP_CODE")
    private String zipCode;

    public StudentAddress(){

    }

    public StudentAddress(String streetName, String city, String state, String zipCode) {
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "StudentAddress{" +
                "streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
