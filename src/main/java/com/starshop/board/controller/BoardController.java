package com.starshop.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starshop.board.service.BoardService;
import com.starshop.board.vo.BoardVO;
import com.webjjang.util.PageObject;

import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {

	// service를 이용해서 db처리
	@Autowired
	@Qualifier("boardServiceImpl")
	private BoardService service;
	
	// 게시판 리스트
	@GetMapping("/list.do")
	public String list(PageObject pageObject, Model model) throws Exception {
		
		log.info("게시판 리스트 --------");
		
		// DB에서 가져온 list 데이터
		model.addAttribute("list", service.list(pageObject));
		// pageObject 데이터
		model.addAttribute("pageObject", pageObject);
		
		return "board/list";
	}
	
	// 게시판 보기
	@GetMapping("/view.do")
	public String view(PageObject pageObject, long no, int inc, Model model) throws Exception {
		
		log.info("게시판 글 보기 --------");
		
		model.addAttribute("vo", service.view(no, inc));
		
		return "board/view";
	}
	
	// 게시판 글 등록 폼
	@GetMapping("/write.do")
	public String writeForm(int perPageNum) throws Exception {
		
		log.info("게시판 글 등록 폼 --------");
		
		return "board/write";
	}
	
	// 게시판 글 등록 처리
	@PostMapping("/write.do")
	public String write(BoardVO vo, int perPageNum) throws Exception {
		
		log.info("게시판 글 등록 처리 --------");
		
		service.write(vo);
		
		return "redirect:list.do?perPageNum=" + perPageNum;
	}
	
	// 게시판 글 수정 폼
	@GetMapping("/update.do")
	public String updateForm(long no, Model model) throws Exception {
		
		log.info("게시판 글 수정 폼 --------");
		
		model.addAttribute("no", service.view(no, 0));
		
		return "board/update";
	}
	
	// 게시판 글 수정 처리
	@PostMapping("/update.do")
	public String update(PageObject pageObject, BoardVO vo) throws Exception {
		
		log.info("게시판 글 수정 처리 --------");
		
		int result = service.update(vo);
		
		if(result == 1) log.info("게시판 수정 완료");
		else log.info("게시판 수정 실패 - 게시판 글 번호를 확인해 주세요.");
		
		return "redirect:board/view.do?no=" + vo.getNo()
				+ "&inc=0"
				+ "&key=" + pageObject.getKey()
				+ "&word=" + pageObject.getWord();
	}
	
	// 게시판 글 삭제
	@GetMapping("/delete.do")
	public String delete(long no, int perPageNum) throws Exception {
		
		log.info("게시판 글 삭제 --------");
		
		int result = service.delete(no);
		
		if(result == 1) log.info("게시판 삭제 완료");
		else log.info("게시판 삭제 실패 - 게시판 글 번호를 확인해 주세요.");
		
		return "redirect:list.do?=" + perPageNum;
	}
}
