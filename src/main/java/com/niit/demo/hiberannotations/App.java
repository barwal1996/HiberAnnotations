package com.niit.demo.hiberannotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	try{Configuration configuration = new Configuration();
   	 	configuration.configure("hibernate.cfg.xml");
   	 	
   	 	SessionFactory factory= configuration.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
   	 	
   	 Session sess = factory.openSession();
	  sess.beginTransaction();
	  
	  Employee e1= new Employee();
	  e1.setId(5);
	  e1.setFirstname("Amit");
	  e1.setLastname("Barwal");
	  
	  sess.save(e1);
	  sess.getTransaction().commit();
	  System.out.println("Successfully printed");
	  sess.close();
	  factory.close();}catch(Exception e) {System.out.println(e.getMessage());}
	  
        //System.out.println( "Hello World!" );
    }
}
