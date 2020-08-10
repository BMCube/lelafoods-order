package edu.miu.lelafoods.order.dao.impl;

import edu.miu.lelafoods.order.dao.FoodDao;
import edu.miu.lelafoods.order.domain.Food;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class FoodDaoImpl extends GenericDaoImpl<Food> implements FoodDao {
    public FoodDaoImpl(){
        super.setDaoType(Food.class);
    }
    @Override
    public Food findByFoodName(String name) {
        Query query = entityManager.createQuery(" select f from Food f where f.name =:name");
        return (Food)query.setParameter("name", name);
    }
}
