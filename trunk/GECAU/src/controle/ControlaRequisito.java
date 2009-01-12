package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visao.TelaCadastroProjeto;
import visao.TelaRequisito;

public class ControlaRequisito implements ActionListener{
	
	private static ControlaRequisito singleton = null;
	
	TelaRequisito tr;
	
	public static ControlaRequisito getInstance()
	{
		if(singleton==null)
			singleton = new ControlaRequisito();
		return singleton;
	}
	
	private ControlaRequisito(){
		
	}
	
	public void actionPerformed(ActionEvent eve) {
		
		String comando = eve.getActionCommand();
		
		if(comando.equals("cancela")){
			
		}
		else if(comando.equals("finaliza")){
			
		}
		else if(comando.equals("maisUmRequisito")){
			
		}
		else if(comando.equals("areaAtual")){
			
		}
		else if(comando.equals("requisito")){
			
		}
		else if(comando.equals("seleciona")){
			
		}
		else if(comando.equals("remove")){
			
		}
		else {
			throw new IllegalArgumentException("FALTA OUVINTE PARA TEXT AREA");
		}
		//Ouvinte para JTextArea
		
			
	}

	public void habilitaTelaRequisito() {
		
		tr.setResizable(false);
		tr.setModal(true);
		tr.setVisible(true);
				
		
	}

	public void configuraTela(TelaRequisito tr2) {
		this.tr=tr2;
		tr2.configuraOuvinte(this);
		tr2.setLocationRelativeTo(null);
		
	}
	
}

