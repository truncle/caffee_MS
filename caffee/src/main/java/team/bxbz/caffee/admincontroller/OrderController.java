package team.bxbz.caffee.admincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import team.bxbz.caffee.entity.Order;
import team.bxbz.caffee.mapper.OrderMapper;

import javax.annotation.Resource;
import java.util.List;

//管理员管理订单信息
@Controller
public class OrderController {
    @Resource
    OrderMapper orderMapper;

    @GetMapping(path = "ordercontroller")
    public String list(Model model) {
        List<Order> a = orderMapper.selectAll();
        model.addAttribute("orders", a);
        return "admin_login/listOrder";
    }

    //根据订单号查询订单
    @RequestMapping(path = "searchOrderByOrderID", method = RequestMethod.GET)
    public ModelAndView getIndex1(@RequestParam("orderID") Integer orderID) {
        ModelAndView av = new ModelAndView("admin_login/listOrder");
        if (orderMapper.selectByOrderID(orderID) != null) {
            av.addObject("orders", orderMapper.selectByOrderID(orderID));
        } else {
            av.addObject("orders", null);
        }
        av.addObject("keyValue1", orderID);
        return av;
    }

    //根据用户名查询订单
    @RequestMapping(path = "searchOrderByUserID", method = RequestMethod.GET)
    public ModelAndView getIndex2(@RequestParam("userID") String userID) {
        ModelAndView av = new ModelAndView("admin_login/listOrder");
        if (orderMapper.selectByUserID(userID) != null) {
            av.addObject("orders", orderMapper.selectByUserID(userID));
        } else {
            av.addObject("orders", null);
        }
        av.addObject("keyValue2", userID);
        return av;
    }
}
