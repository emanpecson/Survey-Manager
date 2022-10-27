package com.demo.websurvey.survey;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepo extends JpaRepository<Survey, Long> {
	void deleteSurveyById(Long id);
	Optional<Survey> findSurveyById(Long id);
}
