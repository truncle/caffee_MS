package team.bxbz.caffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.bxbz.caffee.entity.*;
import team.bxbz.caffee.mapper.*;

@Service
public class UserService {//用户服务类

    @Autowired
    private UserMapper userMapper;//管理用户

    @Autowired
    private AdminMapper adminMapper;//管理管理员

    @Autowired
    private FoodMapper foodMapper;//管理餐点

    @Autowired
    private OrderMapper orderMapper;//管理订单

    @Autowired
    private ShoppingCartMapper cartMapper;//管理购物车

    //以下get函数均为测试用
    public String getUser(String userID) {
        User a = userMapper.selectByUserID(userID);
        if (a != null) {
            System.out.println(a.toString());
            return a.toString();
        }
        //userMapper.insert(new User("123","123","123","123"));
        //userMapper.updateByUserID(new User("123","xin","12345678","xinxixn@qq.com"));
        //userMapper.deleteByUserID("123");
        else
            return "不存在";
    }

    public String getAdmin(String ad_ID) {
        String s = adminMapper.selectByAdminID(ad_ID).toString();
        //adminMapper.insert(new Administrator("123","123","123","123"));
        //adminMapper.updateByAdminID(new Administrator("123","xin","12345678","xinxixn@qq.com"));
        //adminMapper.deleteByAdminID("123");
        System.out.println(s);
        return s;
    }

    public String getFood(String name) {
        String s = foodMapper.selectByName(name).toString();
        //foodMapper.insert(new Food("123","123",123,123.12));
        //foodMapper.updateByName(new Food("123","xin",100,200));
        //foodMapper.deleteByName("123");
        System.out.println(s);
        return s;
    }

    public String getOrder(String ID) {
        //String s=orderMapper.selectByOrderID(ID).toString();
        String s = orderMapper.selectByUserID(ID).toString();
        //orderMapper.insert(new Order("123","123","123",123.12,100,10.2));
        //orderMapper.updateByOrderID(new Order("123","233","xin",11.2,10,112.0));
        //orderMapper.deleteByOrderID("123");
        System.out.println(s);
        return s;
    }

    public String getCart(String ID) {
        String s = cartMapper.selectByCartID(ID).toString();
        //String s=cartMapper.selectByUserID(ID).toString();
        //cartMapper.insert(new Shopping_cart("123","123","123",123.12,10,10.2));
        //cartMapper.updateByCartID(new Shopping_cart("123","233","xin",11.2,10,112.0));
        //cartMapper.deleteByCartID("123");
        System.out.println(s);
        return s;
    }

}
