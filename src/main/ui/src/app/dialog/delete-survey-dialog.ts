import { Component, Inject } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";
import { SurveyService } from "../api/survey.service";
import { DialogData } from "../home/home.component";

@Component({
	selector: 'delete-survey-dialog',
	templateUrl: 'delete-survey-dialog.html'
})
export class DeleteSurveyDialog {
	constructor(
		public dialogRef: MatDialogRef<DeleteSurveyDialog>,
		@Inject(MAT_DIALOG_DATA) public data: DialogData,
		public service: SurveyService
	) {}
	
	// Send DELETE request to back-end and close dialog popup
	public deleteSurveyById(id: number): void {
		this.service.deleteSurveyById(id);
		close();
		window.location.reload();
	}

	// Close dialog popup
	public close(): void {
		this.dialogRef.close();
	}
}