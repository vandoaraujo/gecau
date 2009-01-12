package visao;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class TelaRequisito extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel areaSelecionada = null;
	private JList AtoresEmPotencial	= null;
	private JList atoresEscolhidosParaRequisitoAtual = null;
	private JButton selecionaAtor = null;
	private JButton removeAtor = null;
	private JLabel requisito = null;
	private JTextField requisitoField = null;
	private JLabel atorLabel = null;
	private JButton botaoMaisUmRequisito = null;
	private JButton FinalizacaoRequisitoButton = null;
	private JButton cancelaRequisito = null;
	private JComboBox areaAtual = null;
	private JComboBox projetoAtual = null;
	private JLabel nomeProjeto = null;
	/**
	 * This is the default constructor
	 */
	public TelaRequisito() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(625, 370);
		this.setContentPane(getJContentPane());
		this.setTitle("Cadastro de Requisitos");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			nomeProjeto = new JLabel();
			nomeProjeto.setBounds(new Rectangle(13, 12, 105, 25));
			nomeProjeto.setText("Nome Projeto:");
			atorLabel = new JLabel();
			atorLabel.setBounds(new Rectangle(13, 143, 338, 27));
			atorLabel.setText("Selecione na lista abaixo o ator referente a este requisito");
			requisito = new JLabel();
			requisito.setBounds(new Rectangle(7, 96, 120, 28));
			requisito.setText("Preencher requisito:");
			areaSelecionada = new JLabel();
			areaSelecionada.setBounds(new Rectangle(11, 55, 98, 27));
			areaSelecionada.setText("Area escolhida: ");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(areaSelecionada, null);
			jContentPane.add(getAtores(), null);
			jContentPane.add(getAtoresEscolhidosParaRequisitoAtual(), null);
			jContentPane.add(getSelecionaAtor(), null);
			jContentPane.add(getRemoveAtor(), null);
			jContentPane.add(requisito, null);
			jContentPane.add(getRequisitoField(), null);
			jContentPane.add(atorLabel, null);
			jContentPane.add(getBotaoMaisUmRequisito(), null);
			jContentPane.add(getFinalizacaoRequisitoButton(), null);
			jContentPane.add(getCancelaRequisito(), null);
			jContentPane.add(getAreaAtual(), null);
			jContentPane.add(getProjetoAtual(), null);
			jContentPane.add(nomeProjeto, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes Atores	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getAtores() {
		if (AtoresEmPotencial == null) {
			AtoresEmPotencial = new JList();
			AtoresEmPotencial.setBounds(new Rectangle(13, 182, 235, 74));
		}
		return AtoresEmPotencial;
	}

	/**
	 * This method initializes atoresEscolhidosParaRequisitoAtual	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getAtoresEscolhidosParaRequisitoAtual() {
		if (atoresEscolhidosParaRequisitoAtual == null) {
			atoresEscolhidosParaRequisitoAtual = new JList();
			atoresEscolhidosParaRequisitoAtual.setBounds(new Rectangle(334, 182, 241, 77));
		}
		return atoresEscolhidosParaRequisitoAtual;
	}

	/**
	 * This method initializes selecionaAtor	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSelecionaAtor() {
		if (selecionaAtor == null) {
			selecionaAtor = new JButton();
			selecionaAtor.setBounds(new Rectangle(263, 187, 57, 27));
			selecionaAtor.setText("->");
		}
		return selecionaAtor;
	}

	/**
	 * This method initializes removeAtor	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getRemoveAtor() {
		if (removeAtor == null) {
			removeAtor = new JButton();
			removeAtor.setBounds(new Rectangle(262, 226, 57, 31));
			removeAtor.setText("< --");
		}
		return removeAtor;
	}

	/**
	 * This method initializes requisitoField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getRequisitoField() {
		if (requisitoField == null) {
			requisitoField = new JTextField();
			requisitoField.setBounds(new Rectangle(132, 98, 416, 24));
		}
		return requisitoField;
	}

	/**
	 * This method initializes botaoMaisUmRequisito	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBotaoMaisUmRequisito() {
		if (botaoMaisUmRequisito == null) {
			botaoMaisUmRequisito = new JButton();
			botaoMaisUmRequisito.setBounds(new Rectangle(14, 281, 210, 32));
			botaoMaisUmRequisito.setText("Cadastrar mais requisitos");
		}
		return botaoMaisUmRequisito;
	}

	/**
	 * This method initializes FinalizacaoRequisitoButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getFinalizacaoRequisitoButton() {
		if (FinalizacaoRequisitoButton == null) {
			FinalizacaoRequisitoButton = new JButton();
			FinalizacaoRequisitoButton.setBounds(new Rectangle(234, 281, 204, 33));
			FinalizacaoRequisitoButton.setText("Finalizar Cadastro");
		}
		return FinalizacaoRequisitoButton;
	}

	/**
	 * This method initializes cancelaRequisito	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCancelaRequisito() {
		if (cancelaRequisito == null) {
			cancelaRequisito = new JButton();
			cancelaRequisito.setBounds(new Rectangle(453, 281, 138, 33));
			cancelaRequisito.setText("Cancela");
		}
		return cancelaRequisito;
	}
	
	public void configuraOuvinte(ActionListener ouvinte)
	{
		cancelaRequisito.addActionListener(ouvinte);
		cancelaRequisito.setActionCommand("cancela");
		FinalizacaoRequisitoButton.addActionListener(ouvinte);
		FinalizacaoRequisitoButton.setActionCommand("finaliza");
		botaoMaisUmRequisito.addActionListener(ouvinte);
		botaoMaisUmRequisito.setActionCommand("maisUmRequisito");
		requisitoField.addActionListener(ouvinte);
		requisitoField.setActionCommand("requisito");
		//Ouvinte para JTextArea
		selecionaAtor.addActionListener(ouvinte);
		selecionaAtor.setActionCommand("seleciona");
		removeAtor.addActionListener(ouvinte);
		removeAtor.setActionCommand("remove");
		
	}

	/**
	 * This method initializes areaAtual	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getAreaAtual() {
		if (areaAtual == null) {
			areaAtual = new JComboBox();
			areaAtual.setBounds(new Rectangle(132, 53, 414, 26));
		}
		return areaAtual;
	}

	/**
	 * This method initializes projetoAtual	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getProjetoAtual() {
		if (projetoAtual == null) {
			projetoAtual = new JComboBox();
			projetoAtual.setBounds(new Rectangle(132, 11, 413, 28));
		}
		return projetoAtual;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
