package team.bxbz.caffee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HWcontroller {
    @RequestMapping("/helloworld")
    public String sayHW() {
        return "HelloWorld";
    }
}
