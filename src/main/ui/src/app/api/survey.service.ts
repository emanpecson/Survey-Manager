import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Survey } from '../data-model/Survey';

@Injectable({
	providedIn: 'root'
})
export class SurveyService {
	private apiServerUrl = environment.apiBaseUrl;

	constructor(private http: HttpClient) {}

	// send GET requests

	public getSurveys(): Observable<Survey[]> {
		console.log(this.apiServerUrl);
		return this.http.get<Survey[]>(this.apiServerUrl + '/survey/all');
	}

	public getSurveyById(surveyId: number): Observable<Survey> {
		return this.http.get<Survey>(this.apiServerUrl + '/survey/find/' + String(surveyId));
	}

	// send POST requests

	public addSurvey(survey: JSON): void {
		this.http.post<JSON>(this.apiServerUrl + '/survey/add', survey)
		.subscribe(
			(response) => { console.log("Success!", response); },
			(error: HttpErrorResponse) => { console.error(error); }
		);
	}

	// send PUT requests

	public incrementAnswerSelectionCountById(answerId: number): void {
		this.http.put(this.apiServerUrl + '/answer/update/selectionCount/' + String(answerId), null)
		.subscribe(
			(response) => { console.log('Success!', response) },
			(error: HttpErrorResponse) => { console.error(error); } 
		);
	}

	// send DELETE requests

	public deleteSurveyById(surveyId: number): void {
		this.http.delete(this.apiServerUrl + '/survey/delete/' + String(surveyId))
		.subscribe(
			(response) => { console.log("Success!", response); },
			(error: HttpErrorResponse) => { console.error(error); }
		);
	}
}
