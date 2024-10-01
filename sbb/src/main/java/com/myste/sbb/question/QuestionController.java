package com.myste.sbb.question;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
	@GetMapping("/list")
	@ResponseBody
	public String list() {
		return "질문 목록에 대한 응답입니다";
	}
	
	
	
	

}
