package com.xbb.net.web.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xbb.net.core.entityManager.VipsManager;

@Controller
public class testHibernate {

	@Resource
	private VipsManager vipsManager;
	
	
	@RequestMapping(value={"/testHibernate"},produces = "text/html;charset=UTF-8")
	public String testHibernate(HttpServletRequest request,
			HttpServletResponse response,
			Map< Object, Object> resutltMap
			){
		vipsManager.add();
		resutltMap.put("abc", "abc");
		return  "test";
	}
}
