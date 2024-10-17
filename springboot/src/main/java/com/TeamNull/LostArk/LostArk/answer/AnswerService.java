package com.TeamNull.LostArk.LostArk.answer;

import java.time.LocalDateTime;

import com.TeamNull.LostArk.LostArk.question.Question;
import com.TeamNull.LostArk.LostArk.user.SiteUser;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(Question question, String content, SiteUser author) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setAuthor(author);
        this.answerRepository.save(answer);
    }

}
