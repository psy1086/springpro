package com.company.user.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginIntercepter extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(LoginIntercepter.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("loginintercepter");
		HttpSession httpSession = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object userDTO = modelMap.get("user");
		
		if(userDTO != null) {
			logger.info("Login Success");
			httpSession.setAttribute("login", userDTO);
			response.sendRedirect("/spj/home");
		}
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws Exception{
		HttpSession httpSession = request.getSession();
		if(httpSession.getAttribute("login")!=null) {
			logger.info("clear login data before");
			httpSession.removeAttribute("login");
		}
		
		return true;
	}
}
