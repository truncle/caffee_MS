package team.bxbz.caffee.usercontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import team.bxbz.caffee.entity.Food;
import team.bxbz.caffee.entity.Order;
import team.bxbz.caffee.entity.ShoppingCart;
import team.bxbz.caffee.entity.Sold;
import team.bxbz.caffee.login.LoginController;
import team.bxbz.caffee.mapper.FoodMapper;
import team.bxbz.caffee.mapper.OrderMapper;
import team.bxbz.caffee.mapper.ShoppingCartMapper;
import team.bxbz.caffee.mapper.SoldMapper;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CartInformation {
    @Resource
    ShoppingCartMapper shoppingCartMapper;

    @Resource
    FoodMapper foodMapper;

    @Resource
    OrderMapper orderMapper;

    @Resource
    SoldMapper soldMapper;

    @GetMapping(path = "cartinformation")
    public String list(Model model) {
        List<ShoppingCart> a = shoppingCartMapper.selectByUserID(LoginController.loginname);
        model.addAttribute("carts_information", a);
        return "user_login/cartInformation";
    }

    //减少数量
    @RequestMapping(path = "delete_amount", method = RequestMethod.GET)
    public String delete_amount(@RequestParam Integer cart_id) {
        if (shoppingCartMapper.selectByCartID(cart_id).getFood_amount() >= 1) {
            ShoppingCart shoppingCart = shoppingCartMapper.selectByCartID(cart_id);
            shoppingCartMapper.updateByCartID(new ShoppingCart(shoppingCart.getCart_id(),
                    shoppingCart.getUser_id(), shoppingCart.getFood_name(),
                    shoppingCart.getFood_price(), shoppingCart.getFood_amount() - 1,
                    shoppingCart.getFood_price() * (shoppingCart.getFood_amount() - 1)));
        }
        return "redirect:/cartinformation";
    }

    //增加数量
    @RequestMapping(path = "add_amount", method = RequestMethod.GET)
    public String add_amount(@RequestParam Integer cart_id) {
        ShoppingCart shoppingCart = shoppingCartMapper.selectByCartID(cart_id);
        shoppingCartMapper.updateByCartID(new ShoppingCart(shoppingCart.getCart_id(),
                shoppingCart.getUser_id(), shoppingCart.getFood_name(), shoppingCart.getFood_price(),
                shoppingCart.getFood_amount() + 1,
                shoppingCart.getFood_price() * (shoppingCart.getFood_amount() + 1)));
        return "redirect:/cartinformation";
    }

    //删除购物车
    @RequestMapping(path = "delete_cart", method = RequestMethod.GET)
    public String delete_cart(@RequestParam Integer cart_id) {
        shoppingCartMapper.deleteByCartID(cart_id);
        return "redirect:/cartinformation";
    }

    //点击结算生成订单，并且修改库存信息并且修改sold表
    @RequestMapping(path = "add_to_order", method = RequestMethod.GET)
    public String add_to_cart(@RequestParam Integer cart_id) {
        ShoppingCart shoppingCart = shoppingCartMapper.selectByCartID(cart_id);

        orderMapper.insert(new Order(shoppingCart.getUser_id(), shoppingCart.getFood_name(),
                shoppingCart.getFood_price(), shoppingCart.getFood_amount(), shoppingCart.getTotal_price()));

        shoppingCartMapper.deleteByCartID(cart_id);//结算之后从购物车中删除该购物车

        Food a = foodMapper.selectByName(shoppingCart.getFood_name());
        foodMapper.updateByName(new Food(a.getName(), a.getType(),
                a.getAmount() - shoppingCart.getFood_amount(),
                a.getPrice()));//更改库存数量
        soldMapper.updateByFoodName(new Sold(shoppingCart.getFood_name(),
                soldMapper.selectByFoodName(shoppingCart.getFood_name()).getSold_amount() + shoppingCart.getFood_amount()));
        //修改sold表中的信息
        return "redirect:/cartinformation";
    }
}
