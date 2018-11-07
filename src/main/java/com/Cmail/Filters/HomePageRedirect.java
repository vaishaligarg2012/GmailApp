package com.Cmail.Filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class HomePageRedirect implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter initialized");
		
		
	}
	
    public void destroy() {
    	System.out.println("Filter destroyed");
	}                 

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			HttpServletRequest request1=(HttpServletRequest)	request;
		    String path=request1.getRequestURI();
		   // System.out.println(path);
		    if(path.equals("/GMail/Login.jsp")) {
		    	chain.doFilter(request1, response);
		    }else {
		    	HttpSession session=request1.getSession(false);
		    	System.out.println(" session : "+session+" "+session.getAttribute("userObject"));
		    	if(session!=null) {
		    		if(path.equals("/GMail/LoginController")) {
		    			chain.doFilter(request1, response);	
		    		}
		    		else if (session.getAttribute("userObject")==null) {
		    			request1.setAttribute("msg", "Please Login First!!");
			    		RequestDispatcher rd=request1.getRequestDispatcher("Login.jsp");
			    	    rd.forward(request1, response);
		    		}
		    		else {
		    			chain.doFilter(request1, response);
		    		}
			    	

		    	}else{
		    		request1.setAttribute("msg", "Please Login First!!");
		    		RequestDispatcher rd=request1.getRequestDispatcher("Login.jsp");
		    	    rd.forward(request1, response);
		           
		           
		    	}
		    }
						
				}

	

}
