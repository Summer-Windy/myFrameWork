package com.xbb.net.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



/**user是盐田政府的微发布模块，
这个类是用户登陆的数据表
表名为wx_user
字段有
id 用户ID
user_name 用户名
user_password 密码
valid  是否可用状态
 real_name 用户名
 role 权限
*/
@Entity
@Table(name="wx_user")//数据库表的名字
public class wx_user {
	private Integer id;	
	private String user_name;  
	private String user_password;
	private Character valid; 
	private String real_name;
	private Character role;//0是管理员，1是普通成员
	private UserPapers userpaper;
	private Integer phone_role;//根据权限查看电话号码是否可见	
	private String phone_number;  //手机号码
	private Integer user_check;  //用户是否有审核的权限
	private Integer morning_role;
	

	
    @GenericGenerator(name = "generator", strategy = "increment")  
	@Id  
	@GeneratedValue(generator = "generator")  
    @Column(name="id",insertable=false,updatable=false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="user_name" ,length=256)
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	 @Column(name="user_password" ,length=24)
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	 @Column(name="valid" ,length=4)
	public Character getValid() {
		return valid;
	}
	public void setValid(Character valid) {
		this.valid = valid;
	}
	@Column(name="real_name" ,length=128)
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	 @Column(name="role" ,length=4)
	public Character getRole() {
		return  role;
	}
	public void setRole(Character role) {
		this.role = role;
	}
	
	@OneToOne
    @JoinColumn(name="paper_id")
	public UserPapers getUserpaper() {
		return userpaper;
	}
	public void setUserpaper(UserPapers userpaper) {
		this.userpaper = userpaper;
	}
	
	@Column(name="phone_role")
	public Integer getPhone_role() {
		return phone_role;
	}
	public void setPhone_role(Integer phone_role) {
		this.phone_role = phone_role;
	}
	
	@Column(name="phone_number",length=32)
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	@Column(name="user_check")
	public Integer getUser_check() {
		return user_check;
	}
	public void setUser_check(Integer user_check) {
		this.user_check = user_check;
	}
	
	@Column(name="morning_role")
	public Integer getMorning_role() {
		return morning_role;
	}
	public void setMorning_role(Integer morning_role) {
		this.morning_role = morning_role;
	}
	
	

	
}
