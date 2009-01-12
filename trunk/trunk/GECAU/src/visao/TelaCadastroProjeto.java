package visao;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import modelo.Area;
import controle.ControlaProjeto;


public class TelaCadastroProjeto extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel nomeLabel = null;
	private JTextField nome = null;
	private JLabel areaProjeto = null;
	private JComboBox areaEscolhida = null;
	private JButton ok = null;
	private JButton cancela = null;

	/**
	 * This is the default constructor
	 */
	public TelaCadastroProjeto() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(538, 324);
		this.setContentPane(getJContentPane());
		this.setTitle("Cadastro de Projetos");
		this.setLocationRelativeTo(null);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			areaProjeto = new JLabel();
			areaProjeto.setBounds(new Rectangle(6, 95, 100, 23));
			areaProjeto.setText("Area do projeto");
			nomeLabel = new JLabel();
			nomeLabel.setBounds(new Rectangle(7, 50, 89, 23));
			nomeLabel.setText("NomeProjeto");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(nomeLabel, null);
			jContentPane.add(getNome(), null);
			jContentPane.add(areaProjeto, null);
			jContentPane.add(getAreaEscolhida(), null);
			jContentPane.add(getOk(), null);
			jContentPane.add(getCancela(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes nome	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNome() {
		if (nome == null) {
			nome = new JTextField();
			nome.setBounds(new Rectangle(119, 49, 375, 24));
		}
		return nome;
	}

	/**
	 * This method initializes areaEscolhida	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getAreaEscolhida() {
		if (areaEscolhida == null) {
			areaEscolhida = new JComboBox();
			areaEscolhida.setBounds(new Rectangle(118, 93, 276, 26));
		}
		return areaEscolhida;
	}

	/**
	 * This method initializes ok	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getOk() {
		if (ok == null) {
			ok = new JButton();
			ok.setBounds(new Rectangle(112, 230, 116, 30));
			ok.setText("Cadastrar");
		}
		return ok;
	}

	/**
	 * This method initializes cancela	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCancela() {
		if (cancela == null) {
			cancela = new JButton();
			cancela.setBounds(new Rectangle(247, 230, 154, 29));
			cancela.setText("Cancelar");
		}
		return cancela;
	}

	public void configuraOuvinte(ActionListener ouvinte) {
		
		ok.addActionListener(ouvinte);
		ok.setActionCommand("novoProjeto");
		
	}
	
	
	public void escreveAreas(List<Area> area)
	{	
		
		
		// Zera as entradas do combobox
		areaEscolhida.removeAllItems();
		
		// Para cada area
		for (Area areaAtual : area) 
		{
			// Adiciona no combobox
			areaEscolhida.addItem(areaAtual.getNome());
		}
	}
	
	public String nomeProjeto(){
		
		String nomeProjeto = nome.getText();
		return nomeProjeto;
	}
	
	public String getAreaEscolhidaProjeto(){
		
		String areaProjeto = areaEscolhida.getSelectedItem().toString();
		return areaProjeto;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
