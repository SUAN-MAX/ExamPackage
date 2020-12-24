package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.min.edu.dto.UserDto;
import com.min.edu.model.IUserService;

@Controller
@SessionAttributes("sDto")
public class UserController {

	@Autowired
	private IUserService iUserService;
	
	@RequestMapping(value = "/signIn.do", method = RequestMethod.GET)
	private String signIn() {
		System.out.println("로그인 폼으로 이동");
		return "SignIn";
	}
	
	@RequestMapping(value ="/login.do", method = RequestMethod.POST)
	private String login(String id, String pw, Model model) {
		System.out.println("login.do 작동");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", pw);
		
		UserDto sDto = iUserService.loginMember(map);
		model.addAttribute("sDto",sDto);
		return sDto==null?"error":"redirect:BoardList.do";
	}
	
	@RequestMapping(value ="/signUp.do", method = RequestMethod.GET)
	private String signUp() {
		return "SignUp";
	}
	
	@RequestMapping(value = "/SignUpResult.do", method = RequestMethod.POST)
	private String SignUpResult(String id, String pw, String name) {
		UserDto dto = new UserDto(id, pw, name);
		System.out.println(dto);
		
		return iUserService.signUpMember(dto)?"redirect:signIn.do":"error";
	}
	
	@RequestMapping(value = "/IdChkForm.do")
	private String idChkForm() {
		return "idChk";
	}
	
	@RequestMapping(value = "/idCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> idCheck(String id) {
		System.out.println("idCheck 실행 ---------");
		Map<String, String> map = new HashMap<String, String>();
		boolean isc = iUserService.idDuplicateCheck(id);
		System.out.println(isc);
		map.put("isc", String.valueOf(isc));
		return map;
	}
	
}
