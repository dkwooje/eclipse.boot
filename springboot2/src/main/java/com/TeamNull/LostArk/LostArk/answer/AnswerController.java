package com.TeamNull.LostArk.LostArk.answer;

import java.security.Principal;

import com.TeamNull.LostArk.LostArk.question.Question;
import com.TeamNull.LostArk.LostArk.question.QuestionService;
import com.TeamNull.LostArk.LostArk.user.SiteUser;
import com.TeamNull.LostArk.LostArk.user.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.ui.Model;

import jakarta.validation.Valid;


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


    @PreAuthorize("isAuthenticated()")
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