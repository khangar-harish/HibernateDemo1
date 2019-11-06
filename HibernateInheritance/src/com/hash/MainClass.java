package com.hash;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("unused")
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		System.out.println(System.getProperty("user.dir"));
		Configuration cfg = new Configuration().configure("resources/hibernate.cfg.xml");
		//		.addFile("resources/student.hbm.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();
		Student st1 = new Student();
		st1.setName("harry");
		st1.setEmail("h@gmail.com");
		
		Student st2 = new Student();
		st2.setName("dany");
		st2.setEmail("d@gmail.com");
		
		ss.persist(st1);
		ss.persist(st2);
		
		t.commit();
		System.out.println("Record inserted successfully");
		sf.close();
		ss.close();
	}

}
