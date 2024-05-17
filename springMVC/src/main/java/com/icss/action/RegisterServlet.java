package com.icss.action;

import com.icss.biz.UserBiz;
import com.icss.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/main/registe.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        int role = Integer.parseInt(request.getParameter("role"));
        String tel = request.getParameter("tel");
        if (uname == null || uname.equals("")) {
            throw new RuntimeException("用户名不能为空");
        }
        if (pwd == null || pwd.equals("")) {
            throw new RuntimeException("密码不能为空");
        }
        if (tel == null || tel.equals("")) {
            throw new RuntimeException("请输入电话");
        }
        User user = new User();
        user.setUname(uname);
        user.setTel(tel);
        user.setRole(role);
        user.setPwd(pwd);
        UserBiz biz = new UserBiz();
        int iRet;
        try {
            int register = biz.register(user);
            if (register != 0) {
                System.out.println(uname + "注册成功");
                iRet = 1;
            } else {
                System.out.println("注册失败，用户名重复，请重新输入！！！！！");
                iRet = 0;
            }

        } catch (Exception e) {
            iRet = -1;
        }
        System.out.println("iRet=" + iRet);
        PrintWriter out = response.getWriter();
        out.print(iRet);
        out.flush();
        out.close();
    }
}
