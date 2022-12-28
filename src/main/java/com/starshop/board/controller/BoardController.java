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

	// service�� �̿��ؼ� dbó��
	@Autowired
	@Qualifier("boardServiceImpl")
	private BoardService service;
	
	// �Խ��� ����Ʈ
	@GetMapping("/list.do")
	public String list(PageObject pageObject, Model model) throws Exception {
		
		log.info("�Խ��� ����Ʈ --------");
		
		// DB���� ������ list ������
		model.addAttribute("list", service.list(pageObject));
		// pageObject ������
		model.addAttribute("pageObject", pageObject);
		
		return "board/list";
	}
	
	// �Խ��� ����
	@GetMapping("/view.do")
	public String view(PageObject pageObject, long no, int inc, Model model) throws Exception {
		
		log.info("�Խ��� �� ���� --------");
		
		model.addAttribute("vo", service.view(no, inc));
		
		return "board/view";
	}
	
	// �Խ��� �� ��� ��
	@GetMapping("/write.do")
	public String writeForm(int perPageNum) throws Exception {
		
		log.info("�Խ��� �� ��� �� --------");
		
		return "board/write";
	}
	
	// �Խ��� �� ��� ó��
	@PostMapping("/write.do")
	public String write(BoardVO vo, int perPageNum) throws Exception {
		
		log.info("�Խ��� �� ��� ó�� --------");
		
		service.write(vo);
		
		return "redirect:list.do?perPageNum=" + perPageNum;
	}
	
	// �Խ��� �� ���� ��
	@GetMapping("/update.do")
	public String updateForm(long no, Model model) throws Exception {
		
		log.info("�Խ��� �� ���� �� --------");
		
		model.addAttribute("no", service.view(no, 0));
		
		return "board/update";
	}
	
	// �Խ��� �� ���� ó��
	@PostMapping("/update.do")
	public String update(PageObject pageObject, BoardVO vo) throws Exception {
		
		log.info("�Խ��� �� ���� ó�� --------");
		
		int result = service.update(vo);
		
		if(result == 1) log.info("�Խ��� ���� �Ϸ�");
		else log.info("�Խ��� ���� ���� - �Խ��� �� ��ȣ�� Ȯ���� �ּ���.");
		
		return "redirect:board/view.do?no=" + vo.getNo()
				+ "&inc=0"
				+ "&key=" + pageObject.getKey()
				+ "&word=" + pageObject.getWord();
	}
	
	// �Խ��� �� ����
	@GetMapping("/delete.do")
	public String delete(long no, int perPageNum) throws Exception {
		
		log.info("�Խ��� �� ���� --------");
		
		int result = service.delete(no);
		
		if(result == 1) log.info("�Խ��� ���� �Ϸ�");
		else log.info("�Խ��� ���� ���� - �Խ��� �� ��ȣ�� Ȯ���� �ּ���.");
		
		return "redirect:list.do?=" + perPageNum;
	}
}
