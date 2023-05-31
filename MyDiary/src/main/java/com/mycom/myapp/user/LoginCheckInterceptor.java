package com.mycom.myapp.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//요청 처리 전에 로그인 상태를 확인하고, 로그인이 되어 있지 않은 경우 로그인 페이지로 리다이렉트하는 기능을 구현
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("login");
		
		// 로그인이 되어있지 않은 경우 로그인 페이지로 리다이렉트합니다.
		if (obj == null) {
			response.sendRedirect(request.getContextPath() + "/login/login");
			return false;
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) 
			throws Exception {
		// 요청 처리 후에 호출되는 메소드입니다. 특별한 처리가 필요 없으므로 부모의 메소드를 그대로 호출합니다.
		super.postHandle(request, response, handler, modelAndView);
	}
}