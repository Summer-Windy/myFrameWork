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
 * 微调查
 * @author Administrator
 *
 */

@Entity 
@Table(name="wx_survey") 
public class Survey {
	
	private int id;//主键
	private String surveytitle;//调查标题
	private String intro;//内容简介
	private String endtime;//截止时间
	private String survey_group;//群体
	private String publicity;//公开性
	private Integer survey_num;//发布调查的数量
	private String createtime;//创建时间
	private String pass_status;//审核状态 :审核中 未通过  通过
	private String isvalid;//是否可用 Y未删除 N删除
	private wx_user user;
	private String manager_id;
	private String manager_time;//审核时间
	private String imglocation;//图片背景
	private Integer praise_num;//浏览人数
	private Integer joinnum;//参与人数
	private String lastUpdateUser;//最后操作者
	private String surveyremark;//问卷说明
	
	
	
	
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
	
	
	@Column(name="surveytitle")
	public String getSurveytitle() {
		return surveytitle;
	}
	public void setSurveytitle(String surveytitle) {
		this.surveytitle = surveytitle;
	}
	
	@Column(name="intro")
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	@Column(name="endtime")
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	@Column(name="survey_group")
	public String getSurvey_group() {
		return survey_group;
	}
	public void setSurvey_group(String survey_group) {
		this.survey_group = survey_group;
	}
	
	@Column(name="publicity")
	public String getPublicity() {
		return publicity;
	}
	public void setPublicity(String publicity) {
		this.publicity = publicity;
	}
	
	
	@Column(name="survey_num")
	public Integer getSurvey_num() {
		return survey_num;
	}
	public void setSurvey_num(Integer survey_num) {
		this.survey_num = survey_num;
	}
	
	@Column(name="createtime")
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
	@Column(name="pass_status")
	public String getPass_status() {
		return pass_status;
	}
	public void setPass_status(String pass_status) {
		this.pass_status = pass_status;
	}
	
	@Column(name="isvalid")
	public String getIsvalid() {
		return isvalid;
	}
	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}
	
	
	@OneToOne
    @JoinColumn(name="user_id")
	public wx_user getUser() {
		return user;
	}
	public void setUser(wx_user user) {
		this.user = user;
	}
	
	
	@Column(name="manager_time")
	public String getManager_time() {
		return manager_time;
	}
	public void setManager_time(String manager_time) {
		this.manager_time = manager_time;
	}
	
	@Column(name="imglocation")
	public String getImglocation() {
		return imglocation;
	}
	public void setImglocation(String imglocation) {
		this.imglocation = imglocation;
	}
	
	@Column(name="praise_num")
	public Integer getPraise_num() {
		return praise_num;
	}
	public void setPraise_num(Integer praise_num) {
		this.praise_num = praise_num;
	}
	
	@Column(name="manager_id")
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	@Column(name="lastUpdateUser")
	public String getLastUpdateUser() {
		return lastUpdateUser;
	}
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}
	
	@Column(name="surveyremark")
	public String getSurveyremark() {
		return surveyremark;
	}
	public void setSurveyremark(String surveyremark) {
		this.surveyremark = surveyremark;
	}
	
	@Column(name="joinnum")
	public Integer getJoinnum() {
		return joinnum;
	}
	public void setJoinnum(Integer joinnum) {
		this.joinnum = joinnum;
	}
	
	
	
	
	
}
