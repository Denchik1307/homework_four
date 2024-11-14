package com.den.homework_four.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.den.homework_four.model.User;
import com.den.homework_four.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String homePageGet(){
        return "home";
    }

    @GetMapping("/user-list")
    public String findAllGet(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserGet(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUserPost(User user){
        userService.saveUser(user);
        return "redirect:/user-list";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.deleteById(id);
        return "redirect:/user-list";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserGet(@PathVariable("id") Integer id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUserPost(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/user-list";
    }
}