package org.mql.gc.actions;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAssFilter implements Filter {
	
    public LoginAssFilter() {
    }
    
	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
					
//			HttpServletRequest req = (HttpServletRequest)request;
//			HttpServletResponse res = (HttpServletResponse)response;
//			//Boolean isConnected =  req.getSession(true).getAttribute("isConnected") == null ? false : true;
//			String uri=req.getRequestURI();
//			HttpSession session=req.getSession(false); 
//			
//			if((session!=null && session.getAttribute("email")!=null) || uri.indexOf("/login.xhtml")>=0 || uri.contains("javax.faces.resource") || uri.indexOf("/index.xhtml")>=0 || uri.indexOf("/association.xhtml")>=0 ) {
//				chain.doFilter(request, response);
//			}
//			else {
//				res.sendRedirect(req.getContextPath() + "/login.xhtml");
//			}
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
