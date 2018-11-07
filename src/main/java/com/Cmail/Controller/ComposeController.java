package com.Cmail.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Cmail.DAO.ComposeDaoImp;
import com.Cmail.Model.ComposeMail;

@SuppressWarnings("serial")
@WebServlet("/composeController")
public class ComposeController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String to=request.getParameter("to");
		String cc=request.getParameter("cc");
		String subject=request.getParameter("subject");
		String msg=request.getParameter("msg");
        
		ComposeMail newMsg=new ComposeMail();
		newMsg.setTo(to);
		newMsg.setCc(cc);
		newMsg.setSubject(subject);
		newMsg.setMsg(msg);
		
        HttpSession session=request.getSession(false);  
        String email= (String)session.getAttribute("email"); 

	    System.out.println("email of vaishali "+email);
		ComposeDaoImp obj=new ComposeDaoImp();
		boolean check= obj.createCompose(newMsg,email);
		System.out.println("check created or not " +check);
        if(check==true) {
        	request.setAttribute("str", "Composed successfully ");
        	RequestDispatcher req=request.getRequestDispatcher("GmailHome.jsp");
        	req.forward(request, response);
        }else {
        	request.setAttribute("str", "Please Try again!!");
        	RequestDispatcher req=request.getRequestDispatcher("GmailHome.jsp");
        	req.forward(request, response);
        }
	}

}
