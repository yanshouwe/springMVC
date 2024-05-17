package com.icss.biz;

import com.icss.dao.OrderDao;
import com.icss.entity.Order;

import java.util.List;

public class OrderBiz {
    OrderDao dao = new OrderDao();

    public int addOrder(Order order) throws Exception {
        return dao.addOrder(order);
    }

    public List<Order> selectOrder(String uname) throws Exception {
        return dao.selectOrder(uname);
    }

    public int updateOrder(int id) throws Exception {
        return dao.update(id);
    }
}
