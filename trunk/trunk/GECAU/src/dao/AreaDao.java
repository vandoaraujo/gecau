package dao;

import java.util.List;

import javax.swing.JOptionPane;

import modelo.Area;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class AreaDao {

	private static Session session;
	// Singleton
	private static AreaDao singleton = null;
	
	
	public static AreaDao getInstance(){
		singleton = new AreaDao();
		return singleton;
		
	}
	
	private AreaDao(){
		session = HibernateUtil.getInstance().AbreUmaSession();
	}
	
	public void fechaSession(){
		session.close();
	}
	
	
	
	public void salvar(Area area){
		
		Transaction t = session.beginTransaction();
		session.save(area);
		t.commit();
		session.flush();
		session.close();
		JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
		
	}

	@Deprecated
	public List<Area> listar(){
		Criteria c = session.createCriteria(Area.class);
		return c.list(); 
	}
	
	public List<Area> listar3(){
		List<Area> l = session.createQuery("from modelo.Area").list();
		return l;
		
	}
	
	
	
	public List<Area> listarAreaNome(String nome){
				
		Criteria c = session.createCriteria(Area.class);
		c.add(Restrictions.like("nome", nome));
		
		//Area a = (Area) c.setMaxResults(1);
		List<Area> a = c.list();
		session.close();
		
		return a;		
		
	}
	
	
	public List<Area> listarUmaAreaNome(String nome){
				
		Criteria c = session.createCriteria(Area.class);
		c.add(Restrictions.like("nome", nome));
		c.setMaxResults(1);
		List l = c.list();
		return l;		
		
	}
	
	
	
	@Deprecated
	public List<Area> listar2(){
		return this.session.createCriteria(Area.class).list();
	}
	
}
