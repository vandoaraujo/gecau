package main;

import java.util.ArrayList;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import modelo.Area;
import modelo.Ator;
import modelo.Especificacao;
import modelo.Projeto;
import modelo.Requisito;
import modelo.UseCase;

public class TestaAssociacao {
	
	private static SessionFactory fabrica;
	private static AnnotationConfiguration cfg;
	
	public static void main(String args []){
		
		
		cfg = new AnnotationConfiguration();
		cfg.configure();
		
		//É preciso configurar as classes que possuem as anotações
		cfg.addAnnotatedClass(Ator.class);
		cfg.addAnnotatedClass(Area.class);
		
		fabrica = cfg.buildSessionFactory();

		
		Area a = new Area();
		a.setNome("Gerencia");
		
		
		Ator at1 = new Ator();
		try {
			at1.setNome("Gerente");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		at1.setAreaId(a);
		
			
		Ator at2 = new Ator();
		try {
			at2.setNome("Presidente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		at2.setAreaId(a);
		
		a.setAtores(new HashSet<Ator>());
		
			
		a.getAtores().add(at1);
		a.getAtores().add(at2);
			
		
		Session s = fabrica.openSession();
		Transaction t = s.beginTransaction();
		s.save(a);
		t.commit();
		s.flush();
		s.close();
		System.out.println("SALVO");
		
		
		
		
		
	}

}
