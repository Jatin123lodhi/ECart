package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import models.User;
import models.Product;
public class ViewProductServlet extends HttpServlet
{	

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		int productId = Integer.parseInt(request.getParameter("product_id"));
		Product product = new Product(productId);
		product.getProductInfo();
		request.setAttribute("product",product);
		request.getRequestDispatcher("product.jsp").forward(request,response);
	}
}
