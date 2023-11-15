package com.example.demo.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class JoinController {
  @Autowired
  JoinDao dao;

  @RequestMapping("/joinMemberShip")
  public ModelAndView joinMemberShip(){
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/student/joinMemberShip");
    return mv;
  }

  @RequestMapping(value = "/joinMemberR", method=RequestMethod.POST)
  public String joinMemberR(@ModelAttribute JoinVo vo){
    String msg = "";
    msg = dao.joinMemeberR(vo);
    return msg;
  }
}
