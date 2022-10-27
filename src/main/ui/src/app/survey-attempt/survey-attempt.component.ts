import { SurveyService } from './../api/survey.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Answer } from '../data-model/Answer';
import { Survey } from '../data-model/Survey';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
	selector: 'app-survey-attempt',
	templateUrl: './survey-attempt.component.html',
	styleUrls: ['./survey-attempt.component.css']
})
export class SurveyAttemptComponent implements OnInit {
	public survey: Survey = {
		id: 0, 
		title: 'n/a', 
		questionSet: new Set
	};
	public ans: string = ''	

	private passedId: number = 0;
	private selectedAnswers: Set<Answer> = new Set;
	public validSubmission: boolean = false;

	constructor(
		private service: SurveyService,
		private activeRoute: ActivatedRoute,
		private router: Router
	) {}

	ngOnInit(): void {
		this.passedId = this.getUrlParamId();
		this.getSurveyById(this.passedId)
	}

	// Parse URL to get passed survey ID
	public getUrlParamId(): number {
		return Number(this.activeRoute.snapshot.paramMap.get('id'));
	}

	// Return total amount of elements in "questionSet"
	public getQuestionSetSize(): number {
		let count: number = 0;
		for(let i of this.survey.questionSet)
			count++;
		return count;
	}

	// If amt of questions matches amt of answers selected, then valid
	public setValidSubmission(): void {
		this.validSubmission = this.getQuestionSetSize() == this.selectedAnswers.size;
	}

	/*
		Maintains "selectedAnswers" set to only contain
		a single answer from a parent question
	*/
	public addSelectedAnswer(selectedAns: Answer): void {
		for(let thisAns of this.selectedAnswers) {

			// Remove answer from same parent question
			if(thisAns.questionId == selectedAns.questionId) {
				this.selectedAnswers.delete(thisAns);
				break;
			}
			// Exit function if answer exists
			if(thisAns.id == selectedAns.id) {
				return;
			}
		}

		this.selectedAnswers.add(selectedAns);
	}

	// Send PUT request to track data entered for each selected answer
	public submitAttempt(): void {
		for(let ans of this.selectedAnswers)
			this.service.incrementAnswerSelectionCountById(ans.id)

		this.selectedAnswers.clear

		// Navigate to visualization page to view results
		this.router.navigate(['/data-visualization/' + String(this.passedId)]);
	}

	// Return selected answers as string (for debugging)
	public getSelectionsAsString(): string {
		let str = "";
		for(let thisAns of this.selectedAnswers)
			str += String(thisAns.value) + " ";
		return str;
	}

	// Send GET request to back-end
	public getSurveyById(id: number): void {
		this.service.getSurveyById(id).subscribe(
			(response: Survey) => {
				this.survey = response;
			},
			(error: HttpErrorResponse) => {
				alert(error.message);	
			}
		);
	}
}
