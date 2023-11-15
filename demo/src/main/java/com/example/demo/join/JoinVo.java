package com.example.demo.join;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinVo {
  String id, name, pwd;

  public void setId(String id){
    this.id = id;
  }
}
