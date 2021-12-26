package listeners;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;
import java.util.ArrayList;

import utils.EmailSender;
import utils.GoogleCaptcha;
import utils.EmailSender.MailPasswordAuthenticator;
import models.Category;


public class AppListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent ev){
		ServletContext context = ev.getServletContext();
		
		EmailSender.MailPasswordAuthenticator.senderEmail 
			= context.getInitParameter("sender_email");
		EmailSender.MailPasswordAuthenticator.senderEmailPassword
			= context.getInitParameter("sender_email_password");
		GoogleCaptcha.SECRET_KEY = context.getInitParameter("secret_key");

		ArrayList<Category> categories = Category.collectCategories();
		context.setAttribute("categories",categories);
		
	}

	public void contextDestroyed(ServletContextEvent ev){
	
	}
}