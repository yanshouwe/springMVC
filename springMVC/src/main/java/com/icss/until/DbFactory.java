package com.icss.until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbFactory {
    public static Connection openConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/schoolshop?serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=UTF-8";
        Connection conn =DriverManager.getConnection(url,"root","123456");
        if(conn!=null){
            System.out.println("打开一个数据库新连接.......");
        }
        return conn;

    }
    public static void closeConnection(Connection conn) {
        if (conn!=null){
            try {
                System.out.println("关闭数据库连接.......");
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
