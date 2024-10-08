package com.myste.sbb.answer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

import com.myste.sbb.question.Question;
import com.myste.sbb.question.QuestionRepository;
import com.myste.sbb.question.QuestionService;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@Controller
public class AnswerController {
	private final QuestionService questionService;
	private final AnswerService answerService;
	
	public AnswerController(QuestionService questionService, AnswerService answerService) {
		super();
		this.questionService = questionService;
		this.answerService = answerService;
	}


	@PostMapping("/Create/{id}")
	public String createAnswer(Model model,
			@PathVariable("id") Integer id,
			@RequestParam(value="content") String content) {
	
		Question question = this.questionService.getQuestion(id);
		this.answerService.create(question, content);
		return String.format("redirect:/question/detail/%s", id);
	}
}