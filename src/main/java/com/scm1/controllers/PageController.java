package com.scm1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Correct import
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "substr");
        model.addAttribute("yt", "xyz");
        model.addAttribute("age", "21");
        return "home";
    }
}
