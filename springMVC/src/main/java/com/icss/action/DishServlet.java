package com.icss.action;

import com.icss.biz.DishBiz;
import com.icss.entity.Dish;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DishServlet", value = "/DishServlet")
public class DishServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String op = request.getParameter("op");
        DishBiz biz = new DishBiz();
        if ("list".equals(op)) {
            List<Dish> list = biz.selectAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/main/main.jsp").forward(request, response);
        } else if ("delete".equals(op)) {
            int id = Integer.parseInt(request.getParameter("id"));
            int i = biz.deleteDish(id);
            List<Dish> list = biz.selectAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/main/menu.jsp").forward(request, response);
        } else if ("mlist".equals(op)) {
            List<Dish> list = biz.selectAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/main/menu.jsp").forward(request, response);
        } else if ("toupdate".equals(op)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Dish dish = biz.selectDish(id);
            request.setAttribute("dish", dish);
            request.getRequestDispatcher("/main/update.jsp").forward(request, response);
        } else if ("update".equals(op)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String dname = request.getParameter("dname");
            String pic = request.getParameter("pic");
            float price = Float.parseFloat(request.getParameter("price"));
            String details = request.getParameter("details");
            Dish dish = new Dish();
            dish.setId(id);
            dish.setDname(dname);
            dish.setPic(pic);
            dish.setDetails(details);
            dish.setPrice(price);
            biz.updateDish(dish);
            List<Dish> list = biz.selectAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/main/menu.jsp").forward(request, response);
        } else if ("toadd".equals(op)) {
            request.getRequestDispatcher("/main/addDish.jsp").forward(request, response);
        } else if ("add".equals(op)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String dname = request.getParameter("dname");
            String pic = request.getParameter("pic");
            float price = Float.parseFloat(request.getParameter("price"));
            String details = request.getParameter("details");
            Dish dish = new Dish();
            dish.setId(id);
            dish.setDname(dname);
            dish.setPic(pic);
            dish.setDetails(details);
            dish.setPrice(price);
            if (biz.selectDish(id) != null) {
                String msg = "ÒÑ´æÔÚ";
                request.setAttribute("msg",msg);
                request.getRequestDispatcher("/main/addDish.jsp").forward(request, response);
            }else {
                biz.addDish(dish);
                List<Dish> list = biz.selectAll();
                request.setAttribute("list", list);
                request.getRequestDispatcher("/main/menu.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
