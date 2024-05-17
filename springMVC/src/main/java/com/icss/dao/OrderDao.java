package com.icss.dao;

import com.icss.entity.Dish;
import com.icss.entity.Order;
import com.icss.until.DbFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    public int addOrder(Order order) throws Exception{
        String sql = "insert into orders(state,odate,userid,dishid,tprice,num) values ('未完成',?,?,?,?,?)";
        Connection conn = DbFactory.openConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,order.getOdate());
        ps.setString(2,order.getUserId());
        ps.setInt(3,order.getDishId());
        ps.setFloat(4,order.getTprice());
        ps.setInt(5,order.getNum());
        ps.execute();
        DbFactory.closeConnection(conn);
        return 1;
    }
    public List<Order> selectOrder(String uname) throws Exception{
        List<Order> list = new ArrayList<>();
        Order order = null;
        String sql = "select * from orders where userid=?";
        Connection conn = DbFactory.openConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,uname);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            order = new Order();
            order.setOid(rs.getInt("oid"));
            order.setOdate(rs.getString("odate"));
            order.setState(rs.getString("state"));
            order.setDishId(rs.getInt("dishid"));
            order.setTprice(rs.getFloat("tprice"));
            order.setNum(rs.getInt("num"));
            order.setUserId(uname);
            list.add(order);
        }
        DbFactory.closeConnection(conn);
        return list;
    }
    public int update(int id) throws Exception {
        String sql = "update orders set state='已完成' where oid=?";
        Connection conn = DbFactory.openConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        DbFactory.closeConnection(conn);
        return 1;
    }

}
