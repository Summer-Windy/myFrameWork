package com.xbb.net.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping(value={"/login"},produces = "text/html;charset=UTF-8")
	public String login(){
		
		return "/account/login";
	}
}
