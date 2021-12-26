package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import com.google.gson.Gson;

import models.ProductPoint;
public class ShowProductPointsServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		int productId = Integer.parseInt(request.getParameter("product_id"));

		ArrayList<ProductPoint> list = ProductPoint.getProductPoints(productId);
		
		Gson gson = new Gson();
		String resp = gson.toJson(list);
		response.getWriter().write(resp);
		
	}
}