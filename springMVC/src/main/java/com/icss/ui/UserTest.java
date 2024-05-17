package com.icss.ui;

import com.icss.biz.UserBiz;
import com.icss.entity.User;

public class UserTest {
    public static void main(String[] args) {
        registerTest();
    }
    public static void loginTest(){
        UserBiz biz= new UserBiz();
        try {
            User user=biz.login("tom","123456");
            if(user!=null){
                System.out.println("登陆失败，请重试！");
            }
            else {
                System.out.println(user.getUname()+"登陆成功！");
                System.out.println(user.getUname()+"身份是:"+user.getRole());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void registerTest(){
        UserBiz biz= new UserBiz();
        User user = new User();
        user.setUname("55555");
        user.setTel("15654897987");
        user.setPwd("1568");
        user.setRole(5);
        try {
            int register = biz.register(user);
            if(register!=0){
                System.out.println("11111");
            }
            else {
                System.out.println(222);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
