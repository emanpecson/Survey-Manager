package com.demo.websurvey.question;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Long> {
	void deleteQuestionById(Long id);
	Optional<Question> findQuestionById(Long id);
}
