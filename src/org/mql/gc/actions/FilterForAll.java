	package org.mql.gc.actions;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//added by Ahmed and Hassan
public class FilterForAll implements Filter{
	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse rep=(HttpServletResponse) response; 
		//check if sessions are available 
		Integer donnateurID =  (Integer) req.getSession().getAttribute("userid");
		Integer ida =  (Integer)req.getSession().getAttribute("idAssociation");
		
		String uri = req.getRequestURI();		
		if( donnateurID == null && uri.indexOf("/donation.xhtml")>=0  ){
			/*
			 * this call the index.xhtml page but it save the URL of request 
			 */
				request.setAttribute("logDon", "notIn");
		        RequestDispatcher rd= ((HttpServletRequest)request).getRequestDispatcher("/detailCase.xhtml");
		        rd.forward(request, response);
		}	
		else if(ida==null && uri.indexOf("/LoadCase.xhtml")>=0){
			rep.sendRedirect(req.getContextPath()+"/login.xhtml");
		}
		chain.doFilter(request,response);
	}
	
	public void init(FilterConfig arg0) throws ServletException {}
}
