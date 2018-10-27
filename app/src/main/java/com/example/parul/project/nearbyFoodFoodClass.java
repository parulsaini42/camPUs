package com.example.parul.project;

public class nearbyFoodFoodClass {

    private String name, address, phone, hours, web;
    private int display_pic;

    public nearbyFoodFoodClass(String name, String address, String phone, String hours, String web,
                int display_pic) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.hours = hours;
        this.web = web;
        this.display_pic = display_pic;
    }

    public String getName() {
        return name;
    }

    public String getAddress() { return address; }

    public String getPhone() {
        return phone;
    }

    public String getHours() {
        return hours;
    }

    public String getOrder() { return web; }

    public int getDisplay_pic() { return display_pic; }

}
