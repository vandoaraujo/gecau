package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import org.apache.log4j.Logger;

import visao.TelaEspecificacaoCasoUso;

public class ControlaEspecificacao implements ActionListener{

	//static Logger logger = Logger.getLogger(ControlaEspecificacao.class);
	
	private static ControlaEspecificacao singleton = null;
	
	private TelaEspecificacaoCasoUso tecc;
	
	public static ControlaEspecificacao getInstance(){
		if(singleton ==null)
			singleton = new ControlaEspecificacao();
		return singleton;
		
	}
	
	public void configuraTela(TelaEspecificacaoCasoUso te)
	{
		this.tecc=te;
		te.configuraOuvinte(this);
		te.setResizable(false);
		te.setLocationRelativeTo(null);
				
	}
	
	public void habilitaTelaEspecificacaoCasoUso()
	{
		tecc.setModal(true);
		tecc.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
