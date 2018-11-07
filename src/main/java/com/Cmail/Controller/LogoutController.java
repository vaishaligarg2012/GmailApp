package com.Cmail.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
			
			request.setAttribute("msg", "Logout Success!!");
			HttpSession session=request.getSession();  
			session.removeAttribute("userObject");
            session.invalidate();  
          //  System.out.println("error in redirecting page");
        	RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
        	rd.forward(request, response);
    	
	}
		
}
