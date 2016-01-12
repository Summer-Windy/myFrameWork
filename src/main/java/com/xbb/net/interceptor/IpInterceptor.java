package com.xbb.net.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class IpInterceptor extends HandlerInterceptorAdapter {


		// 重写 preHandle()方法，在业务处理器处理请求之前对该请求进行拦截处理
		public boolean preHandle(HttpServletRequest request,
				HttpServletResponse response, Object handler) throws Exception {
			System.out.println("IP拦截器-init");
			
				return true;
			
		}

		public void postHandle(HttpServletRequest request,
				HttpServletResponse response, Object o, ModelAndView mav)
				throws Exception {
			
			System.out.println("IP拦截器-postHandle");
		}

		public void afterCompletion(HttpServletRequest request,
				HttpServletResponse response, Object o, Exception excptn)
				throws Exception {
			System.out.println("IP拦截器-afterCompletion");
		}

		
}
