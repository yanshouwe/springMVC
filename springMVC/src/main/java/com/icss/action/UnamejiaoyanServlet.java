package com.icss.action;

import com.icss.biz.UserBiz;
import com.icss.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UnamejiaoyanServlet", value = "/UnamejiaoyanServlet")
public class UnamejiaoyanServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        System.out.println("uname=" + uname);
        UserBiz biz = new UserBiz();
        User iRet;
        iRet = biz.jiaoyan(uname);
        System.out.println("iRet=" + iRet);
        PrintWriter out = response.getWriter();
        out.print(iRet);
        out.flush();
        out.close();
    }
}
