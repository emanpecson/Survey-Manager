package com.demo.websurvey.survey;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.demo.websurvey.question.Question;

@Entity
@Table(name="surveys")
public class Survey implements Serializable {

	// primary key
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false, updatable=false, unique=true)
	private Long id;

	@Column(name="title")
	private String title;

	@OneToMany(mappedBy="survey", orphanRemoval=true)
	private Set<Question> questionSet = new HashSet<Question>();

	Survey() {}

	// getters + setters
	
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Set<Question> getQuestionSet() {
		return questionSet;
	}
	public void setQuestionSet(Set<Question> questionSet) {
		this.questionSet = questionSet;
	}
	public void addQuestion(Question question) {
		questionSet.add(question);
	}
	public void removeQuestion(Question question) {
		questionSet.remove(question);
	}
	public void removeAllQuestions() {
		questionSet.clear();
	}
}
