package team.bxbz.caffee.usercontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.bxbz.caffee.login.LoginController;
import team.bxbz.caffee.entity.User;
import team.bxbz.caffee.mapper.UserMapper;

import javax.annotation.Resource;

//用户修改个人信息
@Controller
public class UserInformation {
    @Resource
    UserMapper userMapper;

    @GetMapping(path = "userinformation")
    public String list(Model model) {
        User a = userMapper.selectByUserID(LoginController.loginname);//获取当前登录的用户的信息
        model.addAttribute("user", a);
        return "user_login/userInformation";
    }

    //修改用户信息
    @GetMapping(path = "updateUser")
    public String changeUser(@RequestParam String password, @RequestParam String tele,
                             @RequestParam String email) {
        if (tele.length() == 11 && userMapper.selectByUserID(LoginController.loginname) != null) {
            userMapper.updateByUserID(new User(LoginController.loginname, password, tele, email));
        }
        return "redirect:/userinformation";
    }
}
