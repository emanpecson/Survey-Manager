import { SurveyService } from './../api/survey.service';
import { Component } from '@angular/core';
import { FormGroup, Validators, FormArray, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
	selector: 'app-survey-template',
	templateUrl: './survey-template.component.html',
	styleUrls: ['./survey-template.component.css']
})
export class SurveyTemplateComponent {
	// Template to store survey input using dynamic arrays
	public surveyForm = new FormGroup({
		title: 			new FormControl('', Validators.required),
		questionSet: 	new FormArray([ new FormGroup({
			value:		new FormControl('', Validators.required),
			answerSet:	new FormArray([ new FormGroup({
				value:	new FormControl('', Validators.required)
			}) ])
		}) ])
	});

	constructor(
		private service: SurveyService,
		private router: Router
	) {}

	public getTitle() {
		return this.surveyForm.get('title')?.value;
	}

	public getValue(form: FormGroup) {
		return form.get('value')?.value;
	}

	public getQuestions(): FormArray {
		return this.surveyForm.get('questionSet') as FormArray;
	}

	public addQuestion() {
		this.getQuestions().push(
			new FormGroup({
				value: 	new FormControl('', Validators.required),
				answerSet:	new FormArray([ new FormGroup({
					value:	new FormControl('', Validators.required)
				}) ])
			})
		);
	}

	public deleteQuestion(idx: number) {
		this.getQuestions().removeAt(idx);
	}

	public getAnswers(questionForm: FormGroup): FormArray {
		return questionForm.get('answerSet') as FormArray;
	}

	public addAnswer(questionForm: FormGroup) {
		this.getAnswers(questionForm).push(
			new FormGroup({
				value:	new FormControl('', Validators.required)
			})
		)
	}

	public deleteAnswer(questionForm: FormGroup, idx: number) {
		this.getAnswers(questionForm).removeAt(idx);
	}

	/*
		Create survey by setting survey form to a JSON type and sending
		a POST request to back-end
	*/
	public createSurvey(form: FormGroup): void {
		let survey: JSON = JSON.parse(JSON.stringify(form.getRawValue()));
		this.service.addSurvey(survey);

		this.router.navigate(['/']);
		setTimeout(()=>{ window.location.reload(); }, 100);
	}

	// Return survey form as string (for debugging)
	public getRawSurveyForm(form: FormGroup) {
		return JSON.stringify(form.getRawValue());
	}
}
