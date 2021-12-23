package com.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/login")
    public String login(){
        return "user/logreg";
    }

    @GetMapping("user/center")
    public String center(){
        return "user/user-center";
    }
}
