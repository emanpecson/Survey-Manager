package com.demo.websurvey.survey;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SurveyService {
	private final SurveyRepo surveyRepo;

	@Autowired
	public SurveyService(SurveyRepo surveyRepo) {
		this.surveyRepo = surveyRepo;
	}

	public List<Survey> findAllSurveys() {
		return surveyRepo.findAll();
	}

	public Survey findSurveyById(Long id) {
		return surveyRepo.findSurveyById(id)
			.orElseThrow(() -> new RuntimeException("Survey by ID " + id + " was not found"));
	}

	public Survey addSurvey(Survey survey) {
		return surveyRepo.saveAndFlush(survey);
	}

	public Survey updateSurvey(Survey survey) {
		return surveyRepo.saveAndFlush(survey);
	}

	public void deleteSurveyById(Long id) {
		surveyRepo.deleteSurveyById(id);
	}
}
