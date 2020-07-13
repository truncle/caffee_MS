package team.bxbz.caffee.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.bxbz.caffee.entity.Administrator;
import team.bxbz.caffee.entity.User;
import team.bxbz.caffee.mapper.AdminMapper;
import team.bxbz.caffee.mapper.UserMapper;

import java.util.Map;

//用户和管理员登录
@Controller
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AdminMapper adminMapper;

    public static String loginname;//登录的用户名

    //注册用户
    @GetMapping(path = "/add")
    public String register() {
        return "register";
    }

    @GetMapping(path = "/register")
    public String addNewUser(@RequestParam String userID, @RequestParam String password,
                             @RequestParam String tele, @RequestParam String email,
                             Map<String, Object> map) {
        if (userMapper.selectByUserID(userID) != null) {
            map.put("msg1", "该用户已存在");//提示信息，该用户已存在
            return "register";
        } else if (tele.length() != 11) {//提示信息，电话号码的位数为11位
            map.put("msg1", "请输入正确的电话号码");
            return "register";
        } else {//注册成功返回登录界面
            userMapper.insert(new User(userID, password, tele, email));
            return "redirect:http://localhost:8080";
        }
    }

    //登录界面可以登录用户和管理员，其中只有管理员的用户名为admin(管理员为内置且唯一)
    @GetMapping(path = "/login")
    public String login(@RequestParam String userID, @RequestParam String password,
                        @RequestParam String user_or_admin, Model model, Map<String, Object> map) {
        if (!user_or_admin.equals("admin")) {
            User a = userMapper.selectByUserID(userID);
            if (a == null) {
                map.put("msg3", "该用户不存在");//提示信息，该用户不存在
                return "index";
            } else if (a.getPassword().equals(password)) {
                loginname = userID;
                model.addAttribute("name", a.getUserID());
                return "user_login/user";//用户登录成功会跳转到用户界面
            } else {
                map.put("msg5", "密码错误");//提示信息，密码错误
                return "index";
            }
        } else {
            Administrator b = adminMapper.selectByAdminID(userID);
            if (b == null) {
                map.put("msg3", "该用户不存在");//提示信息，该用户不存在
                return "index";
            } else if (b.getAd_password().equals(password)) {
                loginname = userID;
                return "admin_login/admin";
            } else {
                map.put("msg5", "密码错误");//提示信息，密码错误
                return "index";
            }
        }
    }
}