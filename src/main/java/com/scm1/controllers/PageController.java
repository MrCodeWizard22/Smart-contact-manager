package com.scm1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entities.User;
import forms.UserForm;
import services.UserService;

@Controller
public class PageController {
    
    @org.springframework.beans.factory.annotation.Autowired(required=true)
    private UserService userService;

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "substr");
        model.addAttribute("yt", "xyz");
        model.addAttribute("age", "21");
        return "home";
    }
    @RequestMapping("/services")
    public String services(){
        return "services";
    }
    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }

    // register 
    @RequestMapping("/register")
    public String register(Model model){
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "register";

    }

    // do register 
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm) {
        System.out.println("Processing registration");
        // fetch form data
        // UserForm
        System.out.println(userForm);

        // validate form data
        // TODO::Validate userForm[Next Video]

        // save to database

        // userservice

        // UserForm--> User
        User user = User.builder()
                .username(userForm.getUsername())
                .email(userForm.getEmail())
                .password(userForm.getPassword())
                .about(userForm.getAbout())
                .phoneNumber(userForm.getPhoneNumber())
                .profilePic(
                        "https://www.learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fdurgesh_sir.35c6cb78.webp&w=1920&q=75")
                .build();

        User savedUser = userService.saveUser(user);

        System.out.println("user saved :");

        // message = "Registration Successful"

        // redirectto login page
        return "redirect:/register";
    }
}
