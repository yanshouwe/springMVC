package com.icss.dao;

import com.icss.entity.User;
import com.icss.until.DbFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    /**
     * 用户登录
     *
     * @param uname
     * @param pwd
     * @return
     * @throws Exception
     */
    public User login(String uname, String pwd) throws Exception {
        User user = null;
        String sql = "select * from user where uname=? and pwd=?";
        Connection conn = DbFactory.openConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, uname);
        ps.setString(2, pwd);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            user = new User();
            user.setUname(uname);
            user.setPwd(pwd);
            user.setRole(rs.getInt("role"));
            user.setTel(rs.getString("tel"));
        }
        DbFactory.closeConnection(conn);
        return user;
    }

    public User select(String uname) throws Exception {
        User user = null;
        String sql = "select * from user where uname=?";
        Connection conn = DbFactory.openConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, uname);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            user = new User();
            user.setUname(uname);
            user.setPwd(rs.getString("pwd"));
            user.setRole(rs.getInt("role"));
            user.setTel(rs.getString("tel"));
        }
        DbFactory.closeConnection(conn);
        return user;
    }

    public int register(User user) throws Exception {
        String sql = "insert into user(uname,pwd,role,tel) values (?,?,?,?)";
        Connection conn = DbFactory.openConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getUname());
        ps.setString(2, user.getPwd());
        ps.setInt(3, user.getRole());
        ps.setString(4, user.getTel());
        ps.execute();
        DbFactory.closeConnection(conn);
        return 1;
    }
}
