package com.xbb.net.interceptor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TimeInterceptor extends HandlerInterceptorAdapter {

		private int openingTime; // openingTime 属性指定上班时间
		private int closingTime; // closingTime属性指定下班时间
		private String outsideOfficeHoursPage;// outsideOfficeHoursPage属性指定错误提示页面的URL

		// 重写 preHandle()方法，在业务处理器处理请求之前对该请求进行拦截处理
		public boolean preHandle(HttpServletRequest request,
				HttpServletResponse response, Object handler) throws Exception {
			System.out.println("工作时间拦截器-init");
			Calendar cal = Calendar.getInstance();
			int hour = cal.get(Calendar.HOUR_OF_DAY); // 获取当前时间
			if (openingTime <= hour && hour < closingTime) { // 判断当前是否处于工作时间段内
				return true;
			} else {
				response.sendRedirect(outsideOfficeHoursPage); // 返回提示页面
				return false;
			}
		}

		public void postHandle(HttpServletRequest request,
				HttpServletResponse response, Object o, ModelAndView mav)
				throws Exception {
			
			System.out.println("工作时间拦截器-postHandle");
		}

		public void afterCompletion(HttpServletRequest request,
				HttpServletResponse response, Object o, Exception excptn)
				throws Exception {
			System.out.println("工作时间拦截器-afterCompletion");
		}

		public int getOpeningTime() {
			return openingTime;
		}

		public void setOpeningTime(int openingTime) {
			this.openingTime = openingTime;
		}

		public int getClosingTime() {
			return closingTime;
		}

		public void setClosingTime(int closingTime) {
			this.closingTime = closingTime;
		}

		public String getOutsideOfficeHoursPage() {
			return outsideOfficeHoursPage;
		}

		public void setOutsideOfficeHoursPage(String outsideOfficeHoursPage) {
			this.outsideOfficeHoursPage = outsideOfficeHoursPage;
		}

	// 可以看出，上面的代码重载了preHandle()方法，该方法在业务处理器处理请求之前被调用。在该方法中，首先获得当前的时间，判断其是否在
	// openingTime和closingTime之间，如果在，返回true，这样才会调用业务控制器去处理该请求；否则直接转向一个页面，返回false，这样该请求就不会被处理。
	
}
