package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.HibernateUtil;

//import org.apache.log4j.Logger;
import visao.TelaPrincipal;

public class ControlaGECAU implements ActionListener {
	
	//static Logger logger = Logger.getLogger(ControlaGECAU.class);
	
	
	
	TelaPrincipal vc;

	private String areaSelecionada;
	
	/**
	 * a Classe Exec.java que contém a main chama a referencia do ControlaGECAU, caso seja a 1 vez, instancia o objeto
	 *
	 * @author Vando e Walter
	 * 
	 */
	private static ControlaGECAU singleton=null;
	
	public static ControlaGECAU getInstance(){
		if(singleton==null){
			singleton= new ControlaGECAU();
		}
			return singleton;
	}
		
	private ControlaGECAU() {
	}
	
	public void configuraTela(TelaPrincipal vc){
		//logger.isDebugEnabled();
		this.vc=vc;
		vc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vc.configuraOuvinte(this);	
		
		
		//vc.setResizable(false);
		//vc.setLocationRelativeTo(null);
	}
		
	public void habilita(){
		vc.setVisible(true);
	}
			

	public void actionPerformed(ActionEvent eve) {
		// TODO Auto-generated method stub
		
		String comando = eve.getActionCommand();
		
		
		if(comando.equals(("novoProjeto")))
		{
			comandoNovoProjeto();
		}
		else if(comando.equals("abrirProjeto"))
		{
				try {
					comandoAbrirProjeto();
				} catch (IOException e) {
					System.out.println("Arquivo não encontrado ou fora do formato");
					//logger.error("Arquivo não encontrado ou fora do formato");
				}		
		}
		else if(comando.equals("novoRequisito"))
		{
			comandoNovoRequisito();
		}
		else if(comando.equals("novaArea"))
		{
			comandoEditaAtor(areaSelecionada, comando);
		}
		else if(comando.equals("editaAtorArea"))
		{
				
			comandoNovaArea();
					
		}
		else if(comando.equals("gerar"))
		{
			
		}	
		else if(comando.equals("especificar"))
		{
			comandoEspecificar();
		}
		else if(comando.equals("alterarEspecificacao"))
		{
			
		}
		
				
	}
	


	private void comandoEspecificar() {
		ControlaEspecificacao.getInstance().habilitaTelaEspecificacaoCasoUso();
	}

	private void comandoAbrirProjeto() throws IOException {
		
			FileReader fr = null;
			BufferedReader br = null; 
			File arquivo=vc.escolheArquivo();
			try{
				
				if(!(arquivo==null)){
					//abre um leitor sobre o arquivo escolhido
					fr=new FileReader(arquivo);
					br=new BufferedReader(fr);
					br.close();
					fr.close();
				}
			}	
			catch(FileNotFoundException fe)
			{
				//logger.fatal("ERRO DE ARQUIVO!");
			}
			finally
			{
				
			}
		
	}
	
	//Utiliza esta lógica para dois menus, área e ator
	public void comandoEditaAtor(String areaSelecionada, String comando) {
		
		if(comando.equals("insercao"))
		ControlaAtor.getInstance().incluiAtor(areaSelecionada);
		else if (comando.equals("alteracao"))
		ControlaAtor.getInstance().alteraAtor(areaSelecionada);
		else if (comando.equals("exclusao"))
		ControlaAtor.getInstance().deletaAtor(areaSelecionada);
		else if(comando.equals("novaArea"))
		ControlaArea.getInstance().insereAreaAtravesMenuPrincipal();
			
			
	}

	private void comandoNovaArea() {
		
		ControlaArea.getInstance().habilitaTelaArea();
		
	}
	
	private void comandoNovoRequisito() {
	
		ControlaRequisito.getInstance().habilitaTelaRequisito();
	
	}

	public void comandoNovoProjeto(){
		
		
		ControlaProjeto.getInstance().habilitaTelaCadastro();
	}

}
