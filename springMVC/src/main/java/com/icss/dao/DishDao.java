package com.icss.dao;

import com.icss.entity.Dish;
import com.icss.entity.User;
import com.icss.until.DbFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DishDao {
    public int insert(Dish dish) throws Exception {
        String sql = "insert into dish(id,dname,price,pic,details) values (?,?,?,?,?)";
        Connection conn = DbFactory.openConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, dish.getId());
        ps.setString(2, dish.getDname());
        ps.setFloat(3, dish.getPrice());
        ps.setString(4, dish.getPic());
        ps.setString(5, dish.getDetails());
        ps.execute();
        DbFactory.closeConnection(conn);
        return 1;
    }

    public Dish selectById(int id) throws Exception {
        Dish dish = null;
        String sql = "select * from dish where id=?";
        Connection conn = DbFactory.openConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            dish = new Dish();
            dish.setId(id);
            dish.setDname(rs.getString("dname"));
            dish.setPrice(rs.getFloat("price"));
            dish.setPic(rs.getString("pic"));
            dish.setDetails(rs.getString("details"));
        }
        DbFactory.closeConnection(conn);
        return dish;
    }

    public int deletById(int id) throws Exception {
        String sql = "delete from dish where id=?";
        Connection conn = DbFactory.openConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        DbFactory.closeConnection(conn);
        return 1;
    }

    public int update(Dish dish) throws Exception {
        String sql = "update dish set dname=?,price=?,pic=?,details=? where id=?";
        Connection conn = DbFactory.openConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, dish.getDname());
        ps.setFloat(2, dish.getPrice());
        ps.setString(3, dish.getPic());
        ps.setString(4, dish.getDetails());
        ps.setInt(5,dish.getId());
        ps.execute();
        DbFactory.closeConnection(conn);
        return 1;
    }

    public List<Dish> select() throws Exception {
        String sql = "select * from dish";
        List<Dish> list = new ArrayList<>();
        Connection conn = DbFactory.openConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Dish dish = new Dish();
            dish.setId(rs.getInt("id"));
            dish.setDname(rs.getString("dname"));
            dish.setPrice(rs.getFloat("price"));
            dish.setPic(rs.getString("pic"));
            dish.setDetails(rs.getString("details"));
            list.add(dish);
        }
        DbFactory.closeConnection(conn);
        return list;
    }
    public Dish selectByName(String dname) throws Exception {
        String sql = "select * from dish where dname=?";
        Dish dish = new Dish();
        Connection conn = DbFactory.openConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,dname);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            dish.setId(rs.getInt("id"));
            dish.setDname(rs.getString("dname"));
            dish.setPrice(rs.getFloat("price"));
            dish.setPic(rs.getString("pic"));
            dish.setDetails(rs.getString("details"));
        }
        DbFactory.closeConnection(conn);
        return dish;
    }
}
