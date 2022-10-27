package com.demo.websurvey.question;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class QuestionService {
	private final QuestionRepo questionRepo;

	@Autowired
	public QuestionService(QuestionRepo questionRepo) {
		this.questionRepo = questionRepo;
	}

	public List<Question> findAllQuestions() {
		return questionRepo.findAll();
	}

	public Question findQuestionById(Long id) {
		return questionRepo.findQuestionById(id)
			.orElseThrow(() -> new RuntimeException("Question by ID " + id + " was not found"));
	}

	public Question addQuestion(Question question) {
		return questionRepo.saveAndFlush(question);
	}

	public Question updateQuestion(Question question) {
		return questionRepo.saveAndFlush(question);
	}

	public void deleteQuestionById(Long id) {
		questionRepo.deleteQuestionById(id);
	}
}
