package com.myste.sbb.answer;

import com.myste.sbb.question.Question;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class AnswerForm {

	
	private String content;
	private Question question;
}
