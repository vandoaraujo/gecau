package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name="area")
public class Area {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;
	
	@OneToMany(mappedBy="area",fetch = FetchType.EAGER)
	@Cascade(CascadeType.DELETE_ORPHAN)
	private Collection<Ator> atores;
	
	//Verificar atributos
	@OneToOne(mappedBy = "projeto")
	public Projeto getProjeto(){
		return null;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Ator> getAtores() {
		return atores;
	}

	public void setAtores(Collection<Ator> atores) {
		this.atores = atores;
	}
	
	
	
}

