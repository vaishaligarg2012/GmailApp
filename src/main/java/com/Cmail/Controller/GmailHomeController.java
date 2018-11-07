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
@WebServlet("/GmailHomeController")
public class GmailHomeController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        HttpSession session=request.getSession(false);  
        if(session!=null){  
        String name=(String)session.getAttribute("email");  
          System.out.println("Login with "+name);
          //out.print("Hello, "+name+" Welcome to Profile");  
          RequestDispatcher rd=request.getRequestDispatcher("GmailHome.jsp");
        	rd.forward(request, response);
  		
        }  
        else{  
           // out.print("Please login first");  
            request.getRequestDispatcher("login.jsp").include(request, response);  
        }  

	}

}
