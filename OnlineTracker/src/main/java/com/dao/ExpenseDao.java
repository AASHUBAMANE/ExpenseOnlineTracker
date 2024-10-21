package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Expense;
import com.entity.User;
import com.utility.HibernateConfig;

public class ExpenseDao {

	private Session session = null;
	private Transaction tx = null;
	private SessionFactory factory = null;
	private Object ex;

	public boolean saveExpense(Expense ex) {
		boolean f = false;

		try {

			factory = HibernateConfig.GetSF();
			session = factory.openSession();
			tx = session.beginTransaction();
			session.save(ex);
			tx.commit();
			f = true;

		} catch (Exception e) {

			e.printStackTrace();

			if (tx != null) {

				e.printStackTrace();
			}

		}

		return f;
	}

	public List<Expense> getAllExpenseByUser(User user) {
		List<Expense> list = new ArrayList<Expense>();

		try {
			factory = HibernateConfig.GetSF();
			session = factory.openSession();

			Query q = session.createQuery("from Expense where user=:us");
			q.setParameter("us", user);
			list = q.list();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;

	}

	public boolean deleteExpense(int id) {
		boolean f = false;

		try {

			SessionFactory factory = HibernateConfig.GetSF();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();

			Expense expense = (Expense) session.get(Expense.class, id);
			if (expense != null) {
				session.delete(expense);
				tx.commit();
				f = true;
				return f;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return f;
	}

	
}
