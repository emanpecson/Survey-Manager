package com.demo.websurvey.question;

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

@RestController
@RequestMapping("/question")
public class QuestionController {
	private final QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}

	// GET requests

	@GetMapping("/all")
	public ResponseEntity<List<Question>> getAllQuestions() {
		List<Question> questions = questionService.findAllQuestions();
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable("id") Long id) {
		Question question = questionService.findQuestionById(id);
		return new ResponseEntity<>(question, HttpStatus.OK);
	}

	// POST requests

	@PostMapping("/add")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
		Question newQuestion = questionService.addQuestion(question);
		return new ResponseEntity<>(newQuestion, HttpStatus.CREATED);
	}

	// PUT requests

	@PutMapping("/update")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
		Question updateQuestion = questionService.updateQuestion(question);
		return new ResponseEntity<>(updateQuestion, HttpStatus.OK);
	}
	
	// DELETE requests

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteQuestionById(@PathVariable("id") Long id) {
		questionService.deleteQuestionById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
