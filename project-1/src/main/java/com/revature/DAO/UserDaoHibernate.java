package com.revature.DAO;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.User;
import com.revature.utils.HibernateUtil;

public class UserDaoHibernate implements UserDAO{
	private SessionFactory sessionFactory;
	private Session session;
	
	public UserDaoHibernate() {
		sessionFactory = HibernateUtil.getHibUtil().getFactory();
	}

	@Override
	public void addUser(User u) {
		session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(u);
		tran.commit();
		session.close();
	}

	@Override
	public User getUser(int id) {
		session = sessionFactory.openSession();
		TypedQuery<User> query = session.createQuery("FROM User WHERE id="+id, User.class);
		User user = query.getSingleResult();
		session.close();
		return user;
	}

	@Override
	public User getUser(String username, String pass) {
		session = sessionFactory.openSession();
		TypedQuery<User> query = session.createQuery("FROM User WHERE username='"+username+"'", User.class);
		User user = query.getSingleResult();
		session.close();
		return user;
	}

	@Override
	public void deleteUser(User u) {
		session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.delete(u);
		tran.commit();
		session.close();
	}

	@Override
	public void updateUser(User u) {
		session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.update(u);
		tran.commit();
		session.close();
	}

}
