package com.Cmail.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Cmail.DAO.UserDaoImp;
import com.Cmail.Model.Users;

@SuppressWarnings("serial")
@WebServlet("/registerController")
public class RegisterController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
		
		String email= request.getParameter("email");
		String password= request.getParameter("pass");
		String fName=request.getParameter("fname");
		String lName=request.getParameter("lname");
		
	    Users obj=new Users();
	    obj.setEmail(email);
	    obj.setPassword(password);
        obj.setFirstName(fName);
        obj.setLastName(lName);
        
        UserDaoImp imp=new UserDaoImp();
        boolean b=imp.addUsers(obj);
        if(b==true) {
        	request.setAttribute("msg","Registered Successfully Please Login Here!!");
        	RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
        	rd.forward(request, response);
        }
      	}

}
