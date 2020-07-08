package team.bxbz.caffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import team.bxbz.caffee.entity.Food;
import team.bxbz.caffee.mapper.FoodMapper;

import javax.annotation.Resource;
import java.util.List;

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

    //删除指定餐点
    @RequestMapping(path = "deleteFood", method = RequestMethod.GET)
    public String deleteUser(@RequestParam String food_name) {
        foodMapper.deleteByName(food_name);
        return "redirect:http://localhost:8080/foodcontroller";
    }

    //根据餐点类型查询餐点
    @RequestMapping(path = "searchFood", method = RequestMethod.GET)
    public ModelAndView getIndex(@RequestParam("type") String type) {
        ModelAndView av = new ModelAndView("listFood");
        if (foodMapper.selectByType(type) != null) {
            av.addObject("foods", foodMapper.selectByType(type));
        } else {
            av.addObject("foods", null);
        }
        av.addObject("keyValue", type);
        return av;
    }

    //增加餐点
    @GetMapping(path = "addFood")
    public String addNewUser(@RequestParam String food_name, @RequestParam String food_type,
                             @RequestParam Integer food_amount, @RequestParam Double food_price) {
        if (foodMapper.selectByName(food_name) != null) {
        } else {
            foodMapper.insert(new Food(food_name, food_type, food_amount, food_price));
        }
        return "redirect:http://localhost:8080/foodcontroller";
    }

    //修改餐点信息
    @GetMapping(path = "changeFood")
    public String changeUser(@RequestParam String food_name, @RequestParam String food_type,
                             @RequestParam Integer food_amount, @RequestParam Double food_price) {
        if (foodMapper.selectByName(food_name) != null) {
            foodMapper.updateByName(new Food(food_name, food_type, food_amount, food_price));
        }
        return "redirect:http://localhost:8080/foodcontroller";
    }
}
