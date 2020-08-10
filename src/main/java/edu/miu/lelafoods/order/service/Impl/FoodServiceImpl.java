package edu.miu.lelafoods.order.service.impl;

import edu.miu.lelafoods.order.dao.FoodDao;
import edu.miu.lelafoods.order.domain.Food;
import edu.miu.lelafoods.order.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class FoodServiceImpl  implements FoodService {

    @Autowired
    private FoodDao foodDao;

    public void save(Food food) {
        foodDao.save(food);

    }


    public List<Food> findall() {
        return foodDao.findAll();
    }


    public void deleteById(Long id) {
        foodDao.deleteById(id);

    }

    @Override
    public Food findByFoodName(String name) {
        return foodDao.findByFoodName(name);
    }


    public Food findById(Long id) {
        return foodDao.findOne(id);
    }
}
