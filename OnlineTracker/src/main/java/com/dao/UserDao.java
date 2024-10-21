package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.User;
import com.utility.HibernateConfig;

public class UserDao {

	private Session session = null;
	private Transaction tx = null;

	public boolean saveuser(User user) {
		boolean f = false;

		try {
			SessionFactory factory = HibernateConfig.GetSF();
			session = factory.openSession();
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			f = true;

		} catch (Exception e) {
			if (tx != null) {
				f = false;
				e.printStackTrace();
			}
		}

		return f;

	}

	public User login(String email, String password) {
		User u = null;
		SessionFactory factory = HibernateConfig.GetSF();

		session = factory.openSession();

		Query q = (Query) session.createQuery("from User where email=:em and password=:ps");

		q.setParameter("em", email);
		q.setParameter("ps", password);
		u = (User) ((org.hibernate.Query) q).uniqueResult();

		return u;
	}

	/**
	 * @param id
	 * @return
	 */
	public User getUserById(int id) {

		SessionFactory factory = HibernateConfig.GetSF();
		Session session = factory.openSession();

		 User user =(User) session.load(User.class, id);
		
		return user;
	}

}
