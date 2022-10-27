package com.demo.websurvey.survey;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.websurvey.answer.AnswerService;
import com.demo.websurvey.question.QuestionService;

@RestController
@RequestMapping("/survey")
public class SurveyController {
	private final SurveyService surveyService;
	private final QuestionService questionService;
	private final AnswerService answerService;

	public SurveyController(
		SurveyService surveyService,
		QuestionService questionService,
		AnswerService answerService
	) {
		this.surveyService = surveyService;
		this.questionService = questionService;
		this.answerService = answerService;
	}

	// GET requests

	@GetMapping("/all")
	public ResponseEntity<List<Survey>> getAllSurveys() {
		List<Survey> surveys = surveyService.findAllSurveys();
		return new ResponseEntity<>(surveys, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Survey> getSurveyById(@PathVariable("id") Long id) {
		Survey survey = surveyService.findSurveyById(id);
		return new ResponseEntity<>(survey, HttpStatus.OK);
	}

	// POST requests

	@PostMapping("/add")
	public ResponseEntity<Survey> addSurvey(@RequestBody Survey survey) {
		for(var question : survey.getQuestionSet()) {

			question.setSurvey(survey);
			questionService.addQuestion(question);

			for(var answer : question.getAnswerSet()) {
				answer.setQuestion(question);
				answerService.addAnswer(answer);
			}
		}

		surveyService.addSurvey(survey); 
		return new ResponseEntity<>(survey, HttpStatus.CREATED);
	}

	// PUT requests

	@PutMapping("/update")
	public ResponseEntity<Survey> updateSurvey(@RequestBody Survey survey) {
		Survey updateSurvey = surveyService.updateSurvey(survey);
		return new ResponseEntity<>(updateSurvey, HttpStatus.OK);
	}

	// DELETE requests
	
	@DeleteMapping("/delete/{id}")
	public void deleteSurveyById(@PathVariable("id") Long id) {
		surveyService.deleteSurveyById(id);
	}
}
