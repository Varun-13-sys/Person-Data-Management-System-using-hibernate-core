package com.dcl.corehibernate.controller;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dcl.corehibernate.entity.Person;

public class PersonDao {
	Scanner scan = new Scanner(System.in);
	
	// configure hibernate using an XML file (hibernate.cfg.xml) and register an annotated entity class (Person)
	Configuration cfg = new Configuration().configure().addAnnotatedClass(Person.class);
	
	// Heavy weight object, should be created once. This builds the session to interact with DB Objects
	SessionFactory sf = cfg.buildSessionFactory();
	
	public void addPerson() {
		Person person = new Person();
		Session session = sf.openSession(); // opens current session 
		Transaction trans = session.getTransaction(); // starts transaction
		
		trans.begin(); // transaction begin
		
		System.out.print("Enter the Name :");
		person.setTitle(scan.next());
		
		System.out.print("Enter Email :");
		person.setEmail(scan.next());
		
		System.out.print("Enter Age :");
		person.setAge(scan.nextInt());
		
		System.out.print("Enter Mobile :");
		person.setMobile(scan.nextLong());
		
		System.out.print("Enter City :");
		person.setCity(scan.next());
		
		session.save(person); //inbuilt method to insert the object details into database
		trans.commit(); // transaction closed
		System.out.println(person.getTitle() +"'s details Inserted Successfully");
		session.close(); // session closed
	}
	
	public void displayAllPerson() {
		Session session = sf.openSession(); 
        //List<Person> pList = session.createQuery("FROM Person",Person.class).getResultList(); // Fetch all the Person Object using HQL
		List<Person> pList = session.createNativeQuery("SELECT * FROM Person",Person.class).getResultList(); // Fetch all the Person Object using SQL
		for (Person person : pList) {
			System.out.println(person);
		}
		session.close();
	}
	
	public void findPersonById() {
		Session session = sf.openSession();
		System.out.print("Enter Id to find person :");
		Person person = session.get(Person.class, scan.nextInt());
		if(person != null) {
			System.out.println(person);
		}
		else {
			System.out.println("person not found");
		}
		session.close();
	}
	
	public void updatePersonAgeById() {
		Session session = sf.openSession();  
		Transaction trans = session.getTransaction(); 
	
		System.out.print("Enter Id :");
		Person person = session.get(Person.class, scan.nextInt()); // Fetch the Object from the Id given by user
		
		if(person != null) {
			System.out.print("Enter Age to update :");
			int age = scan.nextInt();
			
			trans.begin();
			person.setAge(age); // set the new age
			session.update(person); //update the person age
			trans.commit();
			System.out.println("Age updated successfully");
		}
		else {
			System.out.println("Age not updated");
		}
		session.close();
	}
	
	public void updatePersonCityById() {
		Session session = sf.openSession();  
		Transaction trans = session.getTransaction(); 
	
		System.out.print("Enter Id :");
		Person person = session.get(Person.class, scan.nextInt()); // Fetch the Object from the Id given by user
		
		if(person != null) {
			System.out.print("Enter City to update :");
			String city = scan.next();
			
			trans.begin();
			person.setCity(city); // set the new city
			session.update(person); //update the person's city
			trans.commit();
			System.out.println("city updated successfully");
		}
		else {
			System.out.println("city not updated");
		}
		session.close();
	}
	
	public void updatePersonEmailById() {
		Session session = sf.openSession();  
		Transaction trans = session.getTransaction(); 
	
		System.out.print("Enter Id :");
		Person person = session.get(Person.class, scan.nextInt()); // Fetch the Object from the Id given by user
		
		if(person != null) {
			System.out.print("Enter Email to update :");
			String email = scan.next();
			
			trans.begin();
			person.setEmail(email); // set the new email
			session.update(person); //update the person's email
			trans.commit();
			System.out.println("email updated successfully");
		}
		else {
			System.out.println("email not updated");
		}
		session.close();
	}
	
	public void updatePersonMobileById() {
		Session session = sf.openSession();  
		Transaction trans = session.getTransaction(); 
	
		System.out.print("Enter Id :");
		Person person = session.get(Person.class, scan.nextInt()); // Fetch the Object from the Id given by user
		
		if(person != null) {
			System.out.print("Enter Mobile to update :");
			Long mobile = scan.nextLong();
			
			trans.begin();
			person.setMobile(mobile); // set the new mobile
			session.update(person); //update the person's mobile
			trans.commit();
			System.out.println("mobile updated successfully");
		}
		else {
			System.out.println("mobile not updated");
		}
		session.close();
	}
	
	public void deletePersonById() {
		Session session = sf.openSession();  
		Transaction trans = session.getTransaction(); 
		
		System.out.print("Enter Id to delete Person :");
		Person person = session.get(Person.class, scan.nextInt()); // Fetmch the person with the given Id
		
		if(person != null) {
			trans.begin();
			session.delete(person);
			trans.commit();
			System.out.println("person deleted successfully");
		}
		else {
			System.out.println("person not deleted");
		}
		session.close();
	}	
}
