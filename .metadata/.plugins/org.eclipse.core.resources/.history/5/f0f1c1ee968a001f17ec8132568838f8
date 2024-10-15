package com.myste.sbb.answer;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import com.myste.sbb.question.Question;
import com.myste.sbb.question.QuestionRepository;
import com.myste.sbb.question.QuestionService;
import com.myste.sbb.user.SiteUser;
import com.myste.sbb.user.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@Controller
public class AnswerController {
	private final QuestionService questionService;
	private final AnswerService answerService;
	private final UserService userService;
	
	public AnswerController(QuestionService questionService, AnswerService answerService, UserService userService) {
		super();
		this.questionService = questionService;
		this.answerService = answerService;
		this.userService = userService;
	}


	@PostMapping("/Create/{id}")
	public String createAnswer(Model model,
			@PathVariable("id") Integer id,
			@Valid AnswerForm answerForm,
			BindingResult bindingResult,
			Principal principal) {
		Question question = this.questionService.getQuestion(id);
		SiteUser siteUser = this.userService.getUser(principal.getName());
		if(bindingResult.hasErrors()) {
			model.addAttribute("question",question);
			return "question_form";
		}
		this.answerService.create(question, answerForm.getContent(), siteUser);
		return String.format("redirect:/question/detail/%s", id);
	}
}