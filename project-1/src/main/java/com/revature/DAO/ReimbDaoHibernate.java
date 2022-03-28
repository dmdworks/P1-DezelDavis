package com.revature.DAO;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Reimb;
import com.revature.beans.User;
import com.revature.utils.HibernateUtil;

public class ReimbDaoHibernate{
	private SessionFactory sessionFactory;
	private Session session;
	
	public ReimbDaoHibernate() {
		sessionFactory = HibernateUtil.getHibUtil().getFactory();
	}
	
	public void addReimb(Reimb r) {
		session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(r);
		tran.commit();
		session.close();
	}
	
	public Reimb getReimb(int id) {
		session = sessionFactory.openSession();
		TypedQuery<Reimb> query = session.createQuery("FROM Reimb WHERE reimb_id="+id, Reimb.class);
		Reimb reimb = query.getSingleResult();
		session.close();
		return reimb;
	}

	public List<Reimb> getReimbsByUser(int id) {
		session = sessionFactory.openSession();
		TypedQuery<Reimb> query = session.createQuery("FROM Reimb WHERE user_id="+id, Reimb.class);
		List<Reimb> reimb = query.getResultList();
		session.close();
		return reimb;
	}
	
	public List<Reimb> getReimbsByPending() {
		session = sessionFactory.openSession();
		TypedQuery<Reimb> query = session.createQuery("FROM Reimb WHERE status=0", Reimb.class);
		List<Reimb> reimb = query.getResultList();
		session.close();
		return reimb;
	}
	
	public List<Reimb> getReimbsByPending(int id) {
		session = sessionFactory.openSession();
		TypedQuery<Reimb> query = session.createQuery("FROM Reimb WHERE status=0 AND user_id="+id, Reimb.class);
		List<Reimb> reimb = query.getResultList();
		session.close();
		return reimb;
	}
	
	public List<Reimb> getReimbsByResolved() {
		session = sessionFactory.openSession();
		TypedQuery<Reimb> query = session.createQuery("FROM Reimb WHERE status=1 OR status=2", Reimb.class);
		List<Reimb> reimb = query.getResultList();
		session.close();
		return reimb;
	}
	
	public List<Reimb> getReimbsByResolved(int id) {
		session = sessionFactory.openSession();
		TypedQuery<Reimb> query = session.createQuery("FROM Reimb WHERE (status=1 OR status=2) AND user_id="+id, Reimb.class);
		List<Reimb> reimb = query.getResultList();
		session.close();
		return reimb;
	}

	public List<Reimb> getAllReimbs() {
		session = sessionFactory.openSession();
		TypedQuery<Reimb> query = session.createQuery("FROM Reimb", Reimb.class);
		List<Reimb> reimb = query.getResultList();
		session.close();
		return reimb;
	}

	public void deleteReimb(Reimb r) {
		session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.delete(r);
		tran.commit();
		session.close();
	}

	public void updateReimb(Reimb r) {
		session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.update(r);
		tran.commit();
		session.close();
	}

}
