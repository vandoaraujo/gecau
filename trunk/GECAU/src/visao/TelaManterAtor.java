package visao;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.lang.annotation.Documented;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jess.ArgumentChecker;

import modelo.Ator;

public class TelaManterAtor extends JDialog {
		
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel labelInformacao = null;
	private JLabel idAtor = null;
	private JTextField idField = null;
	private JTextField idFieldNomeAtor = null;
	private JLabel nomeAtor = null;
	private JButton carregarAtor = null;
	private JButton acaoButton = null;
	private JComboBox areaCombo = null;
	private JLabel areaLabel = null;
	private JLabel labelInsercao = null;
	/**
	 * This is the default constructor
	 */
	public TelaManterAtor() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(607, 287);
		this.setContentPane(getJContentPane());
		this.setTitle("Cadastro de Atores");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			labelInsercao = new JLabel();
			labelInsercao.setVisible(false);
			labelInsercao.setBounds(new Rectangle(128, 0, 283, 33));
			labelInsercao.setText("Informe o nome do Ator e clique em confirmar!");
			areaLabel = new JLabel();
			areaLabel.setBounds(new Rectangle(24, 145, 80, 22));
			areaLabel.setText("Área:");
			nomeAtor = new JLabel();
			nomeAtor.setBounds(new Rectangle(24, 106, 72, 24));
			nomeAtor.setText("NomeAtor:");
			idAtor = new JLabel();
			idAtor.setBounds(new Rectangle(26, 73, 28, 21));
			idAtor.setText("Id");
			labelInformacao = new JLabel();
			labelInformacao.setBounds(new Rectangle(20, 24, 386, 28));
			labelInformacao.setText("Digite Id do Ator conforme tela Anterior para Exclusão e Alteracão");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(labelInformacao, null);
			jContentPane.add(idAtor, null);
			jContentPane.add(getIdField(), null);
			jContentPane.add(getIdFieldNomeAtor(), null);
			jContentPane.add(nomeAtor, null);
			jContentPane.add(getCarregarAtor(), null);
			jContentPane.add(getAcaoButton(), null);
			jContentPane.add(getAreaCombo(), null);
			jContentPane.add(areaLabel, null);
			jContentPane.add(labelInsercao, null);
			
		}
		return jContentPane;
	}

	/**
	 * This method initializes idField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getIdField() {
		if (idField == null) {
			idField = new JTextField();
			idField.setBounds(new Rectangle(171, 74, 58, 23));
		}
		return idField;
	}

	/**
	 * This method initializes idFieldNomeAtor	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getIdFieldNomeAtor() {
		if (idFieldNomeAtor == null) {
			idFieldNomeAtor = new JTextField();
			idFieldNomeAtor.setBounds(new Rectangle(171, 103, 267, 26));
		}
		return idFieldNomeAtor;
	}

	/**
	 * This method initializes carregarAtor	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCarregarAtor() {
		if (carregarAtor == null) {
			carregarAtor = new JButton();
			carregarAtor.setBounds(new Rectangle(251, 69, 131, 25));
			carregarAtor.setText("Carregar");
		}
		return carregarAtor;
	}

	/**
	 * This method initializes acaoButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getAcaoButton() {
		if (acaoButton == null) {
			acaoButton = new JButton();
			acaoButton.setBounds(new Rectangle(203, 186, 160, 30));
			acaoButton.setText("Confirmar");
		}
		return acaoButton;
	}

	public void configuraOuvinte(ActionListener ouvinte) {
		
		idField.addActionListener(ouvinte);
		idField.setActionCommand("id");
		carregarAtor.addActionListener(ouvinte);
		carregarAtor.setActionCommand("carregarAtor");
		idFieldNomeAtor.addActionListener(ouvinte);
		idFieldNomeAtor.setActionCommand("nomeAtor");
		acaoButton.addActionListener(ouvinte);
		acaoButton.setActionCommand("confirma");
		acaoButton.setActionCommand("alterar");
		acaoButton.setActionCommand("deletar");
		areaCombo.addActionListener(ouvinte);
		areaCombo.setActionCommand("area");	
		
	}

	/**
	 * This method initializes areaCombo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getAreaCombo() {
		if (areaCombo == null) {
			areaCombo = new JComboBox();
			areaCombo.setBounds(new Rectangle(172, 141, 267, 30));
		}
		return areaCombo;
	}

	public void defineVisualizacaoInsercaoAtores() {
		
		idFieldNomeAtor.setText("");
		idFieldNomeAtor.setVisible(true);
		idFieldNomeAtor.setEditable(true);
		idField.setVisible(false);
		idAtor.setVisible(false);
		carregarAtor.setVisible(false);
		labelInformacao.setVisible(false);
		labelInsercao.setVisible(true);
		areaCombo.setEditable(false);
		acaoButton.setText("confirma");
		acaoButton.setActionCommand("confirma");
		
		
	}
	
	public void defineTelaAlteracaoAtores()
	{
		
		idFieldNomeAtor.setVisible(true);
		idField.setVisible(true);
		idAtor.setVisible(true);
		carregarAtor.setVisible(true);
		labelInformacao.setVisible(true);
		labelInsercao.setVisible(false);
		areaCombo.setEditable(false);
		acaoButton.setText("alterar");
		acaoButton.setActionCommand("alterar");
		
	}
	

	public void defineTelaDelecaoAtores()
	{	
		idFieldNomeAtor.setText("");
		idField.setVisible(true);
		idAtor.setVisible(true);
		labelInformacao.setVisible(false);
		idFieldNomeAtor.setVisible(false);
		nomeAtor.setVisible(false);
		areaCombo.setEditable(false);
		acaoButton.setText("deletar");
		acaoButton.setActionCommand("deletar");
		carregarAtor.setVisible(false);
		
	}


	public void PreencheComboArea(String areaAtual) {
		
		areaCombo.removeAllItems();
		areaCombo.addItem(areaAtual);
	
		
	}
	
	//Instancia novo ator na tela de Insercao de novos atores
	public Ator novoAtor(){
		
		Ator a = new Ator();
		String nome = idFieldNomeAtor.getText(); 
		try{
		
			a.setNome(nome);
			return a;
			
		}
		
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Você não digitou o nome");
		}
		
		//Tratar esta exception
		return null;
		
	}

	public void fechaTelaAtor() {
		dispose();
		
	}

	
	//Tratar Exception
	public String passaIdAtor()
	{
		String id = null;
		id = idField.getText();
		
		if(id == null)
		{
			JOptionPane.showMessageDialog(null, "Informado id errado");
			throw new IllegalArgumentException();
			
		}
			
		return id;
		
	}

	public void PreencheCampoAtor(Ator ator) {
	
		idFieldNomeAtor.setText("");
		System.out.println("funcionando tela e nome ator campo");
		String nome = ator.getNome();
		idFieldNomeAtor.setText(nome);
		
	}

	public String buscaDadosAtor() {
		
		String nome = idFieldNomeAtor.getText();
		return nome;
	}

}  //  @jve:decl-index=0:visual-constraint="75,8"
