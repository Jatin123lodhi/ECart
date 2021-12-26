package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import models.ProductPic;

public class ProductImageServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		int productId = Integer.parseInt(request.getParameter("product_id"));

		String picPath = ProductPic.getSingleProductPic(productId);
		InputStream is = getServletContext().getResourceAsStream("/WEB-INF/uploads/"+picPath);
		
		
		OutputStream os = response.getOutputStream();

		int count=0;
		byte[] ar = new byte[1024];
		while ((count= is.read(ar))!=-1)
		{
			os.write(ar);
		}
		os.flush();
		os.close();
	}
}





/*
getServletContext() explain?

it returns the obj of ServletContext
interface

it is inherited from HttpServlet
and Generic Servlet se HttpServlet ko,
generic Servlet ne method define kiya
ha 
*/