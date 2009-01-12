package dao;

import java.io.Serializable;

import main.ExecutaGECAU;
import modelo.*;
//import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class HibernateDao {
	
	private SessionFactory fabrica;
	private AnnotationConfiguration cfg;
	
	
	//static Logger logger = Logger.getLogger(HibernateDao.class);
	
     
    /*private enum Action {
        INSERT, UPDATE, DELETE;
    }*/
	
	public HibernateDao() throws Exception{
				
		cfg = new AnnotationConfiguration();
		cfg.configure();
		
		//É preciso configurar as classes que possuem as anotações
		cfg.addAnnotatedClass(Ator.class);
		cfg.addAnnotatedClass(Area.class);
		cfg.addAnnotatedClass(Especificacao.class);
		cfg.addAnnotatedClass(Projeto.class);
		cfg.addAnnotatedClass(Requisito.class);
		cfg.addAnnotatedClass(UseCase.class);
		
		System.out.println("ERRO não ocorreu aqui");
				
		// Cria uma fábrica de Sessoes ao iniciar o construtor. Essa Classe é muito pesada, é multi-thread
		// e por isso deve ser inicializada apenas uma vez para não comprometer o desempenho
		fabrica = cfg.buildSessionFactory();
	
		
				
	}
	 
    
    private enum Action {
        INSERT, UPDATE, DELETE;
    }
	
    
    public void save(Object obj) throws Exception
    {
        executeAction(obj, Action.INSERT);
    }
    
    public void update(Object obj) throws Exception
    {
        executeAction(obj, Action.UPDATE);
    }
    
    public void delete(Object obj) throws Exception
    {
        executeAction(obj, Action.DELETE);
    }
    
    private void executeAction(Object obj, Action action) throws Exception
    {
        if (action == null)
            throw new IllegalArgumentException("Action not defined");
        if (obj == null)
            throw new IllegalArgumentException("Null object");
        
        
        Session session = null;
        try
        {
            session = fabrica.openSession();
            session.beginTransaction();
            
            switch (action)
            {
                case INSERT:
                    session.save(obj);                    
                
                    break;
                case UPDATE:
                    session.update(obj);
                  
                    break;
                case DELETE:
                    session.delete(obj);
                
                    break;
            }            
            session.getTransaction().commit();
        }
        catch (HibernateException ex)
        {
            if (session != null && session.getTransaction().isActive())
                session.getTransaction().rollback();
                        
            throw ex;
        }
        finally
        {
            if (session != null && session.isOpen())
                session.close();            
        }
    }
    
    public void loadObject(Object obj, Serializable id) throws Exception, HibernateException
    {
        if (obj == null)
            throw new IllegalArgumentException("Null object");
        if (id == null)
            throw new IllegalArgumentException("Null id");
        
        Session session = null;
        try
        {
            session = fabrica.openSession();
            session.load(obj, id);
        }
        catch (HibernateException ex)
        {
            
            throw ex;
        }
    }
    
	

}
