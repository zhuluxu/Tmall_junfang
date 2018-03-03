package com.xq.tmall.entity;

public class Address {
    private String address_areaId;
    private String address_name;
    private Address address_regionId;

    public Address() {
    }

    public Address(String address_areaId, String address_name, Address address_regionId) {
        this.address_areaId = address_areaId;
        this.address_name = address_name;
        this.address_regionId = address_regionId;
    }

    public String getAddress_areaId() {
        return address_areaId;
    }

    public void setAddress_areaId(String address_areaId) {
        this.address_areaId = address_areaId;
    }

    public String getAddress_name() {
        return address_name;
    }

    public void setAddress_name(String address_name) {
        this.address_name = address_name;
    }

    public Address getAddress_regionId() {
        return address_regionId;
    }

    public void setAddress_regionId(Address address_regionId) {
        this.address_regionId = address_regionId;
    }
}