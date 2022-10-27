import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { SurveyTemplateComponent } from './survey-template/survey-template.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from '@angular/material/input'
import { MatButtonModule } from '@angular/material/button'
import { MatIconModule } from '@angular/material/icon'
import { MatRadioModule } from '@angular/material/radio'
import { MatDividerModule } from '@angular/material/divider';
import { MatFormFieldModule } from '@angular/material/form-field'
import { MatToolbarModule } from '@angular/material/toolbar'
import { MatCardModule } from '@angular/material/card';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { HttpClientModule } from '@angular/common/http';
import { SurveyAttemptComponent } from './survey-attempt/survey-attempt.component';
import { HeaderComponent } from './header/header.component';
import { DataVisualizationComponent } from './data-visualization/data-visualization.component';
import { NgApexchartsModule } from 'ng-apexcharts';
import { MatDialogModule } from '@angular/material/dialog';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SurveyTemplateComponent,
    SurveyAttemptComponent,
	HeaderComponent,
	DataVisualizationComponent
  ],
  imports: [
    BrowserModule,
	CommonModule,
    AppRoutingModule,
    BrowserAnimationsModule,
	MatToolbarModule,
	MatFormFieldModule,
	MatInputModule,
	MatButtonModule,
	MatIconModule,
	FormsModule,
	ReactiveFormsModule,
	HttpClientModule,
	MatRadioModule,
	MatDividerModule,
	MatCardModule,
	NgApexchartsModule,
	MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
