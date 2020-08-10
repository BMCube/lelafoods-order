package edu.miu.lelafoods.order.service.impl;

import edu.miu.lelafoods.order.dao.FoodDao;
import edu.miu.lelafoods.order.domain.Food;
import edu.miu.lelafoods.order.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoodServiceImpl  implements FoodService {

    @Autowired
    private FoodDao foodDao;
    @Override
    public void save(Food food) {
        foodDao.save(food);

    }

    @Override
    public List<Food> findall() {
        return foodDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        foodDao.deleteById(id);

    }

    @Override
    public Food findByFoodName(String name) {
        return foodDao.findByFoodName(name);
    }

    @Override
    public Food findById(Long id) {
        return foodDao.findOne(id);
    }
}
