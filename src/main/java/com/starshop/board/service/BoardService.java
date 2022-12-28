package com.starshop.board.service;

import java.util.List;

import com.starshop.board.vo.BoardVO;
import com.webjjang.util.PageObject;

public interface BoardService {

	// �Խ��� ����Ʈ
	public List<BoardVO> list(PageObject pageObject) throws Exception;

	// �Խ��� �� ����
	public BoardVO view(long no, int inc) throws Exception;
		
	// �Խ��� �� ���
	public int write(BoardVO vo) throws Exception;
	
	// �Խ��� �� ����
	public int update(BoardVO vo) throws Exception;
	
	// �Խ��� �� ����
	public int delete(long no) throws Exception;
}
