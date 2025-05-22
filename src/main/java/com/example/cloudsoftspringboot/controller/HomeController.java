package com.example.cloudsoftspringboot.controller;

import com.example.cloudsoftspringboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String sayHello(ModelMap model) {
        model.addAttribute("title", "Cloudsoft Demo");
        return "index";
    }
}
