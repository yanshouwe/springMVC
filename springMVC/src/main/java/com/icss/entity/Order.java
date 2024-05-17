package com.icss.entity;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    int oid;
    String  state;
    String odate;
    String userId;
    int dishId;
    float tprice;
    List<Dish> dishs;
    User user;
    int num;
    Dish dish;

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Order() {
        dishs = new ArrayList<Dish>();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", state=" + state +
                ", odate='" + odate + '\'' +
                ", userId=" + userId +
                ", dishId=" + dishId +
                ", tprice=" + tprice +
                ", dish=" + dish +
                ", user=" + user +
                ", num=" + num +
                '}';
    }

    public List<Dish> getDish() {
        return dishs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOdate() {
        return odate;
    }

    public void setOdate(String odate) {
        this.odate = odate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public float getTprice() {
        return tprice;
    }

    public void setTprice(float tprice) {
        this.tprice = tprice;
    }
}
