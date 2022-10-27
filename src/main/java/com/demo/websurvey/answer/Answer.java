package com.demo.websurvey.answer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.demo.websurvey.question.Question;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="answers")
public class Answer {

	// primary key
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false, updatable=false, unique=true)
	private Long id;

	@Column(name="value")
	private String value;

	@Column(name="selection_count")
	private Integer selectionCount = 0;

	// foreign key (to questions table)
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="question_id", referencedColumnName="id")
	private Question question;

	Answer() {}
	
	// getters + setters

	public Long getId() {
		return id;
	}
	public Long getQuestionId() {
		return question.getId();
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Integer getSelectionCount() {
		return selectionCount;
	}
	public void incrementSelectionCount() {
		this.selectionCount++;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Question getQuestion() {
		return question;
	}
}
