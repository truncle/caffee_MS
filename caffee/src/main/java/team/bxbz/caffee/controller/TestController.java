package team.bxbz.caffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.bxbz.caffee.mapper.UserMapper;
import team.bxbz.caffee.entity.*;
import team.bxbz.caffee.service.UserService;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/helloworld")
    public void sayHW() {
        //测试用
        String s = userService.getUser("110");
        List<User> a = userMapper.selectAll();
        System.out.println(a.toString());
        //String s=userService.getAdmin("xin");
        //String s=userService.getFood("xin");
        //String s=userService.getOrder("xin");
        //String s=userService.getCart("xin");
    }
}
