package com.xbb.net.web.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录的用户
 * @author a
 *
 */
@Controller
public class LoginController {

	@RequestMapping(value={"/login"},produces = "text/html;charset=UTF-8")
	public String login(){
		String myUrlJsp = "/account/login"; 
		return myUrlJsp;
	}
}
