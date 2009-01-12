package modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="ator")
public class Ator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column
	private String nome;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "area_id", insertable=true, updatable =true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Area area;
	

	@Transient
	private transient boolean isSpecification;
	@Transient
	private transient boolean isRoot;
	@Transient
	private transient boolean isLeaf;
	@Transient
	private transient boolean isAbstract;
	
	public Area getAreaId() {
		return area;
	}
	public void setAreaId(Area IdArea) {
		
		this.area = IdArea;
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
	public void setNome(String nome){
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

}
