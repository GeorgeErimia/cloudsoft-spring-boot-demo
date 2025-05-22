package com.example.cloudsoftspringboot.controller;

import com.example.cloudsoftspringboot.model.User;
import com.example.cloudsoftspringboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(ModelMap model) {
        List<User> users = userService.getAllUsers();
        if(users.isEmpty())
            model.addAttribute("users", null);
        else model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable final Long id, ModelMap model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/user/create")
    public String userCreationPage(ModelMap model) {
        model.addAttribute("user", new User());
        return "usercreateform";
    }

    @PostMapping("/user/create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        if (user == null) {
            // Optional: handle user not found
            return "redirect:/users";
        }
        model.addAttribute("user", user);
        return "usereditform"; // name of your Thymeleaf template
    }

    @PostMapping("/user/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user.getId(), user);
        return "redirect:/user/" + user.getId();
    }

    @PostMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }


}
