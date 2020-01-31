package com.msyrovets.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String startPage(){
        return "home";
    }

    @GetMapping("/leaders")
    public String leadersPage(){
        return "leaders";
    }

    @GetMapping("/system")
    public String systemPage(){
        return "system";
    }
}
