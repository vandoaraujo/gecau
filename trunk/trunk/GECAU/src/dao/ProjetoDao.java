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
	
	public Projeto listarProjetosNome(String nome){
		
		Transaction tx = session.beginTransaction();  
		Projeto proj = (Projeto) session.createQuery("from modelo.Projeto u where u.nome=:projectName").setString("projectName", nome).uniqueResult();  
		tx.commit();
		
		return proj;		
		
	}
	
	public Projeto listarUmProjetoNome(String nome){
				
		Criteria c = session.createCriteria(Projeto.class);
		c.add(Restrictions.like("nome", nome));
		
		Projeto p = (Projeto) c.setMaxResults(1);
		return p;		
		
	}
		

}
