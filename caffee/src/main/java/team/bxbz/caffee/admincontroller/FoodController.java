package team.bxbz.caffee.admincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import team.bxbz.caffee.entity.Food;
import team.bxbz.caffee.entity.Sold;
import team.bxbz.caffee.mapper.FoodMapper;
import team.bxbz.caffee.mapper.SoldMapper;

import javax.annotation.Resource;
import java.util.List;

//管理员管理菜单信息
@Controller
public class FoodController {
    @Resource
    FoodMapper foodMapper;

    @Resource
    SoldMapper soldMapper;

    @GetMapping(path = "foodcontroller")
    public String list(Model model) {
        List<Food> a = foodMapper.selectAll();
        model.addAttribute("foods", a);
        return "admin_login/listFood";
    }

    //删除指定餐点
    @RequestMapping(path = "deleteFood", method = RequestMethod.GET)
    public String deleteUser(@RequestParam String food_name) {
        foodMapper.deleteByName(food_name);
        return "redirect:/foodcontroller";
    }

    //根据餐点类型查询餐点
    @RequestMapping(path = "adminSearchFoods", method = RequestMethod.GET)
    public ModelAndView getIndex(@RequestParam("type") String type) {
        ModelAndView av = new ModelAndView("admin_login/listFood");
        if (foodMapper.selectByType(type) != null) {
            av.addObject("foods", foodMapper.selectByType(type));
        } else {
            av.addObject("foods", null);
        }
        return av;
    }

    //增加餐点信息，注意：图片必须放置于caffee/src/main/resources/images下面，用户输入图片的时候只需输入图片名字即可
    @GetMapping(path = "addFood")
    public String addNewUser(@RequestParam String food_name, @RequestParam String food_type,
                             @RequestParam Integer food_amount, @RequestParam Double food_price,
                             @RequestParam String picture) {
        if (foodMapper.selectByName(food_name) != null) {
        } else {
            foodMapper.insert(new Food(food_name, food_type, food_amount, food_price,picture));
            soldMapper.insert(new Sold(food_name,0));
        }
        return "redirect:/foodcontroller";
    }

    //修改餐点信息，注意：图片必须放置于caffee/src/main/resources/images下面，用户输入图片的时候只需输入图片名字即可
    @GetMapping(path = "changeFood")
    public String changeUser(@RequestParam String food_name, @RequestParam String food_type,
                             @RequestParam Integer food_amount, @RequestParam Double food_price,
                             @RequestParam String picture) {
        if (foodMapper.selectByName(food_name) != null) {
            foodMapper.updateByName(new Food(food_name, food_type, food_amount, food_price,picture));
        }
        return "redirect:/foodcontroller";
    }
}
