package ru.kata.preproject.SpringSecurityApp.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.preproject.SpringSecurityApp.security.UsersDetails;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        UsersDetails usersDetails = (UsersDetails)authentication.getPrincipal();
        System.out.println(usersDetails.getUser());

        return "hello";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }
}
