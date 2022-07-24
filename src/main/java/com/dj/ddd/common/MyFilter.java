package com.dj.ddd.common;
import com.dj.ddd.service.UserService;
import com.dj.ddd.service.userdto.UserLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements HandlerInterceptor{

	@Autowired
	private UserService userService;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, 
			Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, 
			Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		UserLoginDto user = (UserLoginDto) request.getSession().getAttribute("user");
		if(null == user) {
			response.sendRedirect(request.getContextPath()+"/u/toLogin");
			return false;
		}
		return true;
	}
}

