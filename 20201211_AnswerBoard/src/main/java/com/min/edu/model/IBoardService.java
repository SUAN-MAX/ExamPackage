package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.AnswerBoardDto;

public interface IBoardService {

	public List<AnswerBoardDto> selectAll();
	
	public AnswerBoardDto selectDetailBoard(String seq);

	public boolean reply(AnswerBoardDto dto);

	public boolean modifyBoard(AnswerBoardDto dto);

	public boolean delflagBoard(Map<String, String[]> map);

	public boolean insertBoard(AnswerBoardDto dto);

	public boolean deleteBoardReal(String seq);
	
}
