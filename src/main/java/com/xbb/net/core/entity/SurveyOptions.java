package com.xbb.net.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * 微调查选项
 * @author Administrator
 *
 */

@Entity 
@Table(name="wx_survey_options")
public class SurveyOptions {
	
	
	private int id;
	private Survey survey;
	private String options_name;
	private String options_type;
	private Integer type_num;//最多选几项
	
	
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
    @JoinColumn(name="survey_id") 
	public Survey getSurvey() {
		return survey;
	}
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	
	@Column(name="options_name")
	public String getOptions_name() {
		return options_name;
	}
	public void setOptions_name(String options_name) {
		this.options_name = options_name;
	}
	
	@Column(name="options_type")
	public String getOptions_type() {
		return options_type;
	}
	public void setOptions_type(String options_type) {
		this.options_type = options_type;
	}
	
	@Column(name="type_num")
	public Integer getType_num() {
		return type_num;
	}
	public void setType_num(Integer type_num) {
		this.type_num = type_num;
	}
	
	
	
	

}
