import { DataVisualizationComponent } from './data-visualization/data-visualization.component';
import { SurveyAttemptComponent } from './survey-attempt/survey-attempt.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SurveyTemplateComponent } from './survey-template/survey-template.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
	{
		path: '',
		component: HomeComponent
	},
	{ 
		path: 'survey-template', 
		component: SurveyTemplateComponent 
	},
	{ 
		path: 'survey-attempt/:id', 
		component: SurveyAttemptComponent 
	},
	{
		path: 'data-visualization/:id',
		component: DataVisualizationComponent
	}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
