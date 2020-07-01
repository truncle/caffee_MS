package team.bxbz.caffee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AdminMapper adminMapper;

    //注册用户
    @GetMapping(path = "/add")
    public String addNewUser(@RequestParam String userID, @RequestParam String password,
                             @RequestParam String tele, @RequestParam String email,
                             Map<String, Object> map) {
        if (userMapper.selectByUserID(userID) != null) {
            log.info("\n该用户已存在\n");
            map.put("msg1", "该用户已存在");//提示信息，该用户已存在
        } else {
            userMapper.insert(new User(userID, password, tele, email));
            map.put("msg2", "注册成功");//提示信息，注册成功
            System.out.println(userMapper.selectByUserID(userID).toString() + "\n注册成功\n");
        }
        return "index";//返回index.html
    }

    //登录界面可以登录用户和管理员，其中只有管理员的用户名为admin(管理员为内置且唯一)
    @GetMapping(path = "/login")
    public String login(@RequestParam String userID, @RequestParam String password,
                        Model model, Map<String, Object> map) {
        if (!userID.equals("admin")) {
            User a = userMapper.selectByUserID(userID);
            if (a == null) {
                log.info("\nattempting to log in with the non-existed account\n");
                map.put("msg3", "该用户不存在");//提示信息，该用户不存在
                return "index";
            } else if (a.getPassword().equals(password)) {
                model.addAttribute("name", a.getUserID());
                map.put("msg4", "登录成功");//提示信息，登录成功
                log.info("\n" + a.getUserID() + "登录成功");
                return "index";//后续用户登录成功会跳转到用户界面
            } else {
                map.put("msg5", "密码错误");//提示信息，密码错误
                log.info("\n" + a.getUserID() + "密码错误，登录失败");
                return "index";
            }
        } else {
            Administrator b = adminMapper.selectByAdminID(userID);
            if (b == null) {
                map.put("msg3", "该用户不存在");//提示信息，该用户不存在
                return "index";
            } else if (b.getAd_password().equals(password)) {
                map.put("msg4", "登录成功");//提示信息，登录成功
                log.info("\n" + b.getAd_ID() + "登录成功");
                return "index";//后续管理员登录成功会跳转到管理员界面
            } else {
                map.put("msg5", "密码错误");//提示信息，密码错误
                log.info("\n" + b.getAd_ID() + "密码错误，登录失败");
                return "index";
            }
        }
    }
}