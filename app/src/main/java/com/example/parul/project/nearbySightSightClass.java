package com.example.parul.project;

public class nearbySightSightClass {

    private String name, phone, address, hours;
    private int sight_img;

    public nearbySightSightClass(String name,String phone, String address, String hours,
                 int sight_img) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.hours = hours;
        this.sight_img = sight_img;
    }

    public String getName() {
        return name;
    }

    public String getPhone() { return phone; }

    public String getAddress() {
        return address;
    }

    public String getHours() { return hours; }

    public int getSight_img() { return sight_img; }

}
