package com.myste.sbb.answer;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

import com.myste.sbb.question.Question;
import com.myste.sbb.question.QuestionRepository;
import com.myste.sbb.question.QuestionService;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;
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
			@Valid AnswerForm answerForm,
			@RequestParam(value="content") String content,
			BindingResult bindingResult) {
	
		Question question = this.questionService.getQuestion(id);
		if(bindingResult.hasErrors()) {
			return "question_form";
		}
		this.answerService.create(question, content);
		return String.format("redirect:/question/detail/%s", id);
	}
}