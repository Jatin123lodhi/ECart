package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;

import models.ProductPic;
public class ProductPicsServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		int productId = Integer.parseInt(request.getParameter("product_id"));
		
		ArrayList<ProductPic> list = ProductPic.getAllProductPics(productId);
		Gson gson =  new Gson();
		String resp = gson.toJson(list);
		response.getWriter().write(resp);
		
		//response.getWriter().write(list); // directly list ko kyun nahi write karte han json string me kyun convert ....doubt
		
	}
}