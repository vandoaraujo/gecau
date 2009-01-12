package visao;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel jContentPane = null;
	
	private JMenuBar menuPrincipal = null;
	
	private JMenu menuSobre = null;
	
	private JMenu menuCadastro = null;
	
	private JMenu menuCasosdeUso = null;
	
	private JMenu menuXMI = null;
	
	private JMenu menuEspecificacao = null;

	private JLabel LabelImage = null;
	
	private JMenuItem novoProjeto = null;
	
	private JMenuItem abrirProjeto = null;
	
	private JMenuItem menuRequisito = null;
	
	private JMenuItem menuAtor = null;
	
	private JMenuItem menuArea = null;
	
	private JMenuItem inferirUseCases = null;
	
	private JMenuItem cadastrarEspecificacoes = null;
	
	private JMenuItem alterarEspecificacoes = null;
	
	private JMenuItem sobre = null;

	private JFileChooser filechooser;
	
		
	/**
	 * This is the default constructor
	 */
	public TelaPrincipal() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		
		this.setSize(780, 405);
		this.setJMenuBar(getPrincipalMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("Sistema Especialista - Gerador de Casos de Uso");
		this.setLocationRelativeTo(null);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			ImageIcon im=new ImageIcon("images//image.jpg");
			LabelImage = new JLabel();
			LabelImage.setIcon(im);
			LabelImage.setBounds(new Rectangle(1, 5, 759, 338));
			LabelImage.setText(" ");
			jContentPane = new JPanel();
			jContentPane.setBackground(new Color(0, 156, 218));
			jContentPane.setLayout(null);
			jContentPane.add(LabelImage, null);
		}
		return jContentPane;
	}
	
	private JMenuBar getPrincipalMenuBar(){
		if(menuPrincipal==null){
			menuPrincipal=new JMenuBar();
			menuPrincipal.add(getCadastrar());
			menuPrincipal.add(getGerarUseCases());
			menuPrincipal.add(getGerarXMI());
			menuPrincipal.add(getCadastrarEspecificacao());
			menuPrincipal.add(getSobre());
			
		}
		return menuPrincipal;
	}
		
	private JMenu getCadastrar(){
		if(menuCadastro==null){
			menuCadastro=new JMenu();
			menuCadastro.setText("Cadastrar");
			menuCadastro.add(getNovoProjeto());
			menuCadastro.add(getAbrirProjeto());
			menuCadastro.add(getCadastrarRequisito());
			menuCadastro.add(getCadastrarArea());
			menuCadastro.add(getCadastrarAtor());
		}
		
		return menuCadastro;
	}
	
	private JMenu getGerarUseCases(){
		if(menuCasosdeUso==null){
			menuCasosdeUso=new JMenu();
			menuCasosdeUso.setText("Gerar UseCases");
			menuCasosdeUso.add(getInferirUseCases());
		}
		
		return menuCasosdeUso;
	}
	
	private JMenu getGerarXMI(){
		if(menuXMI==null){
			menuXMI=new JMenu();
			menuXMI.setText("Gerar XMI");
		}
		
		return menuXMI;
	}
	
	private JMenu getCadastrarEspecificacao(){
		if(menuEspecificacao==null){
			menuEspecificacao=new JMenu();
			menuEspecificacao.setText("Cadastrar Especificacao");
			menuEspecificacao.add(getCadastrarEspecificacoesItem());
			menuEspecificacao.add(getAlterarEspecificacoes());
		}
		
		return menuEspecificacao;
	}
	
	private JMenu getSobre(){
		if(menuSobre==null){
			menuSobre=new JMenu();
			menuSobre.setText("Sobre");
			menuSobre.add(getSobreGecau());
		}
		
		return menuSobre;
	}
	
   	private JMenuItem getNovoProjeto(){
		if(novoProjeto==null){
			novoProjeto=new JMenuItem();
			novoProjeto.setText("Novo Projeto");
			novoProjeto.setMnemonic(KeyEvent.VK_N);
		}
		return novoProjeto;
	}
	
	private JMenuItem getAbrirProjeto(){
		if(abrirProjeto==null){
			abrirProjeto=new JMenuItem();
			abrirProjeto.setText("Abrir Projeto...");
			abrirProjeto.setMnemonic(KeyEvent.VK_A);
		}
		return abrirProjeto;
	}
	
	private JMenuItem getInferirUseCases(){
		if(inferirUseCases==null){
			inferirUseCases=new JMenuItem();
			inferirUseCases.setText("Gerar Casos de Uso...");
			inferirUseCases.setMnemonic(KeyEvent.VK_G);
		}
		return inferirUseCases;
	}
	
	private JMenuItem getCadastrarEspecificacoesItem(){
		if(cadastrarEspecificacoes==null){
			cadastrarEspecificacoes=new JMenuItem();
			cadastrarEspecificacoes.setText("Cadastrar Especificacoes...");
			cadastrarEspecificacoes.setMnemonic(KeyEvent.VK_E);
		}
		return cadastrarEspecificacoes;
	}
	
	private JMenuItem getAlterarEspecificacoes(){
		if(alterarEspecificacoes==null){
			alterarEspecificacoes=new JMenuItem();
			alterarEspecificacoes.setText("Alterar Especificação...");
			alterarEspecificacoes.setMnemonic(KeyEvent.VK_P);
		}
		return alterarEspecificacoes;
	}
	
	private JMenuItem getCadastrarRequisito(){
		if(menuRequisito==null){
			menuRequisito=new JMenuItem();
			menuRequisito.setText("Cadastrar Requisitos...");
			menuRequisito.setMnemonic(KeyEvent.VK_R);
		}
		return menuRequisito;
	}
	
	private JMenuItem getCadastrarAtor(){
		if(menuAtor==null){
			menuAtor=new JMenuItem();
			menuAtor.setText("Cadastrar Nova Area...");
			menuAtor.setMnemonic(KeyEvent.VK_A);
		}
		return menuAtor;
	}
	
	private JMenuItem getCadastrarArea(){
		if(menuArea==null){
			menuArea=new JMenuItem();
			menuArea.setText("Cadastrar AtoresArea...");
			menuArea.setMnemonic(KeyEvent.VK_C);
		}
		return menuArea;
	}
	
	private JMenuItem getSobreGecau(){
		if(sobre==null){
			sobre=new JMenuItem();
			sobre.setText("Sobre o GECAU...");
			sobre.setMnemonic(KeyEvent.VK_S);
		}
		return sobre;
	}
	
	public void configuraOuvinte(ActionListener controle)
	{
		novoProjeto.addActionListener(controle);
		novoProjeto.setActionCommand("novoProjeto");
		abrirProjeto.addActionListener(controle);
		abrirProjeto.setActionCommand("abrirProjeto");
		menuRequisito.addActionListener(controle);
		menuRequisito.setActionCommand("novoRequisito");
		menuAtor.addActionListener(controle);
		menuAtor.setActionCommand("novaArea");
		menuArea.addActionListener(controle);
		menuArea.setActionCommand("editaAtorArea");
		inferirUseCases.addActionListener(controle);
		inferirUseCases.setActionCommand("gerar");
		cadastrarEspecificacoes.addActionListener(controle);
		cadastrarEspecificacoes.setActionCommand("especificar");
		alterarEspecificacoes.addActionListener(controle);
		alterarEspecificacoes.setActionCommand("alterarEspecificacao");
	}

	public File escolheArquivo() {
					
			filechooser=new JFileChooser();
			
			int res = filechooser.showOpenDialog(null);
			
			if(res == JFileChooser.APPROVE_OPTION){
				File f=filechooser.getSelectedFile();
				return f;
				
			}
			else if(res==JFileChooser.CANCEL_OPTION){
				JOptionPane.showMessageDialog(null, "Vc nao selecionou nenhum diretorio");
			    //System.exit(1);
				
			}
			
			return null;
			
	}
	
}  //  @jve:decl-index=0:visual-constraint="21,38"
