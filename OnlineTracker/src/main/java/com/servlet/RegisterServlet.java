package com.servlet;

import java.io.IOException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dao.UserDao;
import com.entity.User;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fullName = req.getParameter("fullName");

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		String about = req.getParameter("about");
		
		Configuration c= new Configuration();
		c.configure("hibernate.cfg.xml");
		c.addAnnotatedClass(User.class);
		
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		//Transaction t = s.beginTransaction();
		Criteria  cr = s.createCriteria(User.class);
		cr.list();
		
		s.close();	
		
		User u = new User(fullName, email, password, about);
		

		
		System.out.println(u);
		
		UserDao dao = new UserDao();
		boolean f= dao.saveuser(u);
		
		HttpSession session = req.getSession();
		
		if(f) 
		{
			session.setAttribute("msg"," Register Successfully ! ");
			//System.out.println("Register Successfully!");
			resp.sendRedirect("Register.jsp");
		}
		else
		{
			session.setAttribute("msg"," Something wrong on server ! ");
			//System.out.println(" Something wrong on server !");
			resp.sendRedirect("Register.jsp");
		}
		

		
		
	}
}
