package com.example.android.e;

public class Restaurant {
    private long Id = 0;
    private String name = "";
    private String address = "";

    public String getName() {
        return (name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return (address);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String type = "";

    public String getType() {
        return (type);
    }

    public long getId() {
        return this.Id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(long Id) {
        this.Id = Id;
    }


}