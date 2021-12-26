package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import models.Product;
import models.User;

public class SaveDescriptionServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String resp = "";
		if (user!=null)
		{
			String description = request.getParameter("description");
			//int productId = Integer.parseInt(request.getParameter("product_id"));  use kya ha ....

			
			Product product = (Product)session.getAttribute("product");
			product.setDescription(description);
			if (product.saveDescription())
			{
				resp = "{\"resp\":1}";
				
			}
			else{
				resp = "{\"resp\":0}";
				
			}
		}
		else{
			
			resp = "{\"resp\":-1}";
			
		}
		response.getWriter().write(resp);
	}
}