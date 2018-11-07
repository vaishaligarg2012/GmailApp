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

@SuppressWarnings("serial")
@WebServlet("/SentMailController")
public class ViewAllSentMailController extends HttpServlet {
	   public ViewAllSentMailController() {
     }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html");
      // List<String> list=new ArrayList<String>();
      // String email="vaishali@gmail.com";
       
       HttpSession session=request.getSession(false);  
       String email= (String)session.getAttribute("email"); 

        ComposeDAO obj=new ComposeDaoImp();
        List<ComposeMail> cm=obj.viewAllSentMail(email);
        System.out.println("get all mail "+cm);
       
        RequestDispatcher rd=request.getRequestDispatcher("/GmailHome.jsp");
		request.setAttribute("SentMails",cm);
	    rd.forward(request, response);
       
       
	}

}
