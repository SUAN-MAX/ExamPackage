package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.min.edu.dto.AnswerBoardDto;
import com.min.edu.dto.UserDto;
import com.min.edu.model.IBoardService;


@Controller
public class BoardController {
	
	@Autowired
	private IBoardService iBoardservice;
	
	@RequestMapping(value = "/BoardList.do", method = RequestMethod.GET)
	public String home(Model model) {
		List<AnswerBoardDto> selAll = iBoardservice.selectAll();
		model.addAttribute("selAll",selAll);
		
		return "boardList";
	}
	
	@RequestMapping(value = "/multiDel.do", method = RequestMethod.POST)
	public String multiDel(@RequestParam("ch") String[] seq) {
		
		
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", seq);
		
		boolean isc = iBoardservice.delflagBoard(map);
		
		return isc?"redirect:/BoardList.do":"error";
//		return "";
	}
	
	@RequestMapping(value = "/detailBoard.do", method = RequestMethod.GET)
	public String detailBoard(String seq, Model model) {
		AnswerBoardDto detail = iBoardservice.selectDetailBoard(seq);
		model.addAttribute("dto",detail);
		
		return "detailBoard";
	}
	
	@RequestMapping(value ="/delBoard.do", method = RequestMethod.POST)
	public String delBoard(String seq) {
		System.out.println("받아온 detail board의 seq = "+seq);
		boolean isc = iBoardservice.deleteBoardReal(seq);
		System.out.println("삭제 되었을 까요 "+isc);
		
		return isc?"redirect:/BoardList.do":"error";
	}
	
	@RequestMapping(value ="/moveWriteBoard.do", method = RequestMethod.GET)
	public String writeBoard() {
		return "writeBoard";
	}
	
	@RequestMapping(value = "/writeBoard.do", method = RequestMethod.POST)
	public String writeBoard(AnswerBoardDto dto, HttpSession session) {
		UserDto sDto = (UserDto) session.getAttribute("sDto");
		String sId = sDto.getId();
		System.out.println(sId);
		dto.setId(sId);
		boolean isc = iBoardservice.insertBoard(dto);
		System.out.println("글 작성 ?"+isc);

		return isc?"redirect:/BoardList.do":"error";
	}
	
	@RequestMapping(value = "/moveModifyBoard.do", method = RequestMethod.POST)
	public String moveModifyBoard(Model model, String seq) {
		
		AnswerBoardDto detail = iBoardservice.selectDetailBoard(seq);
		model.addAttribute("dto", detail);
		System.out.println("modifyBoard로 이동		"+ detail);
		
		return "modifyBoard";
	}
	
	@RequestMapping(value = "/modifyResult.do", method = RequestMethod.POST)
	public String modifyResult(String seq, String title, String content) {
		
		AnswerBoardDto dto = new AnswerBoardDto();
		
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContent(content);
		
		System.out.println("수정" + dto);
		
		boolean isc = iBoardservice.modifyBoard(dto);
		
		return isc?"redirect:/BoardList.do":"error";
	}
	
	
	@RequestMapping(value = "/moveReplyBoard.do", method = RequestMethod.POST)
	public String moveReplyBoard(Model model, String seq) {
		
		AnswerBoardDto detail = iBoardservice.selectDetailBoard(seq);
		model.addAttribute("dto", detail);
		System.out.println("replyBoard로 이동		"+ detail);
		return "replyBoard";
	}
	
	@RequestMapping(value = "/replyResult.do", method = RequestMethod.POST)
	public String replyResult(Model model, String seq, String title, String content, HttpSession session) {
		AnswerBoardDto dto = new AnswerBoardDto();
		UserDto sDto = (UserDto) session.getAttribute("sDto");
		String sId = sDto.getId();
		dto.setSeq(seq);
		dto.setId(sId);
		dto.setTitle(title);
		dto.setContent(content);
		
		boolean isc = iBoardservice.reply(dto);
		
		return isc?"redirect:/BoardList.do":"error";
	}
	
}
