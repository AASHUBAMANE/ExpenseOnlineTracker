package com.servlet;

import java.io.IOException;
import java.util.List;

import com.dao.ExpenseDao;
import com.dao.UserDao;
import com.entity.Expense;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DeleteExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		int id = Integer.parseInt(req.getParameter("id"));
		
		System.out.println(id);
		
		
	
		HttpSession session = req.getSession();
		
	
	
	
	ExpenseDao dao = new ExpenseDao();
	

		

		if (dao.deleteExpense(id)) {
			
			session.setAttribute("msg", "Record Deleted Sucessfully");
			
			
			
		}else {
		session.setAttribute("msg", "Record Not Found With Given ID");
		}
		
		
		
		resp.sendRedirect("home.jsp");
		
       

	}

}