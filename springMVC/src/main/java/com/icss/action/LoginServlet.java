package com.icss.action;

import com.icss.biz.UserBiz;
import com.icss.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/main/login.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        if (uname == null || uname.equals("")) {
            throw new RuntimeException("用户名不能为空");
        }
        if (pwd == null || pwd.equals("")) {
            throw new RuntimeException("密码不能为空");
        }
        System.out.println("uname=" + uname + ",pwd=" + pwd);
        UserBiz biz = new UserBiz();
        int iRet;
        try {
            User user = biz.login(uname, pwd);
            if (user != null) {
                System.out.println(uname + "登陆成功!");
                request.getSession().setAttribute("user",user);
                iRet = 1;
            } else {
                request.setAttribute("msg", "登陆失败！！！！");
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
