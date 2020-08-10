package edu.miu.lelafoods.order.dao;

import edu.miu.lelafoods.order.domain.Food;

public  interface FoodDao extends  GenericDao<Food>{

    public Food findByFoodName(String name);


}
