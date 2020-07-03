package team.bxbz.caffee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.bxbz.caffee.entity.User;
import team.bxbz.caffee.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Resource
    UserMapper userMapper;

    @GetMapping(path = "usercontroller")
    public String list(Model model) {
        List<User> a = userMapper.selectAll();
        model.addAttribute("users", a);
        return "listUser";
    }

    @GetMapping(path = "deleteUser")
    public String deleteUser(@RequestParam String userID) {
        userMapper.deleteByUserID(userID);
        return "redirect:http://localhost:8080/usercontroller";
    }

    @GetMapping(path = "addUser")
    public String addNewUser(@RequestParam String userID, @RequestParam String password,
                             @RequestParam String tele, @RequestParam String email,
                             Map<String, Object> map) {
        userMapper.insert(new User(userID, password, tele, email));
        return "redirect:http://localhost:8080/usercontroller";
    }

    @GetMapping(path = "changeUser")
    public String changeUser(@RequestParam String userID, @RequestParam String password,
                             @RequestParam String tele, @RequestParam String email,
                             Map<String, Object> map) {
        if (userMapper.selectByUserID(userID) != null) {
            userMapper.updateByUserID(new User(userID, password, tele, email));
        }
        return "redirect:http://localhost:8080/usercontroller";
    }
}
