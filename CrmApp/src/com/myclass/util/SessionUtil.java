package com.myclass.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionUtil {
	public static boolean checkSession(
			HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		if(req.getSession().getAttribute("LOGIN_ACCOUNT") == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return true;
		}
		return false;
	}
}
