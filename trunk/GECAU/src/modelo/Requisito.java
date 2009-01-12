package modelo;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="requisito")
public class Requisito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String nome;

	private Ator ator;
	
	// N - 1
	@ManyToOne
	@JoinColumn(name="projeto_id", referencedColumnName="id")
	private Projeto projeto;
		
	private ArrayList<UseCase> useCase;
	
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	public ArrayList<UseCase> getUseCase() {
		return useCase;
	}
	public void setUseCase(ArrayList<UseCase> useCase) {
		this.useCase = useCase;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Ator getAtor() {
		return ator;
	}
	public void setAtor(Ator ator) {
		this.ator = ator;
	}
	
	

}
