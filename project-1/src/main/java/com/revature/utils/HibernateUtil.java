package com.revature.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.revature.beans.Reimb;

public class HibernateUtil {
	private static HibernateUtil hb = null;
	private SessionFactory sessionFactory;
	
	private HibernateUtil() {
		Configuration configure = new Configuration();
		configure.addAnnotatedClass(Reimb.class);
		
		StandardServiceRegistry registy = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(registy).buildMetadata().buildSessionFactory();
	}
	
	public static synchronized HibernateUtil getHibUtil() {
		if(hb == null) {
			hb = new HibernateUtil();
		}
		return hb;
	}
	
	public SessionFactory getFactory() {
		return sessionFactory;
	}
}
