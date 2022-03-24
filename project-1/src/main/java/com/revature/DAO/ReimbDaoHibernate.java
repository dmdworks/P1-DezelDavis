package com.revature.DAO;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Reimb;
import com.revature.utils.HibernateUtil;

public class ReimbDaoHibernate implements ReimbDAO{
	private SessionFactory sessionFactory;
	private Session session;
	
	public ReimbDaoHibernate() {
		sessionFactory = HibernateUtil.getHibUtil().getFactory();
	}
	
	@Override
	public void addReimb(Reimb r) {
		session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(r);
		tran.commit();
		session.close();
	}

	@Override
	public List<Reimb> getReimbsByUser(int id) {
		session = sessionFactory.openSession();
		TypedQuery<Reimb> query = session.createQuery("FROM Reimb WHERE authorId="+id, Reimb.class);
		List<Reimb> reimb = query.getResultList();
		session.close();
		return reimb;
	}

	@Override
	public List<Reimb> getAllReimbs() {
		session = sessionFactory.openSession();
		TypedQuery<Reimb> query = session.createQuery("FROM Reimb", Reimb.class);
		List<Reimb> reimb = query.getResultList();
		session.close();
		return reimb;
	}

	@Override
	public void deleteReimb(Reimb r) {
		session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.delete(r);
		tran.commit();
		session.close();
	}

	@Override
	public void updateReimb(Reimb r) {
		session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.delete(r);
		tran.commit();
		session.close();
	}

}
