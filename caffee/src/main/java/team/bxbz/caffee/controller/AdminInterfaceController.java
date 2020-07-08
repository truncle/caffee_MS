package team.bxbz.caffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminInterfaceController {
    @GetMapping("modify_personal_information")
    public String modify_personal_information() {
        return "admin";
    }

    //跳转到用户控制界面
    @GetMapping("user_management")
    public String user_management() {
        return "redirect:http://localhost:8080/usercontroller";
    }

    //跳转到菜单控制界面
    @GetMapping("food_management")
    public String food_management() {
        return "redirect:http://localhost:8080/foodcontroller";
    }

    @GetMapping("order_management")
    public String order_management() {
        return "admin";
    }
}
