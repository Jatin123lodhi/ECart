package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.Date;
import models.User;

public class SaveProfileServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		
		if(user!=null){
			String firstName = request.getParameter("firstname");
			String middleName = request.getParameter("middlename");
			String lastName = request.getParameter("lastname");
			String dob = request.getParameter("dob");
			String mobile = request.getParameter("mobile");
			
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String pin = request.getParameter("pin");

			user.setFirstName(firstName);
			user.setMiddleName(middleName);
			user.setLastName(lastName);
			user.setDob(Date.valueOf(dob));
			user.setMobile(mobile);

			user.saveProfile();

		}else{
			response.sendRedirect("signin.jsp");
		}
	}
}