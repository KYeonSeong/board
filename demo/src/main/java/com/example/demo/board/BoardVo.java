package com.example.demo.board;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVo {
  int sno, grp, deep, seq, hit;
  int attCnt, pSno;
  String id, nal, subject, doc;

  List<BoardAtt> attFiles;
  String[] delFile;

  public BoardVo(){}
  public BoardVo(int sno, String subject){
    this.sno = sno;
    this.subject = subject;
  }
}
