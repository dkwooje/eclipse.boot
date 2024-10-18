package com.TeamNull.LostArk.LostArk.question;

import java.time.LocalDateTime;
import java.util.List;


import com.TeamNull.LostArk.LostArk.answer.Answer;
import com.TeamNull.LostArk.LostArk.user.SiteUser;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Question {

    @ManyToOne
    private SiteUser author;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(length=200)
    private String subject;

    @Column(columnDefinition="TEXT")
    private String content;


    private LocalDateTime modifyDate;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE )
    private List<Answer> answerList;




}