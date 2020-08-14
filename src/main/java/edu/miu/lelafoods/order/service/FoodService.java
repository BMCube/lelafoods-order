package edu.miu.lelafoods.order.service;

import edu.miu.lelafoods.order.domain.Food;

import java.util.List;

public interface FoodService {
    public void save(Food food);
    public List<Food> findall();
    public  void  deleteById(Long id);
    public  Food findByFoodName(String name);
    public Food findById(Long id);

}
