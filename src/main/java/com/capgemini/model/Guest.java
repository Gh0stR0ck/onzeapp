package com.capgemini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long guestNumber;
    private String name;
    private String surName;
    private String address;
    private String zipcode;
    private String city;
    private String country;
    private String phone;
    private String email;

    public Guest(){}

    public Guest(long guestNumber, String name, String surName, String address, String zipcode, String city, String country, String phone, String email){
        this.guestNumber = guestNumber;
        this.name = name;
        this.surName = surName;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.email = email;
    }

    public long getGuestNumber() {
        return guestNumber;
    }

    public void setGuestNumber(long guestNumber) {
        this.guestNumber = guestNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
