package com.rikkei.ss08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Bai1 {
    @GetMapping("/")
    public ModelAndView bai1(){
        return new ModelAndView("Bai1/Welcome");
    }
}
