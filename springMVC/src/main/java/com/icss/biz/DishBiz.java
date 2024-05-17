package com.icss.biz;

import com.icss.dao.DishDao;
import com.icss.entity.Dish;

import java.util.List;

public class DishBiz {
    DishDao dao = new DishDao();
    public int addDish(Dish dish) {
        try {
            int i = dao.insert(dish);
            if (i == 1){
                System.out.println("Ìí¼Ó³É¹¦¡£¡£¡£¡£¡£");
                return 1;
            }
            return 0;
        } catch (Exception e) {
            System.out.println("Ìí¼ÓÊ§°Ü¡£¡£¡£¡£¡£¡£¡£¡£");
            return -1;
        }
    }
    public int deleteDish(int id){
        try {
            int i = dao.deletById(id);
            if (i==1){
                System.out.println("É¾³ý³É¹¦¡£¡£¡£¡£¡£");
                return 1;
            }
            return 0;
        } catch (Exception e) {
            System.out.println("É¾³ýÊ§°Ü¡£¡£¡£¡£");
            return -1;
        }
    }
    public int updateDish(Dish dish){
        DishDao dao = new DishDao();
        try {
            return dao.update(dish);
        } catch (Exception e) {
            return -1;
        }
    }
    public Dish selectDish(int id){
        try {
            Dish dish = dao.selectById(id);
            if (dish!=null){
                System.out.println("²ËÆ·´æÔÚ¡£¡£¡£¡£");
            }
            return dish;
        } catch (Exception e) {
            System.out.println("²éÑ¯Ê§°Ü¡£¡£¡£¡£");
            return null;
        }
    }
    public List<Dish> selectAll(){
        try {
            List<Dish> list = dao.select();
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    public Dish selectBynameDish(String dname){
        try {
            return dao.selectByName(dname);
        } catch (Exception e) {
            return null;
        }
    }
}
