package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Area;
import modelo.Ator;
import visao.TelaManterAtor;
import dao.AreaDao;
import dao.AtorDao;

public class ControlaAtor implements ActionListener {
	
	//static Logger logger = Logger.getLogger(ControlaAtor.class);
	
	private TelaManterAtor tma;
	private ControlaAtor ca;
	private AtorDao atorDao = AtorDao.getInstance();
	private static ControlaAtor singleton = null;
	private String areaSelecionada;
	private Ator ator;
	
	private ControlaAtor(){}
	
	public static ControlaAtor getInstance()
	{
		if(singleton == null)
		singleton = new ControlaAtor();
		return singleton;
	}
	
	public void configuraTela(TelaManterAtor tma)
	{
		this.tma=tma;
		tma.configuraOuvinte(this);
		tma.setModal(true);
		tma.setResizable(false);
		
	}
	
	public void habilitaTelaAtor()
	{
		tma.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent eve)
	{
		String comando = eve.getActionCommand();
		
		if(comando.equals("confirma"))
		{
			insereAtorArea();
		}
		else if(comando.equals("carregarAtor"))
		{
			try {
				buscaAtor();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(comando.equals("alterar"))
		{
			alteraAtor();
		}
		else if(comando.equals("deletar"))
		{
			deletarAtor();
		}
		
		
	}
	
	private void alteraAtor() {
			
		String nome = tma.buscaDadosAtor();
		ator.setNome(nome);
		AtorDao.getInstance().atualizar(ator);
		
	}
	
	private void deletarAtor() {
		
		String id = tma.passaIdAtor();
		ator = AtorDao.getInstance().CarregaAtor(id);
		AtorDao.getInstance().deletar(ator);
		ator = null;
		
	}

	private void buscaAtor() throws Exception {
		
		String id = tma.passaIdAtor();
		ator = AtorDao.getInstance().CarregaAtor(id);
		tma.PreencheCampoAtor(ator);
		tma.defineTelaAlteracaoAtores();
		
		
	}

	private void insereAtorArea() {
		
		Area areaCorreta = null;
		Ator a = tma.novoAtor();
		
		if(a==null){
			JOptionPane.showMessageDialog(null, "tratar excecao de não preenchimento de nome do Ator");
		}
		
		//Recebe a area Atual do Ator do ControlaArea
		String area = ControlaArea.getInstance().getAreaSelecionada();
		//Abre uma Session no AreaDao buscando uma lista de Areas
		List<Area> areaRecebida = AreaDao.getInstance().listarAreaNome(area);
		//Varre as listas possíves comparando com a atual
		for(Area areaBind : areaRecebida){
			if(areaBind.getNome().equals(area)){
				 areaCorreta= areaBind;
			}
		}
		a.setAreaId(areaCorreta);
		//Abre uma outra Session e salva o ator
		AtorDao.getInstance().salvar(a);
		//Fecha a tela atual
		tma.fechaTelaAtor();
		System.out.println("NAO OCORREU o ERRO!!!");
		//Recarrega a área com o novo ator
		
		//VER!!!!!!!!!!
		//ControlaArea.getInstance().habilitaTelaArea();
		System.out.println("NAO OCORREU o ERRO 2!!!");
	}

	
	public void alteraAtor(String area)
	{
		tma.PreencheComboArea(area);
		tma.defineTelaAlteracaoAtores();
		tma.setVisible(true);
	}
	
	public void deletaAtor(String area)
	{
		tma.PreencheComboArea(area);
		tma.defineTelaDelecaoAtores();
		tma.setVisible(true);
	}

	//Configura conforme acao do botao insercão
	public void incluiAtor(String area) {
		
		tma.defineVisualizacaoInsercaoAtores();
		tma.PreencheComboArea(area);
		tma.setVisible(true);
		
	}
	
	
	


	
	
	

}
