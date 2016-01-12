package com.xbb.net.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * 微调查选项值
 * @author Administrator
 *
 */
@Entity 
@Table(name="wx_options_value")
public class SurveyOptionsValue {
	
	private int id;
	private SurveyOptions surveyoptions;
	private String option_value;
	private Integer option_num;
	private Survey survey;
	
	
	
	@GenericGenerator(name = "generator", strategy = "increment")  
	@Id  
	@GeneratedValue(generator = "generator")  
	@Column(name = "id", unique = true, nullable = false, precision = 8, scale = 0)  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@OneToOne
    @JoinColumn(name="option_id") 
	public SurveyOptions getSurveyoptions() {
		return surveyoptions;
	}
	public void setSurveyoptions(SurveyOptions surveyoptions) {
		this.surveyoptions = surveyoptions;
	}
	
	@Column(name="option_value")
	public String getOption_value() {
		return option_value;
	}
	public void setOption_value(String option_value) {
		this.option_value = option_value;
	}
	
	@Column(name="option_num")
	public Integer getOption_num() {
		return option_num;
	}
	public void setOption_num(Integer option_num) {
		this.option_num = option_num;
	}
	
	@OneToOne
    @JoinColumn(name="survey_id") 
	public Survey getSurvey() {
		return survey;
	}
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	
	
	
	
	
	

}
