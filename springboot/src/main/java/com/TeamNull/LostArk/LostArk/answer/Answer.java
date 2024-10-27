package com.TeamNull.LostArk.LostArk.answer;

import java.time.LocalDateTime;
import java.util.Set;


import com.TeamNull.LostArk.LostArk.question.Question;
import com.TeamNull.LostArk.LostArk.user.SiteUser;
import jakarta.persistence.*;
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

    @ManyToMany
    Set<SiteUser> voter;

}
