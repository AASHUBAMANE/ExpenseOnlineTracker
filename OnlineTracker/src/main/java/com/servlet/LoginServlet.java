package com.servlet;

import java.io.IOException;

import com.dao.UserDao;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;




public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	
	
	String email=req.getParameter("Email");
	String password=req.getParameter("password");
	
	
	System.out.println(email+password);
	

	
	
	UserDao dao = new UserDao();
	User u=dao.login(email, password);
	System.out.println(u);

	HttpSession session = req.getSession();
	if(u== null) {
		session.setAttribute("msg", "Invalid mail and Password!");
		resp.sendRedirect("Login.jsp");
	}
	else {
		session.setAttribute("loginUser", u);
		resp.sendRedirect("home.jsp");
	}


}

}
