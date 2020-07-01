package team.bxbz.caffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.bxbz.caffee.mapper.UserMapper;
import team.bxbz.caffee.entity.*;
import team.bxbz.caffee.service.UserService;

@RestController
public class TestController {
    @Autowired
    private UserService userService;

    @RequestMapping("/helloworld")
    public String sayHW() {
        //测试用
        String s=userService.getUser("110");
        //String s=userService.getAdmin("xin");
        //String s=userService.getFood("xin");
        //String s=userService.getOrder("xin");
        //String s=userService.getCart("xin");
        return s;
    }
}
