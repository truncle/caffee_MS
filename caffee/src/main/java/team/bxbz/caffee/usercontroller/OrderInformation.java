package team.bxbz.caffee.usercontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import team.bxbz.caffee.entity.Order;
import team.bxbz.caffee.login.LoginController;
import team.bxbz.caffee.mapper.OrderMapper;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class OrderInformation {
    @Resource
    OrderMapper orderMapper;

    //获取订单信息，用户只能获得自身的用户信息
    @GetMapping(path = "orderinformation")
    public String list(Model model) {
        List<Order> a = orderMapper.selectByUserID(LoginController.loginname);
        model.addAttribute("orders_information", a);
        return "user_login/orderInformation";
    }
}
