package visao;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Area;
import modelo.Projeto;

public class TelaAbrirProjeto extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JComboBox projetosCombo = null;
	private JLabel selecioneProjeto = null;
	private JButton carregarProjeto = null;

	/**
	 * This is the default constructor
	 */
	public TelaAbrirProjeto() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(545, 273);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		this.setLocationRelativeTo(null);

	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			selecioneProjeto = new JLabel();
			selecioneProjeto.setBounds(new Rectangle(19, 73, 164, 25));
			selecioneProjeto.setText("Selecione Projeto:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getProjetosCombo(), null);
			jContentPane.add(selecioneProjeto, null);
			jContentPane.add(getCarregarProjeto(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes projetosCombo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getProjetosCombo() {
		if (projetosCombo == null) {
			projetosCombo = new JComboBox();
			projetosCombo.setBounds(new Rectangle(193, 74, 310, 27));
		}
		return projetosCombo;
	}

	/**
	 * This method initializes carregarProjeto	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCarregarProjeto() {
		if (carregarProjeto == null) {
			carregarProjeto = new JButton();
			carregarProjeto.setBounds(new Rectangle(177, 165, 158, 34));
			carregarProjeto.setText("Carregar Projeto");
		}
		return carregarProjeto;
	}
	
	public void configuraOuvinte(ActionListener ouvinte)
	{
		carregarProjeto.addActionListener(ouvinte);
		carregarProjeto.setActionCommand("abrirProjeto");
	}
	
	public String recebeProjeto()
	{
		String nomeProjeto = projetosCombo.getSelectedItem().toString();
		return nomeProjeto;
	}
	
	public void escreveProjetos(List<Projeto> projetos)
	{	
				
		// Zera as entradas do combobox
		projetosCombo.removeAllItems();
		
		// Para cada area
		for (Projeto projetoAtual : projetos) 
		{
			// Adiciona no combobox
			projetosCombo.addItem(projetoAtual.getNome());
		}
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
