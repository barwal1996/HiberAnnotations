package com.niit.demo.hiberannotations;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class OneToOne1 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session sess= factory.openSession();
		sess.beginTransaction();
		
		Customer c1 = new Customer();
		c1.setName("Monika");
		c1.setEmail("Geller@gmail.com");
		
		Address a1= new Address();
		a1.setAddressLine1("central park");
		a1.setCity("Goa");
		a1.setCountry("India");
		a1.setState("Delhi");
		a1.setPincode(142062);
		
		c1.setAddress(a1);
		a1.setCustomer(c1);
		
		sess.persist(c1); //updates project if any before its commmitted
		sess.getTransaction().commit();
		
		System.out.println("Table Created & Record successfully Inserted"+"<br>");

		System.out.println("<br>"+"*********** Display Data ************"+"<br>");
		TypedQuery<Customer> query=sess.createQuery("from Customer",Customer.class);    
		List<Customer> list=query.getResultList();   
		    
		Iterator<Customer> itr=list.iterator();    
		while(itr.hasNext()){    
		 Customer cust=itr.next();    
		 System.out.println("<br>"+cust.getCustomerId()+" "+cust.getName()+" "+cust.getEmail());    
		 Address address=cust.getAddress();    
		 System.out.println(address.getAddressLine1()+" "+address.getCity()+" "+    
		    address.getState()+" "+address.getCountry()+" "+address.getPincode());    
		}    
		sess.close();    
		System.out.println("<br>"+"success");

		
		


	}

}
