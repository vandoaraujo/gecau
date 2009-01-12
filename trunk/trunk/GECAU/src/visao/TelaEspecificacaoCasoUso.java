package visao;

import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaEspecificacaoCasoUso extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel casoUsoLabel = null;
	private JComboBox casoUsoSelecionadoCombo = null;
	private JLabel jLabel = null;
	private JTextField nomeEspecificacaoField = null;
	private JLabel objetivoAtorLabel = null;
	private JTextField ObjetivoAtorField = null;
	private JLabel nomeAtorLabel = null;
	private JTextField nomeAtorField = null;
	private JLabel fluxoPrincipal = null;
	private JTextArea fluxoPrincipalCasoUso = null;
	private JLabel fluxoAlternativo = null;
	private JTextArea fluxoAlternativoArea = null;
	private JLabel fluxoExcecao = null;
	private JTextArea fluxoExceção = null;
	private JLabel regrasNegocioLabel = null;
	private JTextArea RegrasNegocioArea = null;
	private JButton cadastrarButton = null;
	private JButton cancelarButton = null;

	/**
	 * This is the default constructor
	 */
	public TelaEspecificacaoCasoUso() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(762, 572);
		this.setContentPane(getJContentPane());
		this.setTitle("EspecificacaoCasoUso");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			regrasNegocioLabel = new JLabel();
			regrasNegocioLabel.setBounds(new Rectangle(7, 419, 112, 22));
			regrasNegocioLabel.setText("Regras de Negócio:");
			fluxoExcecao = new JLabel();
			fluxoExcecao.setBounds(new Rectangle(5, 346, 95, 26));
			fluxoExcecao.setText("Fluxo Exceção:");
			fluxoAlternativo = new JLabel();
			fluxoAlternativo.setBounds(new Rectangle(8, 284, 106, 25));
			fluxoAlternativo.setText("Fluxo Alternativo:");
			fluxoPrincipal = new JLabel();
			fluxoPrincipal.setBounds(new Rectangle(7, 182, 96, 22));
			fluxoPrincipal.setText("Fluxo Principal:");
			nomeAtorLabel = new JLabel();
			nomeAtorLabel.setBounds(new Rectangle(6, 151, 73, 16));
			nomeAtorLabel.setText("NomeAtor:");
			objetivoAtorLabel = new JLabel();
			objetivoAtorLabel.setBounds(new Rectangle(5, 119, 78, 16));
			objetivoAtorLabel.setText("ObjetivoAtor:");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(14, 83, 59, 20));
			jLabel.setText("nome:");
			casoUsoLabel = new JLabel();
			casoUsoLabel.setBounds(new Rectangle(13, 35, 67, 24));
			casoUsoLabel.setText("CasoUso:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(casoUsoLabel, null);
			jContentPane.add(getCasoUsoSelecionadoCombo(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getNomeEspecificacaoField(), null);
			jContentPane.add(objetivoAtorLabel, null);
			jContentPane.add(getObjetivoAtorField(), null);
			jContentPane.add(nomeAtorLabel, null);
			jContentPane.add(getNomeAtorField(), null);
			jContentPane.add(fluxoPrincipal, null);
			jContentPane.add(getFluxoPrincipalCasoUso(), null);
			jContentPane.add(fluxoAlternativo, null);
			jContentPane.add(getFluxoAlternativoArea(), null);
			jContentPane.add(fluxoExcecao, null);
			jContentPane.add(getFluxoExceção(), null);
			jContentPane.add(regrasNegocioLabel, null);
			jContentPane.add(getRegrasNegocioArea(), null);
			jContentPane.add(getCadastrarButton(), null);
			jContentPane.add(getCancelarButton(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes casoUsoSelecionadoCombo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCasoUsoSelecionadoCombo() {
		if (casoUsoSelecionadoCombo == null) {
			casoUsoSelecionadoCombo = new JComboBox();
			casoUsoSelecionadoCombo.setBounds(new Rectangle(104, 35, 360, 25));
		}
		return casoUsoSelecionadoCombo;
	}

	/**
	 * This method initializes nomeEspecificacaoField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNomeEspecificacaoField() {
		if (nomeEspecificacaoField == null) {
			nomeEspecificacaoField = new JTextField();
			nomeEspecificacaoField.setBounds(new Rectangle(104, 79, 378, 26));
		}
		return nomeEspecificacaoField;
	}

	/**
	 * This method initializes ObjetivoAtorField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getObjetivoAtorField() {
		if (ObjetivoAtorField == null) {
			ObjetivoAtorField = new JTextField();
			ObjetivoAtorField.setBounds(new Rectangle(105, 114, 565, 20));
		}
		return ObjetivoAtorField;
	}

	/**
	 * This method initializes nomeAtorField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNomeAtorField() {
		if (nomeAtorField == null) {
			nomeAtorField = new JTextField();
			nomeAtorField.setBounds(new Rectangle(104, 143, 565, 20));
		}
		return nomeAtorField;
	}

	/**
	 * This method initializes fluxoPrincipalCasoUso	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getFluxoPrincipalCasoUso() {
		if (fluxoPrincipalCasoUso == null) {
			fluxoPrincipalCasoUso = new JTextArea();
			fluxoPrincipalCasoUso.setBounds(new Rectangle(105, 179, 560, 64));
		}
		return fluxoPrincipalCasoUso;
	}

	/**
	 * This method initializes fluxoAlternativoArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getFluxoAlternativoArea() {
		if (fluxoAlternativoArea == null) {
			fluxoAlternativoArea = new JTextArea();
			fluxoAlternativoArea.setBounds(new Rectangle(104, 279, 568, 43));
		}
		return fluxoAlternativoArea;
	}

	/**
	 * This method initializes fluxoExceção	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getFluxoExceção() {
		if (fluxoExceção == null) {
			fluxoExceção = new JTextArea();
			fluxoExceção.setBounds(new Rectangle(107, 345, 563, 48));
		}
		return fluxoExceção;
	}

	/**
	 * This method initializes RegrasNegocioArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getRegrasNegocioArea() {
		if (RegrasNegocioArea == null) {
			RegrasNegocioArea = new JTextArea();
			RegrasNegocioArea.setBounds(new Rectangle(127, 406, 543, 62));
		}
		return RegrasNegocioArea;
	}

	/**
	 * This method initializes cadastrarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCadastrarButton() {
		if (cadastrarButton == null) {
			cadastrarButton = new JButton();
			cadastrarButton.setBounds(new Rectangle(126, 491, 189, 36));
			cadastrarButton.setText("Cadastrar");
		}
		return cadastrarButton;
	}

	/**
	 * This method initializes cancelarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCancelarButton() {
		if (cancelarButton == null) {
			cancelarButton = new JButton();
			cancelarButton.setBounds(new Rectangle(343, 490, 225, 36));
			cancelarButton.setText("Cancelar");
		}
		return cancelarButton;
	}
	
	public void configuraOuvinte(ActionListener ouvinte)
	{
		casoUsoSelecionadoCombo.addActionListener(ouvinte);
		casoUsoSelecionadoCombo.setActionCommand("CasoUsoSelecionado");
		nomeEspecificacaoField.addActionListener(ouvinte);
		nomeEspecificacaoField.setActionCommand("EspecificacaoNome");
		ObjetivoAtorField.addActionListener(ouvinte);
		ObjetivoAtorField.setActionCommand("objetivoAtor");
		nomeAtorField.addActionListener(ouvinte);
		nomeAtorField.setActionCommand("ator");
		//Ouvinte para as areas
		cadastrarButton.addActionListener(ouvinte);
		cadastrarButton.setActionCommand("cadastrar");
		cancelarButton.addActionListener(ouvinte);
		cancelarButton.setActionCommand("cancelar");
		
		
		
		
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
