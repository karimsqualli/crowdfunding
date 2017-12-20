package org.mql.gc.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
	
	public static HttpSession getSession() {
		return (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}
	
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
	
	public static Integer getUserId() {
		HttpSession session = getSession();
		if (session != null) {
			return (Integer) getSession().getAttribute("userid");
		}
		else {
			return null;
		}
	}
	
}
