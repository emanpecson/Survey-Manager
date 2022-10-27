package com.demo.websurvey.answer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepo extends JpaRepository<Answer, Long> {
	void deleteAnswerById(Long id);
	Optional<Answer> findAnswerById(Long id);
}
