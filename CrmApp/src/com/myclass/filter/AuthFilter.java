package com.myclass.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myclass.util.StaticConstants;

public class AuthFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		// Khởi tạo session
		HttpSession session = req.getSession();
		
		// Kiểm tra đăng nhập
		System.out.println(session.getAttribute(StaticConstants.SESSION_ACCOUNT));
		
		if(session.getAttribute(StaticConstants.SESSION_ACCOUNT) != null) {
			chain.doFilter(request, response);
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		
	}

}
