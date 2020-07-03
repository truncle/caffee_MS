package team.bxbz.caffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.bxbz.caffee.entity.Food;
import team.bxbz.caffee.entity.User;
import team.bxbz.caffee.mapper.FoodMapper;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class FoodController {
    @Resource
    FoodMapper foodMapper;

    @GetMapping(path = "foodcontroller")
    public String list(Model model) {
        List<Food> a = foodMapper.selectAll();
        model.addAttribute("foods", a);
        return "listFood";
    }

    @GetMapping(path = "deleteFood")
    public String deleteUser(@RequestParam String food_name) {
        foodMapper.deleteByName(food_name);
        return "redirect:http://localhost:8080/foodcontroller";
    }

    @GetMapping(path = "addFood")
    public String addNewUser(@RequestParam String food_name, @RequestParam String food_type,
                             @RequestParam Integer food_amount, @RequestParam Double food_price) {
        foodMapper.insert(new Food(food_name,food_type,food_amount,food_price));
        return "redirect:http://localhost:8080/foodcontroller";
    }

    @GetMapping(path = "changeFood")
    public String changeUser(@RequestParam String food_name, @RequestParam String food_type,
                             @RequestParam Integer food_amount, @RequestParam Double food_price) {
        if (foodMapper.selectByName(food_name)!=null) {
            foodMapper.updateByName(new Food(food_name,food_type,food_amount,food_price));
        }
        return "redirect:http://localhost:8080/foodcontroller";
    }
}
