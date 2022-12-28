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
	
	// ��� ����
	private long replyCnt;
	
	// ÷�� ���� ����Ʈ �߰� �ʿ�
	private List<BoardAttachVO> attachList; // �Խ��� ÷�����ϵ� ����
	
}
