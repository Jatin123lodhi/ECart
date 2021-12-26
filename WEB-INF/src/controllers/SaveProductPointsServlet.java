package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import models.User;
import models.Product;
import models.ProductPoint;

public class SaveProductPointsServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String resp = null;
		if (user!=null)
		{
			String[] pointTitles = request.getParameterValues("p_ttl");
			String[] pointValues = request.getParameterValues("p_txt");
		
			Product product = (Product)session.getAttribute("product");
			ProductPoint.saveProductPoints(product.getProductId(),pointTitles,pointValues);
			resp = "{\"resp\":1}";
		}else{
			resp = "{\"resp\":-1}";
		}
		response.getWriter().write(resp);
	}
}
