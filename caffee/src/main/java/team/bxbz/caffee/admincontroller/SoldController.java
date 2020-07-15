package team.bxbz.caffee.admincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import team.bxbz.caffee.entity.Sold;
import team.bxbz.caffee.mapper.SoldMapper;

import javax.annotation.Resource;
import java.util.List;

//统计销售数量
@Controller
public class SoldController {
    @Resource
    SoldMapper soldMapper;

    @GetMapping(path = "soldcontroller")
    public String list(Model model) {
        List<Sold> a = soldMapper.selectAll();
        model.addAttribute("sold", a);
        return "admin_login/listSold";
    }
}
