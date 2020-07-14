package team.bxbz.caffee.usercontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import team.bxbz.caffee.entity.Food;
import team.bxbz.caffee.entity.ShoppingCart;
import team.bxbz.caffee.login.LoginController;
import team.bxbz.caffee.mapper.FoodMapper;
import team.bxbz.caffee.mapper.ShoppingCartMapper;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class FoodInformation {
    @Resource
    FoodMapper foodMapper;

    @Resource
    ShoppingCartMapper shoppingCartMapper;

    @RequestMapping(path = "foodinformation",method = RequestMethod.GET)
    public String list(Model model) {
        List<Food> a = foodMapper.selectAll();
        model.addAttribute("foods_information", a);
        return "user_login/foodInformation";
    }

    //加入购物车
    @RequestMapping(path = "add_to_cart", method = RequestMethod.GET)
    public String add_to_cart(@RequestParam String food_name) {
        Food food=foodMapper.selectByName(food_name);
        Double price=food.getPrice();
        shoppingCartMapper.insert(new ShoppingCart(LoginController.loginname,food_name,price,1,1*price));
        return "redirect:/foodinformation";
    }

    //根据餐点类型查询餐点
    @RequestMapping(path = "userSearchFoods", method = RequestMethod.GET)
    public ModelAndView getIndex(@RequestParam("type") String type) {
        ModelAndView av = new ModelAndView("user_login/foodInformation");
        if (foodMapper.selectByType(type) != null) {
            av.addObject("foods_information", foodMapper.selectByType(type));
        } else {
            av.addObject("foods_information", null);
        }
        return av;
    }
}
