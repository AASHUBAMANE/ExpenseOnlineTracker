package com.servlet;

import java.io.IOException;
import java.util.List;

import com.dao.ExpenseDao;
import com.entity.Expense;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ViewExpenseServlet  extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser"); 

        if (user != null) {
            ExpenseDao dao = new ExpenseDao();
            List<Expense> expenses = dao.getAllExpenseByUser(user);
            
            request.setAttribute("expenseList", expenses); 
            request.getRequestDispatcher("view_expense.jsp").forward(request, response); 
        } else {
            response.sendRedirect("Login.jsp"); 
        }
    }


}
