package dao;

import java.util.List;

import javax.swing.JOptionPane;

import modelo.Area;
import modelo.Ator;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AtorDao {

	private static Session session;
	
	private static AtorDao singleton = null;
	
	public static AtorDao getInstance(){
		//if(singleton == null)
			singleton = new AtorDao();
		return singleton;
	}
	
	private AtorDao(){
		
		session = HibernateUtil.getInstance().AbreUmaSession();
	}
	
	public void salvar(Ator ator){
		
		Transaction t = session.beginTransaction();
		session.save(ator);
		t.commit();
		session.flush();
		session.close();
		System.out.println("SALVO");
	}
	
	@Deprecated
	public Area mostraAtoresDeUmaArea(String area) {
		
		Area areaBuscada = (Area) session.createSQLQuery("from modelo.Area where nome =" + area);
		return areaBuscada;
		
	}
	

	public List<Area> listarAtores(){
		return this.session.createCriteria(Area.class).list();
	}
	
	public Ator CarregaAtor(String identificador)
	{
		Ator a = null;
		try
		{
			a = (Ator)session.load(Ator.class,identificador);
		}
		catch(ObjectNotFoundException exe){
			
			JOptionPane.showMessageDialog(null, "Código não existente!");
		}
		return a;
	}

	public void atualizar(Ator ator) {
		
		Transaction t = session.beginTransaction();
		session.update(ator);
		t.commit();
		session.flush();
		session.close();
		System.out.println("ATUALIZADO");
		
	}

	public void deletar(Ator ator) {
		
		Transaction t = session.beginTransaction();
		session.delete(ator);
		t.commit();
		session.flush();
		session.close();
		System.out.println("DELETADO");
	}
	
	
	
}
