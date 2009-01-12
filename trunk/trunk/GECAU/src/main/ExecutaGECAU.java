package main;

//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import visao.TelaCadastroProjeto;
import visao.TelaEspecificacaoCasoUso;
import visao.TelaManterArea;
import visao.TelaManterAtor;
import visao.TelaNovaArea;
import visao.TelaPrincipal;
import visao.TelaRequisito;
import controle.ControlaArea;
import controle.ControlaAtor;
import controle.ControlaEspecificacao;
import controle.ControlaGECAU;
import controle.ControlaProjeto;
import controle.ControlaRequisito;
import dao.HibernateUtil;


public class ExecutaGECAU {

	static Logger logger = Logger.getLogger(ExecutaGECAU.class);
    
	
	public static void main(String args []) throws Exception
	{
		//inicializa o sistema de logging com as configurações padrão.
		BasicConfigurator.configure();
		
		//Configura o Nivel que irá aparecer no Console
		logger.setLevel(Level.INFO);
		
		  
		//logger.info("Inicializando");
		
		
		//Faz chamada ao Banco de Dados instanciando uma SessionFactory
		HibernateUtil h = HibernateUtil.getInstance();
		
			
		TelaPrincipal tp = new TelaPrincipal();
		ControlaGECAU.getInstance().configuraTela(tp); 
		ControlaGECAU.getInstance().habilita();		
				
		TelaCadastroProjeto tcp = new TelaCadastroProjeto();
		ControlaProjeto.getInstance().configuraTela(tcp);
				
		TelaRequisito tr = new TelaRequisito();
		ControlaRequisito.getInstance().configuraTela(tr);
		
		TelaManterArea tm = new TelaManterArea();
		TelaNovaArea tna = new TelaNovaArea();
		ControlaArea.getInstance().configuraTela(tm);
		ControlaArea.getInstance().configuraNovaAreaTela(tna);
		
		TelaManterAtor tma = new TelaManterAtor();
		ControlaAtor.getInstance().configuraTela(tma);
		
		TelaEspecificacaoCasoUso te = new TelaEspecificacaoCasoUso();
		ControlaEspecificacao.getInstance().configuraTela(te);
		
	
		//logger.info("objetos instanciados");
		
		//Hibernate
		
		
			
		
	}
}
