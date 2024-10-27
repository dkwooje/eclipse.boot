package com.TeamNull.LostArk.LostArk.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.TeamNull.LostArk.LostArk.DataNotFoundException;
import com.TeamNull.LostArk.LostArk.answer.Answer;
import com.TeamNull.LostArk.LostArk.user.SiteUser;
import jakarta.persistence.criteria.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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
    public Page<Question> getList(int page, String kw){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10,Sort.by(sorts));
       // Specification<Question> spec = this.search(kw);
       //  return this.questionRepository.findAll(spec,pageable);
        return this.questionRepository.findAllByKeyword(kw,pageable);
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

    public void delete(Question question){
        this.questionRepository.delete(question);
    }

    public void vote(Question question, SiteUser siteUser){
        question.getVoter().add(siteUser);
        this.questionRepository.save(question);
    }


    //sql문
    private Specification<Question> search(String kw){
        return new Specification<>() {
          private static final long serialVersionUID = 1L;

          @Override
            public Predicate toPredicate(Root<Question> q, CriteriaQuery<?> query, CriteriaBuilder cb){
              query.distinct(true); //중복된 데이터 제거 select disctinct 걸름
              Join<Question,SiteUser> u1 = q.join("author",JoinType.LEFT);
              Join<Question, Answer> a = q.join("answerList",JoinType.LEFT);
              Join<Answer,SiteUser> u2 = a.join("author", JoinType.LEFT);
              return  cb.or(
                      cb.like(q.get("subject"),"%"+kw+"%"),
                      cb.like(q.get("content"), "%"+kw+"%"),
                      cb.like(u1.get("username"), "%"+kw+"%"),
                      cb.like(a.get("content"),"%"+kw+"%"),
                      cb.like(u2.get("username"), "%"+kw+"%")
              );
          }
        };
    }
}
