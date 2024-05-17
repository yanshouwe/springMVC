package com.icss.action;

import com.icss.biz.DishBiz;
import com.icss.biz.OrderBiz;
import com.icss.biz.UserBiz;
import com.icss.dao.OrderDao;
import com.icss.entity.Dish;
import com.icss.entity.Order;
import com.icss.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String op = request.getParameter("op");
        DishBiz dishBiz = new DishBiz();
        UserBiz userBiz = new UserBiz();
        OrderBiz biz = new OrderBiz();
        if ("toadd".equals(op)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String uname = request.getParameter("uname");
            Dish dish = dishBiz.selectDish(id);
            request.setAttribute("dish",dish);
            request.setAttribute("uname",uname);
            request.getRequestDispatcher("/main/addOrder.jsp").forward(request, response);
        }else if ("add".equals(op)){
            String odate = request.getParameter("odate");
            String dname = request.getParameter("dname");
            String uname = request.getParameter("uname");
            int num = Integer.parseInt(request.getParameter("num"));
            float price = Float.parseFloat(request.getParameter("price"));
            float tprice = num * price;
            Order order = new Order();
            Dish dish = dishBiz.selectBynameDish(dname);
            User jiaoyan = userBiz.jiaoyan(uname);
            order.setOdate(odate);
            order.setTprice(tprice);
            order.setUserId(uname);
            order.setDish(dish);
            order.setDishId(dish.getId());
            order.setUser(jiaoyan);
            order.setNum(num);
            try {
                biz.addOrder(order);
                List<Order> list = biz.selectOrder(uname);
                request.setAttribute("list",list);
                request.getRequestDispatcher("/main/order.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if ("update".equals(op)){
            int id = Integer.parseInt(request.getParameter("id"));
            String uname = request.getParameter("uname");
            try {
                int i = biz.updateOrder(id);
                List<Order> list = biz.selectOrder(uname);
                request.setAttribute("list",list);
                request.getRequestDispatcher("/main/order.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
