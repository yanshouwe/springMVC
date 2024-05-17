package com.icss.biz;

import com.icss.dao.UserDao;
import com.icss.entity.User;

public class UserBiz {
    /**
     * 用户的公路
     *
     * @param uname
     * @param pwd
     * @return
     * @throws Exception
     */
    public User login(String uname, String pwd) throws Exception {
        //1.入参校验
        if (uname == null || uname.equals("")) {
            throw new RuntimeException("用户名不能为空");
        }
        if (pwd == null || pwd.equals("")) {
            throw new RuntimeException("密码不能为空");
        }
        //2.按照业务流程实现业务逻辑
        UserDao dao = new UserDao();
        User user = dao.login(uname, pwd);
        //3.保证事务完整性
        return user;
    }

    public int register(User user) throws Exception {
        //1.入参校验
        String uname = user.getUname();
        String pwd = user.getPwd();
        int role = user.getRole();
        String tel = user.getTel();
        if (uname == null || uname.equals("")) {
            throw new RuntimeException("用户名不能为空");
        }
        if (pwd == null || pwd.equals("")) {
            throw new RuntimeException("密码不能为空");
        }
        if (tel == null || tel.equals("")) {
            throw new RuntimeException("请输入电话");
        }
        //2.按照业务流程实现业务逻辑
        UserDao dao = new UserDao();
        User select = dao.select(uname);
        if (select != null) {
            return 0;
        }
        int register = dao.register(user);
        //3.保证事务完整性
        if (register != 1) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * 用户注册前校验
     *
     * @param uname
     * @return
     */
    public User jiaoyan(String uname) {
        if (uname == null || uname == "") {
            return null;
        }
        UserDao dao = new UserDao();
        try {
            User select = dao.select(uname);
            if (select != null){
                return select;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
