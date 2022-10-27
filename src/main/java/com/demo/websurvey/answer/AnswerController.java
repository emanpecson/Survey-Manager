package com.demo.websurvey.answer;

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
@RequestMapping("/answer")
public class AnswerController {
	private final AnswerService answerService;

	public AnswerController(AnswerService answerService) {
		this.answerService = answerService;
	}

	// GET requests

	@GetMapping("/all")
	public ResponseEntity<List<Answer>> getAllAnswers() {
		List<Answer> answers = answerService.findAllAnswers();
		return new ResponseEntity<>(answers, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Answer> getAnswerById(@PathVariable("id") Long id) {
		Answer answer = answerService.findAnswerById(id);
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}

	// POST requests

	@PostMapping("/add")
	public ResponseEntity<Answer> addAnswer(@RequestBody Answer answer) {
		Answer newAnswer = answerService.addAnswer(answer);
		return new ResponseEntity<>(newAnswer, HttpStatus.CREATED);
	}

	// PUT requests

	@PutMapping("/update/selectionCount/{id}")
	public ResponseEntity<Answer> incrementSelectionCountById(@PathVariable("id") Long id) {
		Answer updateAnswer = answerService.findAnswerById(id);
		updateAnswer.incrementSelectionCount();
		answerService.updateAnswer(updateAnswer);
		return new ResponseEntity<Answer>(updateAnswer, HttpStatus.OK);
	}
	
	// DELETE requests

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAnswerById(@PathVariable("id") Long id) {
		answerService.deleteAnswerById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
