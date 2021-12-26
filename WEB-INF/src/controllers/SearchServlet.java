package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;
import models.Product;

public class SearchServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String searchKey = request.getParameter("search_key");
		System.out.println(searchKey+"  srchKey ");
		ArrayList<Product> products = Product.searchProducts(searchKey);
		System.out.println(products+"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ prodcuts ");
		Gson gson = new Gson();
		String resp = gson.toJson(products);
		response.getWriter().write(resp);
		
	}
}