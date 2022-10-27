import { Visual } from './../data-model/Visual';
import { Survey } from './../data-model/Survey';
import { SurveyService } from './../api/survey.service';
import { Component, OnInit } from "@angular/core";
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Component({
	selector: 'app-data-visualization',
	templateUrl: './data-visualization.component.html',
	styleUrls: ['./data-visualization.component.css']
})
export class DataVisualizationComponent implements OnInit {
	// Store survey data into object variable
	public survey: Survey = {
		id: 0, 
		title: 'n/a', 
		questionSet: new Set
	};
	private passedId: number = 0;	// Expecting ID from url
	public visuals: Visual[] = [];	// Each question can be translated into visual data

	constructor(
		private service: SurveyService,
		private activeRoute: ActivatedRoute
	) {}

	ngOnInit(): void {
		this.passedId = this.getUrlParamId();
		this.getSurveyById(this.passedId);
	}

	private getUrlParamId(): number {
		return Number(this.activeRoute.snapshot.paramMap.get('id'));
	}

	/*
		Translates each question into visual data so that it can be
		neatly displayed to the user as a simple (and intuitive) chart
	*/
	private defineVisuals(): void {
		for(let question of this.survey.questionSet) {

			// Define a visual type for this question
			let visual: Visual = {
				question: question.value,
				options: {
					type: 'pie',
					toolbar: {
						show: true
					}
				},
				labels: [],
				series: []
			}

			// Populate labels as this question's answer choices
			// Populate series as the count of selections of each answer
			for(let answer of question.answerSet) {
				visual.labels.push(answer.value);
				visual.series.push(answer.selectionCount);
			}

			this.visuals.push(visual);
		}
	}

	// Send GET request to back-end
	private getSurveyById(id: number): void {
		this.service.getSurveyById(id).subscribe(
			(response: Survey) => {
				this.survey = response;		// Store survey
				this.defineVisuals();		// Define visuals based on this survey
			},
			(error: HttpErrorResponse) => {
				alert(error.message);
			}
		);
	}
}