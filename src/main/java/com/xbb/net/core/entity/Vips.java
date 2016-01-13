package com.xbb.net.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/*jxy：这个是一个实体类对应的是数据库中的表*/
@Entity 
@Table(name="vips") 
public class Vips {
	private Integer id;
	private String name;
	//hibernate生成主键的方式，
	//name 指定生成器的名称
	//strategy属性指定具体生成器的类名。
	@GenericGenerator(name = "generator", strategy = "increment")  
	@Id  
	@GeneratedValue(generator = "generator")  
	@Column(name = "id", unique = true, nullable = false, precision = 8, scale = 0)  
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "name", length = 128)  //
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
