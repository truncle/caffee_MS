package team.bxbz.caffee.admincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import team.bxbz.caffee.entity.User;
import team.bxbz.caffee.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.List;

//管理员管理用户信息
@Controller
public class UserController {
    @Resource
    UserMapper userMapper;

    @GetMapping(path = "usercontroller")
    public String list(Model model) {
        List<User> a = userMapper.selectAll();
        model.addAttribute("users", a);
        return "admin_login/listUser";
    }

    //删除用户
    @RequestMapping(path = "deleteUser", method = RequestMethod.GET)
    public String deleteUser(@RequestParam String userID) {
            userMapper.deleteByUserID(userID);
            return "redirect:/usercontroller";
    }

    //查询用户
    @RequestMapping(path = "searchUser", method = RequestMethod.GET)
    public ModelAndView getIndex(@RequestParam("id") String id) {
        ModelAndView av = new ModelAndView("admin_login/listUser");
        if (userMapper.selectByUserID(id) != null) {
            av.addObject("users", userMapper.selectByUserID(id));
        } else {
            av.addObject("users", null);
        }
        av.addObject("keyValue", id);
        return av;
    }

    //增加用户
    @GetMapping(path = "addUser")
    public String addNewUser(@RequestParam String userID, @RequestParam String password,
                             @RequestParam String tele, @RequestParam String email) {
        if (userMapper.selectByUserID(userID) == null & tele.length() == 11) {//用户名不存在，并且电话号码为正确的11位
            userMapper.insert(new User(userID, password, tele, email));
        }
        return "redirect:/usercontroller";
    }

    //修改用户信息
    @GetMapping(path = "changeUser")
    public String changeUser(@RequestParam String userID, @RequestParam String password,
                             @RequestParam String tele, @RequestParam String email) {
        if (userMapper.selectByUserID(userID) != null && tele.length() == 11) {//用户名存在并且电话号码为正确的11位
            userMapper.updateByUserID(new User(userID, password, tele, email));
        }
        return "redirect:/usercontroller";
    }
}
