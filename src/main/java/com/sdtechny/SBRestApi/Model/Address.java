
package com.sdtechny.SBRestApi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Address {
    @Id
    private int addid;
    private String street;
    private String city;
    private String addresstype;

    public Address() {
    }

    public int getAddid() {
        return addid;
    }

    public void setAddid(int addid) {
        this.addid = addid;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddresstype() {
        return addresstype;
    }

    public void setAddresstype(String addresstype) {
        this.addresstype = addresstype;
    }
    
    
    
    
}
