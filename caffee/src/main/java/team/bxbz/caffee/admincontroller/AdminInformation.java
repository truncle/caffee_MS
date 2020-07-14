package team.bxbz.caffee.admincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import team.bxbz.caffee.entity.Administrator;
import team.bxbz.caffee.login.LoginController;
import team.bxbz.caffee.mapper.AdminMapper;

import javax.annotation.Resource;

//管理员修改个人信息
@Controller
public class AdminInformation {
    @Resource
    AdminMapper adminMapper;

    @RequestMapping(path = "admincontroller",method = RequestMethod.GET)
    public String list(Model model) {
        Administrator a = adminMapper.selectByAdminID(LoginController.loginname);
        model.addAttribute("admin", a);
        return "admin_login/listAdmin";
    }

    //修改管理员信息
    @GetMapping(path = "updateAdmin")
    public String changeUser(@RequestParam String password, @RequestParam String tele,
                             @RequestParam String email) {
        if (tele.length() == 11 && adminMapper.selectByAdminID(LoginController.loginname) != null) {
            adminMapper.updateByAdminID(new Administrator(LoginController.loginname, password, tele, email));
        }
        return "redirect:/admincontroller";
    }
}