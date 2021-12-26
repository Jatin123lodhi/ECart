package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.User;
import models.Seller;
import models.Product;
import models.Category;

import com.google.gson.Gson;

public class AddNewProductServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		
		String nextPage = "signin.jsp";
		boolean flag = true; 

		if(user!=null){
			String productName = request.getParameter("product_name");

			if(productName!=null){
				flag = false;

				try{
					int categoryId = Integer.parseInt(request.getParameter("category_id"));		
					
					int quantity = Integer.parseInt(request.getParameter("quantity"));
					
					int price = Integer.parseInt(request.getParameter("price"));
					
					int discount = Integer.parseInt(request.getParameter("discount"));
					
					
					Seller seller = (Seller)session.getAttribute("seller");
					
					
					Product product = new Product(seller,new Category(categoryId),productName,quantity,price,discount);
					
					
					if(product.saveProduct()){
						session.setAttribute("product",product);
						
						String filePath = getServletContext().getRealPath("WEB-INF/uploads/"+user.getUserName()+"/"+seller.getSellerAccountName());
						String fileName = Integer.toString(product.getProductId());

						File file = new File(filePath,fileName);
						file.mkdir();
						Gson gson = new Gson();
						String resp = gson.toJson(product);
						
						response.getWriter().write(resp);
					}else{
						
						response.getWriter().write("{}");
					}

				}catch(NumberFormatException e){
					
					response.getWriter().write("{}");
				}			
			}else{
				nextPage = "add_new_product.jsp";
				request.getRequestDispatcher(nextPage).forward(request,response);
			}
		}
		
		if(flag){
			//System.out.println("########## inside flag is true so forward to add_product.jsp ############");
			//nextPage = "add_product.jsp";
			//request.getRequestDispatcher(nextPage).forward(request,response);
			response.getWriter().write("{\"resp\":0}");
		}		
	}	
}