package com.Cmail.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Cmail.DAO.ComposeDAO;
import com.Cmail.DAO.ComposeDaoImp;
import com.Cmail.Model.ComposeMail;

/**
 * Servlet implementation class AllMails
 */
@SuppressWarnings("serial")

@WebServlet("/AllMails")
public class AllMails extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
			 
			ComposeDAO obj=new ComposeDaoImp();
		        List<ComposeMail> cm=obj.viewAllMails();
		        System.out.println("get all mail "+cm);
		       //  String json = cm;

		      // response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
		      //  response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
		      //  response.getWriter().write(json);  
		     //  RequestDispatcher rd=request.getRequestDispatcher("/GmailHome.jsp");
		        
		        HttpSession session=request.getSession(false);
			   session.setAttribute("SentMails",cm);
			   System.out.println(session.getAttribute("SentMails"));
			  // rd.forward(request, response);
		    
	}
	

}
