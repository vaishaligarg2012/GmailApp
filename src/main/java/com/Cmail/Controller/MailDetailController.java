package com.Cmail.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Cmail.DAO.ComposeDAO;
import com.Cmail.DAO.ComposeDaoImp;
import com.Cmail.Model.ComposeMail;

@SuppressWarnings("serial")
@WebServlet("/detailMails")
public class MailDetailController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String 	pid=request.getParameter("mid");
		System.out.println("check update "+pid);

		ComposeDAO obj=new ComposeDaoImp();
		List<ComposeMail> cm=obj.details(pid);
		System.out.println("get all mail "+cm);

		RequestDispatcher rd=request.getRequestDispatcher("/Details.jsp");
		request.setAttribute("detailsMails",cm);
		rd.forward(request, response);

	}

}
