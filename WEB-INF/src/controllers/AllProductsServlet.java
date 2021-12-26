package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;


import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import models.User;
import models.Product;

public class AllProductsServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		String resp = "\"session expired\"";
		
		if (user!=null)
		{	

			int sellerId = Integer.parseInt(request.getParameter("seller_id"));

			ArrayList<Product> list = Product.collectAllProducts(sellerId);
			
			Gson gson = new Gson();
			resp = gson.toJson(list);
			
		}
		
		response.getWriter().write(resp);
	}
}