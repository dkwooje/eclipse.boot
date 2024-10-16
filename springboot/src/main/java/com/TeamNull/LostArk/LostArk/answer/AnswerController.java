package com.TeamNull.LostArk.LostArk.answer;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;
/*
    @PostMapping("/Create/{id}")
    @PreAuthorize("isAuthenticated()")
    public String createAnswer(Model model){

    }

 */

}
