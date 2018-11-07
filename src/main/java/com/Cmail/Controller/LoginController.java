package com.Cmail.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Cmail.DAO.UserDaoImp;
import com.Cmail.Model.Users;

@SuppressWarnings("serial")
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");

		String email=request.getParameter("email");
		String pass=request.getParameter("pass");

		Users obj=new Users();
		obj.setEmail(email);
		obj.setPassword(pass);

		UserDaoImp login=new UserDaoImp();
		Users user =login.validateUser(obj);
		
		if(user==null) {
			System.out.println("UserName password not match ");
        	request.setAttribute("msg","Login Failed, Try Again");
            RequestDispatcher rd=request.getRequestDispatcher("ErrorPage.jsp");
	    	rd.forward(request, response);
		}else {
			
		System.out.println("Success login "+user.getEmail());
		//out.print("Welcome, "+user.getEmail());  

		HttpSession session=request.getSession();  
        session.setAttribute("userObject",user);
        session.setAttribute("name",user.getFirstName());
        session.setAttribute("email", user.getEmail());
		
        
        //request.getRequestDispatcher("Header.jsp");
		//rd1.forward(request, response);
		RequestDispatcher rd=request.getRequestDispatcher("GmailHome.jsp");
    	rd.forward(request, response);
		}
	}

}
