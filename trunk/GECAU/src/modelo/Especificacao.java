package modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="especificacao")
public class Especificacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome; //mesmo nome utilizado no Caso de Uso
	
	
	private UseCase identificador_CasoUso; // codigo unico
	
	private String objetivoAtor; //objetivo do ator ao utilizar o caso de Uso
	
	private String nomeAtor;
	
	private String fluxoPrincipal; //define o fluxo principal do Caso de Uso
	
	private String fluxoAlternativo; //declara um fluxo alternativo

	private String fluxoDeExcecao; //declara um fluxo de exceção

	private String regrasDeNegocio; //declara regras de negócio (VER - CLASSE)
	
	
	public Especificacao(String nome, UseCase identificador,
			String objetivoAtor, String nomeAtor, String fluxoPrincipal,
			String fluxoAlternativo, String fluxoDeExcecao,
			String regrasDeNegocio) {
		super();
		this.nome = nome;
		this.identificador_CasoUso = identificador;
		this.objetivoAtor = objetivoAtor;
		this.nomeAtor = nomeAtor;
		this.fluxoPrincipal = fluxoPrincipal;
		this.fluxoAlternativo = fluxoAlternativo;
		this.fluxoDeExcecao = fluxoDeExcecao;
		this.regrasDeNegocio = regrasDeNegocio;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public UseCase getIdentificador() {
		return identificador_CasoUso;
	}


	public void setIdentificador(UseCase identificador) {
		this.identificador_CasoUso = identificador;
	}


	public String getObjetivoAtor() {
		return objetivoAtor;
	}


	public void setObjetivoAtor(String objetivoAtor) {
		this.objetivoAtor = objetivoAtor;
	}


	public String getNomeAtor() {
		return nomeAtor;
	}


	public void setNomeAtor(String nomeAtor) {
		this.nomeAtor = nomeAtor;
	}


	public String getFluxoPrincipal() {
		return fluxoPrincipal;
	}


	public void setFluxoPrincipal(String fluxoPrincipal) {
		this.fluxoPrincipal = fluxoPrincipal;
	}


	public String getFluxoAlternativo() {
		return fluxoAlternativo;
	}


	public void setFluxoAlternativo(String fluxoAlternativo) {
		this.fluxoAlternativo = fluxoAlternativo;
	}


	public String getFluxoDeExcecao() {
		return fluxoDeExcecao;
	}


	public void setFluxoDeExcecao(String fluxoDeExcecao) {
		this.fluxoDeExcecao = fluxoDeExcecao;
	}


	public String getRegrasDeNegocio() {
		return regrasDeNegocio;
	}


	public void setRegrasDeNegocio(String regrasDeNegocio) {
		this.regrasDeNegocio = regrasDeNegocio;
	}


	public void setIdentificador_CasoUso(UseCase identificador_CasoUso) {
		this.identificador_CasoUso = identificador_CasoUso;
	}


	public UseCase getIdentificador_CasoUso() {
		return identificador_CasoUso;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}
	
	
	
	
	

}
