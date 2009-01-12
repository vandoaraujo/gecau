package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.CascadeType;




@Entity
@Table(name="useCase")

public class UseCase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column
	private String nome;
	@Transient
	private boolean isSpecification;
	@Transient
	private boolean isRoot;
	@Transient
	private boolean isLeaf;
	@Transient
	private boolean isAbstract;
	
	//mapeamento de use cases extended e included
		
	@OneToMany(mappedBy="menuPai", fetch=FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	private List useCaseNormal;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="UseCaseAssociado_id", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private UseCase casoUso;
	
	
	private Especificacao especific;
	
	@ManyToOne
	@JoinColumn(name="requisito_id")
	private Requisito requisito;
	
		
	//private Ator ator;
	
	
	public Especificacao getEspecific() {
		return especific;
	}
	public void setEspecific(Especificacao especific) {
		this.especific = especific;
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
	public boolean isSpecification() {
		return isSpecification;
	}
	public void setSpecification(boolean isSpecification) {
		this.isSpecification = isSpecification;
	}
	public boolean isRoot() {
		return isRoot;
	}
	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}
	public boolean isLeaf() {
		return isLeaf;
	}
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public boolean isAbstract() {
		return isAbstract;
	}
	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}
	public Requisito getRequisito() {
		return requisito;
	}
	public void setRequisito(Requisito requisito) {
		this.requisito = requisito;
	}
	public UseCase getCasoUso() {
		return casoUso;
	}
	public void setCasoUso(UseCase casoUso) {
		this.casoUso = casoUso;
	}
	

}
