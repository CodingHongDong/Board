package com.starshop.board.mapper;

import java.util.List;

import com.starshop.board.vo.BoardVO;
import com.webjjang.util.PageObject;

public interface BoardMapper {

	// �Խ��� ����Ʈ
	public List<BoardVO> list(PageObject pageObject) throws Exception;

	// �Խñ� �� ����
	public long getTotalRow(PageObject pageObject) throws Exception;
	
	// �Խ��� �� ����
	public BoardVO view(long no) throws Exception;
	
	// ��ȸ�� 1 ����
	public int increase(long no) throws Exception;
	
	// �Խ��� �� ���
	public int write(BoardVO vo) throws Exception;
	
	// �Խ��� �� ����
	public int update(BoardVO vo) throws Exception;
	
	// �Խ��� �� ����
	public int delete(long no) throws Exception;
}
