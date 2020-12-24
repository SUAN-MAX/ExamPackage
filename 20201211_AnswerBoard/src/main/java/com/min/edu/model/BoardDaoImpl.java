package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.AnswerBoardDto;

@Repository
public class BoardDaoImpl implements IBoardDao{

	private final Logger logger =  LoggerFactory.getLogger(this.getClass());
	private String NS = "com.min.edu.model.answerboard.mapper.";
			
	@Autowired
	private SqlSessionTemplate session;
			
			
	@Override
	public List<AnswerBoardDto> selectAll() {
		logger.info("BoardDaoImpl selectAll");
		return session.selectList(NS+"selectAll");
	}


	@Override
	public AnswerBoardDto selectDetailBoard(String seq) {
		logger.info("BoardDaoImpl selectDetailBoard");
		return (AnswerBoardDto)session.selectList(NS+"selectDetailBoard", seq).get(0);
	}


	@Override
	public boolean replyInsert(AnswerBoardDto dto) {
		int cnt = session.insert(NS+"replyInsert", dto);
		return cnt>0?true:false;
	}


	@Override
	public boolean replyUpdate(AnswerBoardDto dto) {
		int cnt = session.update(NS+"replyBoardUp", dto);
		return cnt>0?true:false;
	}


	@Override
	public boolean modifyBoard(AnswerBoardDto dto) {
		int cnt = session.update(NS+"modifyBoard", dto);
		return cnt>0?true:false;
	}


	@Override
	public boolean delflagBoard(Map<String, String[]> map) {
		int cnt = session.update(NS+"delflagBoard", map);
		return cnt>0?true:false;
	}


	@Override
	public boolean insertBoard(AnswerBoardDto dto) {
		int cnt = session.insert(NS+"insertBoard", dto);
		return cnt>0?true:false;
	}


	@Override
	public boolean deleteBoardReal(String seq) {
		logger.info("BoardDaoImpl deleteBoardReal");
		int cnt = session.delete(NS+"deleteBoardReal", seq);
		return cnt>0?true:false;
	}
}
