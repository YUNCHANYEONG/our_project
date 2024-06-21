package com.project.project.controller;

import com.project.project.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("")
public class IndexController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String Index(@AuthenticationPrincipal User user){
        System.out.println( "userid : " + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 24));
        System.out.println( "password : " + passwordEncoder.encode("q1w2e3r4!!"));
        return "index";
    }

    @GetMapping("/main")
    public String Main(@AuthenticationPrincipal User user){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return "main";
    }
}
