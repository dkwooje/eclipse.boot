package com.TeamNull.LostArk.LostArk.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.TeamNull.LostArk.LostArk.DataNotFoundException;
import com.TeamNull.LostArk.LostArk.user.SiteUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



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
	/*
		public List<Question> getList(){
			return this.questionRepository.findAll();

		}
	*/
    //getList에 페이징 적용
    public Page<Question> getList(int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10,Sort.by(sorts));
        return this.questionRepository.findAll(pageable);

    }

    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);

        if(question.isPresent()) {
            return question.get();
        }else {
            throw new DataNotFoundException("question you requested not found");
        }
    }
    //질문 등록 메서드
    public void getcreate(String subject,String content, SiteUser user) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        q.setAuthor(user);
        this.questionRepository.save(q);
    }

    //질문 수정 처리 메서드
    public void modify(Question question, String subject, String content) {
        question.setSubject(subject);
        question.setContent(content);
        question.setModifyDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }

}
