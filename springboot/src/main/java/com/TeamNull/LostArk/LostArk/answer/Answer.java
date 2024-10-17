package com.TeamNull.LostArk.LostArk.answer;

import java.time.LocalDateTime;


import com.TeamNull.LostArk.LostArk.question.Question;
import com.TeamNull.LostArk.LostArk.user.SiteUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Answer {

    @ManyToOne
    private SiteUser author;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition="TEXT")
    private String content;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @ManyToOne
    private Question question;

}
