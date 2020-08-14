package edu.miu.lelafoods.order.controller;

import edu.miu.lelafoods.order.service.FoodService;
import edu.miu.lelafoods.order.domain.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping({"", "/all"})
    public List<Food> findAll() {
        List<Food> foodsList = foodService.findall();
        return foodsList;
    }


    @GetMapping("{id}")
    public Food findFoodById(@PathVariable("id") Long id) {
        return foodService.findById(id);
    }

    @GetMapping("/name/{name}")
    public Food findFoodByName(@PathVariable("name") String name) {
        return foodService.findByFoodName(name);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addFood(@RequestBody Food food) {
        foodService.save(food);
    }



    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        foodService.deleteById(id);
    }

}
