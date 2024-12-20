
package com.myste.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myste.sbb.answer.AnswerRepository;
import com.myste.sbb.question.QuestionRepository;
import com.myste.sbb.question.QuestionService;

import jakarta.transaction.Transactional;

@SpringBootTest
class SbbApplicationTests {


private QuestionService questionService;
	
@Autowired
public SbbApplicationTests(QuestionService  questionService ) {
	super();
		this.questionService = questionService;
}


@Test
void testjpa() {
	for(int i = 1; i<=300; i++) {
		String subject = String.format("테스트 데이터입니다: [%03d]", i);
		questionService.getcreate(subject, "내용 없음");
	}
}

}



/*
@SpringBootTest
class SbbApplicationTests {

	
	
	private QuestionRepository  questionRepository;
	private AnswerRepository answerRepository;
	
	
	@Autowired
	public SbbApplicationTests(QuestionRepository  questionRepository,
								AnswerRepository answerRepository) {
		super();
		this.questionRepository =questionRepository;
		this.answerRepository = answerRepository;
	}
	
	
*/
	/*
    @BeforeEach
    void setUp() {
        // 테스트에 사용할 기본 데이터 준비
        Question q = new Question();
        q.setSubject("Sbb가 무엇입니까?");
        q.setContent("Sbb에 대해서 알려주십");
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);
    }
    */
	
	/*
	@Test
	void testJpa() {
		List<Question> all = this.questionRepository.findAll(); //select * from question;
		assertEquals(2, all.size());
		
		Question q = all.get(0);
		assertEquals("Sbb가 무엇입니까?", q.getSubject());
		
	}
	*/
	/*
	@Test
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(1);
		if(oq.isPresent()) {
			Question q = oq.get();
			assertEquals("sbb가 무엇입니까?", q.getSubject());
		}
	}
	*/
	
	/*
	@Test
	void testJpa() {
		Question q1 = this.questionRepository.findBySubject("sbb가 무엇입니까?");
		assertEquals(1,q1.getId());
		Question q2 = this.questionRepository.findByContent("Sbb에 대해서 알려주십쇼");
		assertEquals(1,q2.getId());
		Question q3 = this.questionRepository.findBySubjectAndContent("sbb가 무엇입니까?","Sbb에 대해서 알려주십쇼");
		assertEquals(1,q3.getId());
		Question q4 = this.questionRepository.findBySubjectOrContent("sbb가 무엇입니까?","Sbb에 대해서 알려주십쇼");
		assertEquals(1,q4.getId());
	}
	
	@Test
	void testJpa2() {
		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
		Question q = qList.get(0);
		assertEquals("sbb가 무엇입니까?", q.getSubject());
		qList = this.questionRepository.findBycontentLike("Sbb%");
		q = qList.get(0);
		assertEquals("Sbb에 대해서 알려주십쇼",q.getContent());
		
	}
	*/
	/*
	@Test
	void testJpa1() {
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		q.setSubject("수정된 제목");
		this.questionRepository.save(q);
	}
	
	

	*/
	/*
	@Test
	void testJpa() {
		assertEquals(2,this.questionRepository.count());
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		this.questionRepository.delete(q);
		assertEquals(1,this.questionRepository.count());
	}
	*/
	
	/*
	@Test
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		Answer a = new Answer();
		a.setContent("네 자동으로 생성됩니다");
		a.setQuestion(q);
		a.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a);

	}
	*/
	/*
	@Test
	void testJpa() {
		Optional<Answer> oa = this.answerRepository.findById(1);
		assertTrue(oa.isPresent());
		Answer a = oa.get();
		assertEquals(2, a.getQuestion().getId());
	}
	*/
	
	/*
	@Test
	@Transactional
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		List<Answer> answerList = q.getAnswerList();
		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	}
	
	*/
	
