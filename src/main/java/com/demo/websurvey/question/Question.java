package com.demo.websurvey.question;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.demo.websurvey.answer.Answer;
import com.demo.websurvey.survey.Survey;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="questions")
public class Question implements Serializable {

	// primary key
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false, updatable=false, unique=true)
	private Long id;

	@Column(name="value")
	private String value;

	@OneToMany(mappedBy="question", orphanRemoval=true)
	private Set<Answer> answerSet = new HashSet<Answer>();
	
	// foreign key (to surveys table)
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="survey_id", referencedColumnName="id")
	private Survey survey;

	Question() {}

	// getters + setters

	public Long getId() {
		return id;
	}
	public Long getSurveyId() {
		return survey.getId();
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Set<Answer> getAnswerSet() {
		return answerSet;
	}
	public void setAnswerSet(Set<Answer> answerSet) {
		this.answerSet = answerSet;
	}
	public void addAnswer(Answer answer) {
		answerSet.add(answer);
	}
	public void removeAnswer(Answer answer) {
		answerSet.remove(answer);
	}
	public void removeAllAnswers() {
		answerSet.clear();
	}
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
}
