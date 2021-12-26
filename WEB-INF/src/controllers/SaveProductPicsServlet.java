package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import java.io.IOException;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

import models.User;
import models.Seller;
import models.Product;
import models.ProductPic;


public class SaveProductPicsServlet extends HttpServlet
{

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String nextPage = "signin.jsp";
		if (user!=null)
		{
			if (ServletFileUpload.isMultipartContent(request)) // to check ke request me koi file type ke data ha ya nahi
			{
				DiskFileItemFactory dfif = new DiskFileItemFactory();
				ServletFileUpload sfu = new ServletFileUpload(dfif);
				List<FileItem> fileItems = null;
				try
				{
					fileItems = sfu.parseRequest(request);
					Seller seller = (Seller)session.getAttribute("seller");
					Product product = (Product)session.getAttribute("product");
					String filePath = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getUserName()+"/"+seller.getSellerAccountName()+"/"+product.getProductId());

					String dbPicPath = user.getUserName()+"/"+seller.getSellerAccountName()+"/"+product.getProductId()+"/";
					ArrayList<String> dbPicPaths = new ArrayList<String>();
					for(FileItem fileItem : fileItems){
						String fileName = fileItem.getName();
						dbPicPaths.add(dbPicPath+fileName);
						try
						{
							
							File file = new File(filePath,fileName);
							fileItem.write(file);
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
						
					}
					ProductPic.saveProductPic(product.getProductId(),dbPicPaths);
					//nextPage = "product.jsp";
					response.sendRedirect("product.jsp");
					return;
				}
				catch (FileUploadException e)
				{
					e.printStackTrace();
				}
			}
		}
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}