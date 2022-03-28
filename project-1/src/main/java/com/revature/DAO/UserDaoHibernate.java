package com.revature.DAO;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.User;
import com.revature.utils.HibernateUtil;

public class UserDaoHibernate{
	private SessionFactory sessionFactory;
	private Session session;
	
	public UserDaoHibernate() {
		sessionFactory = HibernateUtil.getHibUtil().getFactory();
	}


	public void addUser(User u) {
		session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(u);
		tran.commit();
		session.close();
	}
	
	public List<User> getAllEmp(){
		session = sessionFactory.openSession();
		TypedQuery<User> query = session.createQuery("FROM User WHERE role=0", User.class);
		List<User> uList = query.getResultList();
		return uList;
	}


	public User getUser(int id) {
		session = sessionFactory.openSession();
		TypedQuery<User> query = session.createQuery("FROM User WHERE user_id="+id, User.class);
		User user = query.getSingleResult();
		session.close();
		return user;
	}


	public User getUser(String username, String pass) {
		session = sessionFactory.openSession();
		TypedQuery<User> query = session.createQuery("FROM User WHERE username='"+username+"'", User.class);
		try{
			User user = query.getSingleResult();
			session.close();
			return user;
		}catch(NoResultException e) {
			//Add logger here
		}finally {
			session.close();
		}
		
		return null;
	}


	public void deleteUser(User u) {
		session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.delete(u);
		tran.commit();
		session.close();
	}


	public void updateUser(User u) {
		session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.update(u);
		tran.commit();
		session.close();
	}

}
