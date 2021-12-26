package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.Map;
import java.util.LinkedHashMap;
import utils.ProductCount;

import com.google.gson.Gson;

public class AddToCartServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		int productId = Integer.parseInt(request.getParameter("product_id"));
		
		Map<Integer,Integer> cart = (Map<Integer,Integer>)session.getAttribute("cart");
		if (cart==null)
		{
			cart  = new LinkedHashMap<Integer,Integer>();
			session.setAttribute("cart",cart);
		}
		cart.put(productId,1);
		int cartItemCount = cart.keySet().size();
		ProductCount pc = new ProductCount(cartItemCount);
		String resp = new Gson().toJson(pc);
		response.getWriter().write(resp);


	}
}