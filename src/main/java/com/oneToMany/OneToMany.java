package com.oneToMany;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class OneToMany {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Vendor vendor = new Vendor();
		vendor.setVendorId(102);
		vendor.setVendorName("Amit shrivastva");
		
		Customer customer = new Customer();
		customer.setCustomerId(601);
		customer.setCustomerName("raj kumar");
		
		Customer customer2 = new Customer();
		customer2.setCustomerId(602);
		customer2.setCustomerName("ramesh kumar");
		
		Customer customer3 = new Customer();
		customer3.setCustomerId(603);
		customer3.setCustomerName("krish kumar");
		
		Set set = new HashSet();
		set.add(customer);
		set.add(customer2);
		set.add(customer3);
		
		vendor.setChildren(set);

		Transaction transaction = session.beginTransaction();
		/*insert operation*/
		//session.save(vendor);
		
		/*delete operation*/
		/*Query query = session.createQuery("from Vendor v");
		List list = query.list();
		
		Iterator iterator = list.iterator();
		while(iterator.hasNext()) {
			Object obj = iterator.next();
			Vendor vend = (Vendor)obj;
			//session.delete(vend);
			System.out.println(vend);
		}*/
		/*Vendor vendor2 = session.get(Vendor.class, 101);
		System.out.println(vendor2.getVendorId());
		System.out.println(vendor2.getVendorName());
		Set st = vendor2.getChildren();*/
		Query query = session.createQuery("from Vendor v");
		List list = query.list();
		Iterator iterator2 = list.iterator(); 
		
		while(iterator2.hasNext()) {
			Object obj1 = iterator2.next();
			Vendor ven = (Vendor) obj1;
			System.out.println("***********************************************");
			System.out.println(ven.getVendorId()+"______________"+ven.getVendorName());
			Set st = ven.getChildren();
			
			Iterator iterator = st.iterator();
			while(iterator.hasNext()) {
				System.out.println("---------------------------------------------------------------");
				System.out.println("Customer object");
				System.out.println("---------------------------------------------------------------");
				Object obj = iterator.next();
				Customer cus = (Customer) obj;
				
				System.out.println(cus.getCustomerId());
				System.out.println(cus.getCustomerName());
				System.out.println(cus.getForevenId());
				
			}
		}
		
		
		
		
		
		
		transaction.commit();
		//System.out.println("All object are deleted...");
		//System.out.println("one to many done...");
		
		session.close();
		factory.close();
		
		
	}
}
