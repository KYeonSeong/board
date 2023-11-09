package com.example.demo.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardAtt {
  int sno, pSno;
  String oriFile, sysFile;

  public BoardAtt(){}
  public BoardAtt(int pSno, String oriFile, String sysFile){
    this.pSno = pSno;
    this.oriFile =oriFile;
    this.sysFile = sysFile;
  }
}
