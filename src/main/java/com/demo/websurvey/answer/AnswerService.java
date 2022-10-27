package com.demo.websurvey.answer;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class AnswerService {
	private final AnswerRepo answerRepo;

	@Autowired
	public AnswerService(AnswerRepo answerRepo) {
		this.answerRepo = answerRepo;
	}

	public List<Answer> findAllAnswers() {
		return answerRepo.findAll();
	}

	public Answer findAnswerById(Long Id) {
		return answerRepo.findAnswerById(Id)
			.orElseThrow(() -> new RuntimeException("Answer by ID " + Id + " was not found"));
	}

	public Answer addAnswer(Answer answer) {
		return answerRepo.saveAndFlush(answer);
	}

	public Answer updateAnswer(Answer answer) {
		return answerRepo.saveAndFlush(answer);
	}

	public void deleteAnswerById(Long Id) {
		answerRepo.deleteAnswerById(Id);
	}
}
