package dao;

import modelo.Area;
import modelo.Ator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import controle.ControlaGECAU;

public class HibernateUtil {
	
	private static SessionFactory factory;
		
	private static SessionFactory sessionFactory;

	private static Session session;
	
	private static HibernateUtil singleton = null;
	
	public static HibernateUtil getInstance(){
		if(singleton==null){
			singleton= new HibernateUtil();
	}
			return singleton;
	}
	
	private HibernateUtil(){
		
		AnnotationConfiguration conf = new AnnotationConfiguration();
		conf.configure();
		conf.addAnnotatedClass(Ator.class);
		conf.addAnnotatedClass(Area.class);
		factory = conf.buildSessionFactory();	
		
	}
	
	public static void closeSession() {
		session.close();
		}
		
		
	public Session AbreUmaSession(){
		
		if (session == null || !session.isOpen() || !session.isConnected()) {
			session = ((SessionFactory) factory).openSession();
			}
			return session;
	}
	
	

}
