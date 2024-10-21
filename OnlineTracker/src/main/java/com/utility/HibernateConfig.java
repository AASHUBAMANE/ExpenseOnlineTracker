package com.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Expense;
import com.entity.User;

public class HibernateConfig {

	public static SessionFactory GetSF() {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Expense.class);
		
		@SuppressWarnings("deprecation")
		SessionFactory sf = cfg.configure().
				buildSessionFactory();

		return sf;
	}

}
