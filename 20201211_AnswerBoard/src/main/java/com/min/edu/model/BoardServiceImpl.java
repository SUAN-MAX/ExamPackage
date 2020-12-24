package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.dto.AnswerBoardDto;

@Service
public class BoardServiceImpl implements IBoardService {

	private final Logger logger =  LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IBoardDao dao;
	
	@Override
	public List<AnswerBoardDto> selectAll() {
		logger.info("BoardServiceImpl selectAll");
		return dao.selectAll();
	}

	@Override
	public AnswerBoardDto selectDetailBoard(String seq) {
		logger.info("BoardServiceImpl selectDetailBoard");
		return dao.selectDetailBoard(seq);
	}

	@Transactional
	@Override
	public boolean reply(AnswerBoardDto dto) {
		logger.info("BoardServiceImpl reply");
		boolean isc1 = dao.replyUpdate(dto);
		boolean isc2 = dao.replyInsert(dto);
		return (isc1 || isc2)?true:false;
	}

	@Override
	public boolean modifyBoard(AnswerBoardDto dto) {
		logger.info("BoardServiceImpl modifyBoard");
		return dao.modifyBoard(dto);
	}

	@Override
	public boolean delflagBoard(Map<String, String[]> map) {
		logger.info("BoardServiceImpl delflagBoard");
		return dao.delflagBoard(map);
	}

	@Override
	public boolean insertBoard(AnswerBoardDto dto) {
		logger.info("BoardServiceImpl insertBoard");
		return dao.insertBoard(dto);
	}

	@Override
	public boolean deleteBoardReal(String seq) {
		return dao.deleteBoardReal(seq);
	}

}
