package com.example.demo.board;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.mybatis.MybaFactory;

@Component
public class BoardDao {
  SqlSession session;
  Page page;
  String uploadPath = "C:\\Users\\io098\\Desktop\\work-newJava\\demo\\src\\main\\resources\\static\\upload";

  public BoardDao(){
    session = MybaFactory.getFactory().openSession();
  }

  public BoardVo view(int sno){
    // 조회수 증가
    session.update("board.hitUpdate", sno);
    session.commit();
  
    // sno에 해당하는 본문글 1건
    BoardVo vo = session.selectOne("board.view", sno);

    // 첨부 파일 목록
    List<BoardAtt> attFiles = session.selectList("board.attFiles", sno);
    vo.setAttFiles(attFiles);
    return vo;
  }

  public List<BoardVo> selectAll() {
    List<BoardVo> list = session.selectList("board.all");
    return list;
  }

  public List<BoardVo> select(Page page) {
    List<BoardVo> list = null;
    int totSize = getTotSize(page);
    page.setTotSize(totSize);
    page.pageCompute();
    this.page = page;

    list = session.selectList("board.select", page);

    return list;
  }

  public int getTotSize(Page page){
    int totSize = session.selectOne("board.totSize", page);
    return totSize;
  }

  public Page getPage(){
    return this.page;
  }

  public String registerR(BoardVo vo, List<MultipartFile> mul){
    String msg = "";
    int cnt = 0;
    List<BoardAtt> attFiles = new ArrayList<>(); 

    try{
      int sno = session.selectOne("board.getSerial", "i");
      vo.setSno(sno);
      cnt = session.insert("board.register", vo);
      if(cnt < 1){
        msg = "저장 중 오류가 발생했어요";
        throw new Exception(msg);
      }

      for(MultipartFile f : mul){
        if (f.getOriginalFilename().equals("")) continue;
        UUID uuid = UUID.randomUUID();
        String sysFile = String.format("%s-%s", uuid, f.getOriginalFilename());
        File saveFile = new File(uploadPath + sysFile);
        f.transferTo(saveFile);
        BoardAtt att = new BoardAtt(sno, f.getOriginalFilename(), sysFile);
        attFiles.add(att);
      }
      
      if(attFiles.size() > 0){
        cnt = session.insert("board.attRegister", attFiles);
        if(cnt != attFiles.size()){
          msg = "첨부 파일 저장 중 오류가 발생했어요";
          throw new Exception(msg);
        }
      }
      session.commit();
    }catch(Exception ex){
      msg = ex.getMessage();
      session.rollback();
      for(BoardAtt att : attFiles){
        File delFile = new File(uploadPath + att.getSysFile());
        if(delFile.exists()) delFile.delete();
      }
    }
    
    System.out.println(msg);
    return msg;
  }

  public String modifyR(BoardVo vo, List<MultipartFile> mul){
    String msg = "";
    int cnt = 0;
    List<BoardAtt> attFiles = new ArrayList<>();

    try{
      cnt = session.update("board.update", vo);
      if(cnt < 1){
        msg = "수정 중 오류가 발생했어요";
        throw new Exception(msg);
      }

      for(MultipartFile f : mul){
        if(f.getOriginalFilename().equals("")) continue;
        UUID uuid = UUID.randomUUID();
        String sysFile = uuid.toString() + "-" + f.getOriginalFilename();
        File saveFile = new File(uploadPath + sysFile);
        f.transferTo(saveFile);
        BoardAtt att = new BoardAtt(vo.getSno(), f.getOriginalFilename(), sysFile);
        attFiles.add(att);
      }

      if(attFiles.size() > 0){
        cnt = session.insert("board.attRegister", attFiles);
        if(cnt != attFiles.size()){
          msg = "첨부 파일 정보 수정 중 오류가 발생했어요";
          throw new Exception(msg);
        }
      }

      if(vo.getDelFile() != null){
        cnt = session.delete("board.deleteAtt", vo.getDelFile());
        if(cnt != vo.getDelFile().length){
          msg = "첨부 파일 정보 삭제 중 오류가 발생했어요";
          throw new Exception(msg);
        }
        for(String f : vo.getDelFile()){
          File delFile = new File(uploadPath + f);
          if(delFile.exists()) delFile.delete();
        }
      }
      session.commit();
    }catch(Exception ex){
      session.rollback();
      for(BoardAtt att : attFiles){
        File f = new File(uploadPath + att.getSysFile());
        if(f.exists()) f.delete();
      }
    }
    return msg;
  }

  public String deleteR(BoardVo vo){
    String msg = "";
    int cnt = 0;
    List<BoardAtt> delFileList = null;
    try{
      cnt = session.selectOne("board.checkRepl", vo);
      if(cnt > 0){
        msg = "댓글이 있어 삭제가 불가해요";
        throw new Exception(msg);
      }

      cnt = session.delete("board.delete", vo.getSno());
      if(cnt < 1){
        msg = "게시글 삭제 중 오류가 발생했어요";
        throw new Exception(msg);
      }

      // 삭제할 파일 목록
      delFileList = session.selectList("board.attFiles", vo.getSno());

      String[] delFile = new String[delFileList.size()];
      for(int i=0; i < delFileList.size(); i++){
        BoardAtt att = delFileList.get(i);
        delFile[i] = att.getSysFile();
      }

      if(delFileList.size() > 0){ //첨부 파일이 있는 경우
        cnt = session.delete("board.deleteAtt", delFile);
        if(cnt != delFile.length){
          msg = "첨부 파일 정보 삭제 중 오류가 발생했어요";
          throw new Exception(msg);
        }

        // 첨부파일 삭제
        for(String f : delFile){
          File file = new File(uploadPath + f);
          if(file.exists()) file.delete();
        }
      }
      session.commit();
    }catch(Exception ex){
      msg = ex.getMessage();
      session.rollback();
    }
    return msg;
  }

  public String replR(BoardVo vo, List<MultipartFile> mul){
    String msg = "";
    int cnt = 0;
    List<BoardAtt> attFiles = new ArrayList<>();
    try{
      // 1. board 댓글 저장
      session.update("board.seqUp", vo);
      session.commit();

      int sno = session.selectOne("board.getSerial", "i");
      vo.setPSno(vo.getSno());
      vo.setSno(sno);
      vo.setSeq(vo.getSeq()+1);
      vo.setDeep(vo.getDeep()+1);
      cnt = session.insert("board.repl", vo);
      if(cnt < 1){
        msg = "댓글 저장 중 오류가 발생했어요";
        throw new Exception(msg);
      }

      // 2. 파일 업로드
      for(MultipartFile f : mul){
        if(f.getOriginalFilename().equals("")) continue;
        UUID uuid = UUID.randomUUID();
        String sysFile = uuid.toString() + "-" + f.getOriginalFilename();
        File saveFile = new File(uploadPath + sysFile);
        f.transferTo(saveFile);
        BoardAtt att = new BoardAtt(sno, f.getOriginalFilename(), sysFile);
        attFiles.add(att);
      }

      // 3. boardAtt 저장
      if(attFiles.size() > 0){
        cnt = session.insert("board.attRegister", attFiles);
        if(cnt != attFiles.size()){
          msg = "첨부파일 저장 중 오류가 발생했어요";
          throw new Exception(msg);
        }
      }
      session.commit();
    }catch(Exception ex){
      session.rollback();
      for(BoardAtt att : attFiles){
        File f = new File(uploadPath + att.getSysFile());
        if(f.exists()) f.delete();
      }
    }
    return msg;
  }
}
