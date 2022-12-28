package com.starshop.board.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {

	private long no;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private long hit;
	
	// 댓글 개수
	private long replyCnt;
	
	// 첨부 파일 리스트 추가 필요
	private List<BoardAttachVO> attachList; // 게시판 첨부파일들 정보
	
}
