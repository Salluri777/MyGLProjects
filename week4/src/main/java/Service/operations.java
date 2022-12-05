package Service;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Entity.BookStore;
import java.util.Scanner;
public class operations {
	Scanner sc = new Scanner(System.in);
	
	// Function for adding a new book 
	
	public void AddBook(BookStore b) {
		SessionFactory factory = null;
		 factory = new Configuration()
					.configure("hibernate.cfg.xml").addAnnotatedClass(BookStore.class)
					.buildSessionFactory();
		 Session session = factory.getCurrentSession();
		 
		try {
			 session.beginTransaction();
			 session.save(b);
			 session.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			session.close();
		}
	}
	
	//Function to delete a book
	public void deleteBook(int id) {
		SessionFactory factory = null;
		 factory = new Configuration()
					.configure("hibernate.cfg.xml").addAnnotatedClass(BookStore.class)
					.buildSessionFactory();
		 Session session = factory.getCurrentSession();
		 session.beginTransaction();
		BookStore e = session.get(BookStore.class, id);
		try {
		if(e==null) {
			System.out.println("Book doesn't exists");
		}else {
			
					session.delete(e);
					session.getTransaction().commit();
			System.out.println("Book deleted successfully");
		}
		}catch(Exception m) {
			System.out.println(m);
		}finally {
			session.close();
		}
	}
	
	//Function to update a book
	public void updateBook(int id) {
		System.out.println("Please enter new information");
		System.out.println("Enter Book price");
		Float nb=sc.nextFloat();
		System.out.println("Enter number of copies sold");
		int copies=sc.nextInt();
		SessionFactory factory = null;
		 factory = new Configuration()
					.configure("hibernate.cfg.xml").addAnnotatedClass(BookStore.class)
					.buildSessionFactory();
		 Session session = factory.getCurrentSession();
		 session.beginTransaction();
		BookStore e = session.get(BookStore.class, id);
		try {
		if(e==null) {
			System.out.println("Book Doesn't exists");
		}else {
			
			e.setPrice(nb);
			e.setQuantity(copies);
			session.update(e);
			session.getTransaction().commit();
			System.out.println("Book Updated!");
		}
		}catch(Exception m) {
			System.out.println(m);
		}
		finally {
			session.close();
		}
	}
	
	//Function for displaying all available books
	public void display(){
		SessionFactory factory = null;
		 factory = new Configuration()
					.configure("hibernate.cfg.xml").addAnnotatedClass(BookStore.class)
					.buildSessionFactory();
		 Session session = factory.getCurrentSession();
		
		 try {
			 session.beginTransaction();
			 
				Query query= session.createQuery("select id,b_name from BookStore");
				List<Object[]> rows=query.getResultList();
				System.out.println("Books Information");
				for(Object[] row:rows) {
					System.out.print(row[0]+" ");
					System.out.print(row[1]);
					System.out.println();
				}
			 session.getTransaction().commit();
		 }catch (Exception e) {
				System.out.println(e);
		}finally {
				session.close();
		}
		 
	}
	// Function to retrieve books with AutoBiography Genre
	public void Genre(String gen){
		SessionFactory factory = null;
		 factory = new Configuration()
					.configure("hibernate.cfg.xml").addAnnotatedClass(BookStore.class)
					.buildSessionFactory();
		 Session session = factory.getCurrentSession();
		 try {
		 session.beginTransaction();
		Query qry2 =session.createQuery(" select B.id,B.b_name from BookStore B where B.genre=:G");
		qry2.setParameter("G", gen);
		List<Object[]> rows=qry2.getResultList();
		for(Object[] row:rows) {
			System.out.print(row[0]+" ");
			System.out.print(row[1]);
			System.out.println();
		}
		 
		session.getTransaction().commit();
		 }catch(Exception m) {
			 System.out.println(m);
		 }finally {
			 session.close();
		 }
	}

	
	//Function for getting the count of Books
	public void BooksCount() {
		SessionFactory factory = null;
		 factory = new Configuration()
					.configure("hibernate.cfg.xml").addAnnotatedClass(BookStore.class)
					.buildSessionFactory();
		 Session session = factory.getCurrentSession();
		 try {
		 session.beginTransaction();
		List<BookStore> qry =session.createQuery("from BookStore").list();
		int count=qry.size();
		System.out.println("Total number of Books: "+count);
		session.getTransaction().commit();
		 }catch(Exception m) {
			 System.out.println(m);
		 }finally {
			 session.close();
		 }
		 

}
	//Function to get the list of books in ascending order based on their price
	public void ascend(){
		SessionFactory factory = null;
		 factory = new Configuration()
					.configure("hibernate.cfg.xml").addAnnotatedClass(BookStore.class)
					.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
		session.beginTransaction();
		Query query =session.createQuery(" select b_name,price from BookStore order by price asc");
		List<Object[]> rows=query.getResultList();
		System.out.println("Books According to price Low to High");
		for(Object[] row:rows) {
			System.out.print(row[0]+" ");
			System.out.print("Price "+row[1]);
			System.out.println();
		}
		session.getTransaction().commit();
		}catch(Exception m) {
			 System.out.println(m);
		 }finally {
			 session.close();
		 }
	}
	
	//Function to get the list of books in descending order based on their price
	public void descend(){
		SessionFactory factory = null;
		 factory = new Configuration()
					.configure("hibernate.cfg.xml").addAnnotatedClass(BookStore.class)
					.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
		session.beginTransaction();
		Query query =session.createQuery(" select b_name,price from BookStore order by price desc");
		List<Object[]> rows=query.getResultList();
		System.out.println("Books According to price High to Low");
		for(Object[] row:rows) {
			System.out.print(row[0]+" ");
			System.out.print("Price "+row[1]);
			System.out.println();
		}
		session.getTransaction().commit();
		}catch(Exception m) {
			 System.out.println(m);
		 }finally {
			 session.close();
		 }
	}
	
	//Function to get the list of Best Selling books 
	public void Bestselling(){
		SessionFactory factory = null;
		 factory = new Configuration()
					.configure("hibernate.cfg.xml").addAnnotatedClass(BookStore.class)
					.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
		session.beginTransaction();
		Query query =session.createQuery(" select b_name,Quantity from BookStore order by Quantity desc");
		List<Object[]> rows=query.getResultList();
		System.out.println("Best Selling Books");
		for(Object[] row:rows) {
			System.out.print(row[0]+" ");
			System.out.print("Quantity  "+row[1]);
			System.out.println();
		}
		session.getTransaction().commit();
		}catch(Exception m) {
			 System.out.println(m);
		 }finally {
			 session.close();
		 }
	}
	
	//Function to display Book details 
	
	private static void displayBooks(List<BookStore> BookDetails) {
		for (BookStore BOOK : BookDetails) {
			System.out.println(BOOK);
		}
	}
}
