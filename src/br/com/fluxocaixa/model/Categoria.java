package br.com.fluxocaixa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "categoria",
	uniqueConstraints=@UniqueConstraint(columnNames = {"descricao"}))
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column
	private String nome;
	
	@Column(name="descricao")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="pai_id")
	private Categoria pai;
	
	@OneToMany(mappedBy = "pai", targetEntity = Categoria.class
			, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Categoria> filhos;

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Categoria getPai() {
		return pai;
	}

	public List<Categoria> getFilhos() {
		return filhos;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPai(Categoria pai) {
		this.pai = pai;
	}

	public void setFilhos(List<Categoria> filhos) {
		this.filhos = filhos;
	}	

}