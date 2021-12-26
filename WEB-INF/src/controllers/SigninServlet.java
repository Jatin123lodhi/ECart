package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import utils.GoogleCaptcha;

import models.User;

public class SigninServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		request.getRequestDispatcher("signin.jsp").forward(request,response);		
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "signin.jsp";
		
		String captchaResponse = request.getParameter("g-recaptcha-response");		
		boolean flag = GoogleCaptcha.checkRecaptcha(captchaResponse);
		//System.out.println(flag+"  -flag google recaptcha");
		flag=true;
		if(flag){		
			String unameEmail = request.getParameter("unm_email");
			String password = request.getParameter("password");		

			User user = User.loginUser(unameEmail,password);
			if(user!=null){
				session.setAttribute("user",user);
				nextPage = "profile.jsp";
				response.sendRedirect("profile.do");

			}else{
				
				request.setAttribute("error","Either Username/Email or Password is incorrect...");
				request.getRequestDispatcher(nextPage).forward(request,response);	
			}
		}else{
			request.setAttribute("error","Captcha Test Failed");
			request.getRequestDispatcher(nextPage).forward(request,response);	
		}		
	}
}