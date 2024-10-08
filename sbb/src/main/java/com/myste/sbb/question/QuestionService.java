package com.myste.sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.myste.sbb.DataNotFoundException;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor //롬복 쓰는 경우
public class QuestionService {

		private final QuestionRepository questionRepository;
	/*
		public QuestionService(QuestionRepository questionRepository) {    
			super();
			this.questionRepository = questionRepository;
		}
	*/	
		
		public List<Question> getList(){
			return this.questionRepository.findAll();
				
		}

		public Question getQuestion(Integer id) {
			Optional<Question> question = this.questionRepository.findById(id);
			
			if(question.isPresent()) {
				return question.get();
			}else {
				throw new DataNotFoundException("question you requested not found");
			}
		}
		
		public void getcreate(String subject,String content) {
			Question q = new Question();
			q.setSubject(subject);
			q.setContent(content);
			q.setCreateDate(LocalDateTime.now());
			this.questionRepository.save(q);
		}
}
