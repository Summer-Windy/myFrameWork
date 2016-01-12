package com.xbb.net.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.service.AService;
import com.spring.service.BServiceImpl;

@Controller
public class testAop {
	/**
	 * 如下注入的方式   可以被aop监听
	 */
	@Autowired
	private BServiceImpl bService;
	@Autowired
	private AService aService;
	
	@RequestMapping(value={"/test"},produces = "text/html;charset=UTF-8")
	public String test(HttpServletRequest request,
			HttpServletResponse response,
			Map< Object, Object> resutltMap
			){
		/**
		 *如下方式  不能被aop监听 
		AService aService = new AServiceImpl();
		 */
		aService.barA();
		aService.fooA("asssss");
		bService.barB("bbbbbbbb", 1);
		//System.out.println("test");
		
		resutltMap.put("abc", "abc");
		return  "test";
	}
}
