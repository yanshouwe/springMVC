package com.icss.entity;

public class Dish {
    int id;
    String dname;
    float price;
    String pic;
    String details;
    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", dname='" + dname + '\'' +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                ", details='" + details + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
