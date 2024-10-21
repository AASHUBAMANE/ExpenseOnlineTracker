package com.servlet;

import java.io.IOException;


import com.dao.ExpenseDao;
import com.entity.Expense;
import com.entity.User;
import com.utility.HibernateConfig;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;




public class SaveExpenseServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(1123);
		try {
			
			String title=req.getParameter("title");
			String date=req.getParameter("date");
			String time=req.getParameter("time");
			String description=req.getParameter("description");
			String price=req.getParameter("price");
			
			
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("loginUser");
				  
		   Expense ex = new Expense(title,date,time,description,price,user);
			
			
			ExpenseDao dao = new ExpenseDao();
			boolean f = dao.saveExpense(ex);
			System.out.println(f);
			
			if(f) 
			{
				session.setAttribute("msg"," Expense added  Successfully ! ");
				
				resp.sendRedirect("add_expense.jsp");
			}
			else
			{
				session.setAttribute("msg"," Something wrong on server ! ");
				
				resp.sendRedirect("add_expense.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
