package com.scm1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entities.User;
import forms.UserForm;
import jakarta.servlet.http.HttpSession;
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
    public String register(Model model, HttpSession session){
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        
        String message = (String) session.getAttribute("message");
        if (message != null) {
            session.removeAttribute("message"); // Remove message after reading
        }
        model.addAttribute("message", message);
        return "register";

    }

    // do register 
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm, HttpSession session) {
        System.out.println("Processing registration");
        // fetch form data
        // UserForm
        System.out.println(userForm);

        

        
        // validate form data
        // TODO::Validate userForm[Next Video]

        // save to database

        // userservice

        // UserForm--> User
        // User user = User.builder()
        //         .username(userForm.getUsername())
        //         .email(userForm.getEmail())
        //         .password(userForm.getPassword())
        //         .about(userForm.getAbout())
        //         .phoneNumber(userForm.getPhoneNumber())
        //         .profilePic(
        //                 "https://www.learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fdurgesh_sir.35c6cb78.webp&w=1920&q=75")
        //         .build();
        
        User user = new User();
        user.setUsername(userForm.getUsername());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic(
                "https://www.google.com/imgres?q=default%20profile%20picture&imgurl=https%3A%2F%2Fstatic.vecteezy.com%2Fsystem%2Fresources%2Fthumbnails%2F009%2F734%2F564%2Fsmall_2x%2Fdefault-avatar-profile-icon-of-social-media-user-vector.jpg&imgrefurl=https%3A%2F%2Fwww.vecteezy.com%2Ffree-vector%2Fdefault-profile-picture&docid=--oA6_9U9ufzsM&tbnid=dTyNFEwMBSuwDM&vet=12ahUKEwi9ssvjnMuKAxVRT2wGHSZxGLwQM3oECGsQAA..i&w=400&h=400&hcb=2&ved=2ahUKEwi9ssvjnMuKAxVRT2wGHSZxGLwQM3oECGsQAA");
        User savedUser = userService.saveUser(user);

        System.out.println("user saved :");

        session.setAttribute("message", "Registration Successful !!");

        // redirectto login page
        return "redirect:/register";
    }
}
