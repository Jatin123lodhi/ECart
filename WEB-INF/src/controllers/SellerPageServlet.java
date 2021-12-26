package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import models.User;
import models.Seller;

public class SellerPageServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response )throws ServletException,IOException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String nextPage = "signin.jsp";
		if (user!=null)
		{	
			ArrayList<Seller> sellers = Seller.collectSellerAccounts(user.getUserId());
			
			session.setAttribute("sellers",sellers);
			nextPage = "seller_page.jsp";
		}
		
		request.getRequestDispatcher(nextPage).forward(request,response);
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response )throws ServletException,IOException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String nextPage = "signin.jsp";
		if (user!=null)
		{	
			ArrayList<Seller> sellers = Seller.collectSellerAccounts(user.getUserId());
			
			request.setAttribute("sellers",sellers);
			nextPage = "seller_page.jsp";
		}
		
		request.getRequestDispatcher(nextPage).forward(request,response);
		
	}
}
