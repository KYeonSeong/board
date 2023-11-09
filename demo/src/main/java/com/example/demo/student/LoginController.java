package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@RestController
public class LoginController {
  @Autowired
  LoginDao loginDao;

  @RequestMapping("/login")
  public ModelAndView login(){
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/student/login");
    return mv;
  }

  @RequestMapping("/loginR")
  public String loginR(HttpSession session, LoginVo vo){
    String msg = "";
    LoginVo rVo = loginDao.login(vo);

    if(rVo != null && rVo.getName() != null){
      session.setAttribute("id", rVo.getId());
      session.setAttribute("name", rVo.getName());
    }else{
      msg = "로그인에 실패했어요";
    }
    return msg;
  }

  @RequestMapping("/logoutR")
  public void logoutR(HttpSession session){
    session.setAttribute("id", null);
    session.setAttribute("name", null);
  }
}
