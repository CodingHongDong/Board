package com.starshop.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.starshop.board.mapper.BoardMapper;
import com.starshop.board.vo.BoardVO;
import com.webjjang.util.PageObject;

@Service
@Qualifier("boardServiceImpl")
public class BoardServiceImpl implements BoardService {

	// mapper�� �̿��ؼ� DB ó�� - �ڵ� DI
	@Autowired
	private BoardMapper mapper;
	
	
	@Override
	public List<BoardVO> list(PageObject pageObject) throws Exception {
		// ��ü �������� ������ �������� ó���� �� �ؾ��Ѵ�.
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		return mapper.list(pageObject);
	}

	@Override
	public BoardVO view(long no, int inc) throws Exception {
		
		if(inc == 1) mapper.increase(no);
		
		return mapper.view(no);
	}

	@Override
	public int write(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return mapper.write(vo);
	}

	@Override
	public int update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}

	@Override
	public int delete(long no) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(no);
	}

}
