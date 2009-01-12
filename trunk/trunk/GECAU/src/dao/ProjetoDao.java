package dao;

import java.util.List;

import javax.swing.JOptionPane;

import modelo.Projeto;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class ProjetoDao {
	
	private static Session session;
	// Singleton
	private static ProjetoDao singleton = null;
	
	
	public static ProjetoDao getInstance(){
		singleton = new ProjetoDao();
		return singleton;
		
	}
	
	private ProjetoDao(){
		session = HibernateUtil.getInstance().AbreUmaSession();
	}
	
	public void fechaSession(){
		session.close();
	}
		
	public void salvar(Projeto projeto){
		
		Transaction t = session.beginTransaction();
		session.save(projeto);
		t.commit();
		session.flush();
		session.close();
		JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
		
	}

	public List<Projeto> listar(){
		List<Projeto> l = session.createQuery("from modelo.Projeto").list();
		return l;
		
	}
	
	public List<Projeto> listarProjetosNome(String nome){
				
		Criteria c = session.createCriteria(Projeto.class);
		c.add(Restrictions.like("nome", nome));
		
		//Area a = (Area) c.setMaxResults(1);
		List<Projeto> a = c.list();
		session.close();
		
		return a;		
		
	}
	
	public Projeto listarUmProjetoNome(String nome){
				
		Criteria c = session.createCriteria(Projeto.class);
		c.add(Restrictions.like("nome", nome));
		
		Projeto p = (Projeto) c.setMaxResults(1);
		return p;		
		
	}
		

}
