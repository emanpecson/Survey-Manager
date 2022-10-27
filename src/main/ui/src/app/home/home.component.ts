import { SurveyService } from './../api/survey.service';
import { Component, OnInit } from '@angular/core';
import { Survey } from '../data-model/Survey';
import { HttpErrorResponse } from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
import { DeleteSurveyDialog } from '../dialog/delete-survey-dialog';

export interface DialogData {
	title: string;
	id: number;
}

@Component({
	selector: 'app-home',
	templateUrl: './home.component.html',
	styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
	surveys: Survey[] = [];		// Hold all surveys (to be displayed)

	constructor(
		private service: SurveyService,
		public dialog: MatDialog
	) {}

	ngOnInit(): void {
		this.getSurveys();
	}

	// Send GET request to back-end to retrieve all surveys
	public getSurveys(): void {
		this.service.getSurveys().subscribe(
			(response: Survey[]) => {
				this.surveys = response;
			},
			(error: HttpErrorResponse) => {
				alert(error.message);
			}
		);
	}

	// When user clicks "DELETE" button, prompt confirmation w/ dialog popup
	public openDialog(surveyTitle: string, surveyId: number): void {
		this.dialog.open(DeleteSurveyDialog, {
			width: '350px',
			data: {
				title: surveyTitle,
				id: surveyId
			}
		});
	}
}

