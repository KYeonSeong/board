package com.example.demo.join;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.example.demo.mybatis.MybaFactory;

@Component
public class JoinDao {
  SqlSession session;

  public JoinDao(){
    session = MybaFactory.getFactory().openSession();
  }

  public String joinMemeberR(JoinVo vo){
    String msg = "";
    int cnt = 0;
    try{
      cnt = session.insert("join.joinMember", vo);
      if(cnt < 1){
        msg = "가입 중 오류가 발생했어요";
        throw new Exception(msg);
      }
      session.commit();
    }catch(Exception ex){
      session.rollback();
    }
    return msg;
  }
}
