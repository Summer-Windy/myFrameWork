package com.xbb.net.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 用户 微商报权限
 * @author Administrator
 *
 */

@Entity 
@Table(name="wx_user_paper") 
public class UserPapers {
	
	private int id;
	private String jd_role;
	private String sq_role;
	private Integer role_type;
	
	
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
	
	@Column(name="jd_role")
	public String getJd_role() {
		return jd_role;
	}
	public void setJd_role(String jd_role) {
		this.jd_role = jd_role;
	}
	
	@Column(name="sq_role")
	public String getSq_role() {
		return sq_role;
	}
	public void setSq_role(String sq_role) {
		this.sq_role = sq_role;
	}
	
	@Column(name="role_type")
	public Integer getRole_type() {
		return role_type;
	}
	public void setRole_type(Integer role_type) {
		this.role_type = role_type;
	}
	
	
	

}
