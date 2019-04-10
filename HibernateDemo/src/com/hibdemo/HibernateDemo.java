package com.hibdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateDemo {

	public static void main(String[] args) {
		Student std=new Student();
		std.setAge(23);
		std.setName("sam");
		std.setRollno(157);
		Configuration con=new Configuration().configure("Student.xml").addAnnotatedClass(Student.class);
		ServiceRegistry registry=(ServiceRegistry) new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf=con.buildSessionFactory(registry);
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(std);
		tx.commit();
		session.close();
		sf.close();
	}
}
