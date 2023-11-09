package com.example.demo.student;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.example.demo.mybatis.MybaFactory;

@Component
public class LoginDao {
  SqlSession session;
  
  public LoginDao(){
    session = MybaFactory.getFactory().openSession();
  }

  public LoginVo login(LoginVo vo){
    LoginVo rVo = session.selectOne("login.loginCheck", vo);
    return rVo;
  }
}
