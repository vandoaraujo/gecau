package visao;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


import modelo.Area;
import modelo.Ator;
import javax.swing.JTextField;

public class TelaManterArea extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel areaAplicacao = null;
	private JComboBox areaASelecionar = null;
	private JTextArea atoresAtuaisArea = null;
	private JButton insercaoButton = null;
	private JButton alteracaoButton = null;
	private JButton exclusaoButton = null;
	private JButton carregarAreaButton = null;
	private JLabel atoresDaArea = null;
	/**
	 * This is the default constructor
	 */
	public TelaManterArea() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(699, 312);
		this.setContentPane(getJContentPane());
		this.setTitle("Area de Aplicação");
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			atoresDaArea = new JLabel();
			atoresDaArea.setBounds(new Rectangle(58, 64, 302, 23));
			atoresDaArea.setText("Atores desta Área:");
			areaAplicacao = new JLabel();
			areaAplicacao.setBounds(new Rectangle(13, 34, 93, 22));
			areaAplicacao.setText("Area Aplicacao:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(areaAplicacao, null);
			jContentPane.add(getAreaASelecionar(), null);
			jContentPane.add(getAtoresAtuaisArea(), null);
			jContentPane.add(getInsercaoButton(), null);
			jContentPane.add(getAlteracaoButton(), null);
			jContentPane.add(getCarregarAreaButton(), null);
			jContentPane.add(getExclusaoButton(), null);
			jContentPane.add(atoresDaArea, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes areaASelecionar
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getAreaASelecionar() {
		if (areaASelecionar == null) {
			areaASelecionar = new JComboBox();
			areaASelecionar.setBounds(new Rectangle(120, 33, 388, 23));
		
		}
		return areaASelecionar;
	}

	/**
	 * This method initializes atoresAtuaisArea
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getAtoresAtuaisArea() {
		if (atoresAtuaisArea == null) {
			atoresAtuaisArea = new JTextArea();
			atoresAtuaisArea.setBounds(new Rectangle(56, 89, 546, 155));
			atoresAtuaisArea.setAlignmentY(50);
			atoresAtuaisArea.setAlignmentX(50);
			atoresAtuaisArea.setBackground(Color.YELLOW);
			JScrollPane jscroll=new JScrollPane(atoresAtuaisArea);
		    jscroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			jscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		}
		return atoresAtuaisArea;
	}

	/**
	 * This method initializes insercaoButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getInsercaoButton() {
		if (insercaoButton == null) {
			insercaoButton = new JButton();
			insercaoButton.setBounds(new Rectangle(33, 244, 182, 28));
			insercaoButton.setText("Incluir Ator");
		}
		return insercaoButton;
	}

	/**
	 * This method initializes alteracaoButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getAlteracaoButton() {
		if (alteracaoButton == null) {
			alteracaoButton = new JButton();
			alteracaoButton.setBounds(new Rectangle(228, 244, 225, 29));
			alteracaoButton.setText("Alterar Ator");
		}
		return alteracaoButton;
	}

	/**
	 * This method initializes exclusaoButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getExclusaoButton() {
		if (exclusaoButton == null) {
			exclusaoButton = new JButton();
			exclusaoButton.setText("Excluir Ator");
			exclusaoButton.setBounds(new Rectangle(458, 243, 213, 29));
		}
		return exclusaoButton;
	}

	/**
	 * This method initializes carregarAreaButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getCarregarAreaButton() {
		if (carregarAreaButton == null) {
			carregarAreaButton = new JButton();
			carregarAreaButton.setBounds(new Rectangle(526, 29, 119, 33));
			carregarAreaButton.setText("CarregarArea");
		}
		return carregarAreaButton;
	}

	public void configuraOuvinte(ActionListener ouvinte) 
	{
		areaASelecionar.addActionListener(ouvinte);
		areaASelecionar.setActionCommand("area");
		carregarAreaButton.addActionListener(ouvinte);
		carregarAreaButton.setActionCommand("carregaArea");
		insercaoButton.addActionListener(ouvinte);
		insercaoButton.setActionCommand("insercao");
		alteracaoButton.addActionListener(ouvinte);
		alteracaoButton.setActionCommand("alteracao");
		exclusaoButton.addActionListener(ouvinte);
		exclusaoButton.setActionCommand("exclusao");
		
	}
	
	public void escreveAreas(List<Area> area)
	{	
		
		
		// Zera as entradas do combobox
		areaASelecionar.removeAllItems();
		
		// Para cada area
		for (Area areaAtual : area) 
		{
			// Adiciona no combobox
			areaASelecionar.addItem(areaAtual.getNome());
		}
	}
	
	public String selecionaArea(){
		
		String nomeArea = areaASelecionar.getSelectedItem().toString();
		return nomeArea;
	}

	public void escreveAtoresArea(Area atoresRecebidos) {
		
		// Zera as entradas do TextArea
		atoresAtuaisArea.setText("");
		atoresAtuaisArea.setEditable(false);
		
		// Para cada Ator
		for (Ator ator : atoresRecebidos.getAtores()) 
		{
			// Adiciona no TextArea
			atoresAtuaisArea.append(ator.getNome() + " Id: " + ator.getId() + "\n");
		}
		
	}

} // @jve:decl-index=0:visual-constraint="14,-7"
