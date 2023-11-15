package com.example.demo.main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@RestController
public class MainController {
  @RequestMapping("/")
  public ModelAndView index(HttpSession session){
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/index");
    return mv;
  }
}
