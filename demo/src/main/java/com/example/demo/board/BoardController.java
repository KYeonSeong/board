package com.example.demo.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BoardController {
  @Autowired
  BoardDao dao;

  @RequestMapping("/brdList")
  public ModelAndView brdList(Page page){
    ModelAndView mv = new ModelAndView();

    List<BoardVo> list = dao.select(page);
    page = dao.getPage();
    mv.addObject("list", list);
    mv.addObject("page", page);
    mv.setViewName("/board/list");

    return mv;
  }

  @RequestMapping("/brdView")
  public ModelAndView view(int sno, Page page){
    ModelAndView mv = new ModelAndView();
    BoardVo vo = dao.view(sno);

    mv.addObject("vo", vo);
    mv.addObject("page", page);
    mv.setViewName("/board/view");

    return mv;
  }

  @RequestMapping("/brdRegister")
  public ModelAndView register(Page page){
    ModelAndView mv = new ModelAndView();

    mv.addObject("page", page);
    mv.setViewName("/board/register");

    return mv;
  }

  @RequestMapping(value="/brdRegisterR", method=RequestMethod.POST)
  public String registerR(@RequestParam("attFile") List<MultipartFile> mul, @ModelAttribute BoardVo vo, @ModelAttribute Page page){
    String msg = "";
    msg = dao.registerR(vo, mul);

    return msg;
  }
  
  @RequestMapping("/brdModify")
  public ModelAndView modify(int sno, Page page){
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/board/modify");
    BoardVo vo = dao.view(sno);
    mv.addObject("vo", vo);
    mv.addObject("page", page);
    return mv;
  }

  @RequestMapping("/brdModifyR")
  public String modifyR(@RequestParam("attFile") List<MultipartFile> mul, @ModelAttribute BoardVo vo, @ModelAttribute Page page){
    String msg = "";
    msg = dao.modifyR(vo, mul);
    return msg;
  }

  @RequestMapping("/brdDeleteR")
  public String deleteR(BoardVo vo){
    String msg = "";
    msg = dao.deleteR(vo);
    return msg;
  }

  @RequestMapping("/brdRepl")
  public ModelAndView repl(Page page, BoardVo vo){
    ModelAndView mv = new ModelAndView();
    mv.addObject("vo", vo);
    mv.addObject("page", page);
    mv.setViewName("/board/repl");
    return mv;
  }

  @RequestMapping(value="/brdReplR", method=RequestMethod.POST)
  public String replR(@RequestParam("attFile") List<MultipartFile> mul, @ModelAttribute BoardVo vo, @ModelAttribute Page page){
    String msg = "";
    msg = dao.replR(vo, mul);
    return msg;
  }
}
  

