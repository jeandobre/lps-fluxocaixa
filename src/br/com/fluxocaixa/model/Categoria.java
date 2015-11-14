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
	
	@Column(name="is_receita")
	private boolean isReceita;
	
	@ManyToOne
	@JoinColumn(name="pai_id", nullable=true)
	private Categoria pai;
	
	@OneToMany(mappedBy = "pai", targetEntity = Categoria.class
			, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Categoria> filhos;
	
	public Categoria(){
		
	}
	
	public Categoria(String nome, String descricao, boolean isReceita){
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.isReceita = isReceita;
	}
	
	public Categoria(String nome, String descricao, boolean isReceita,
			Categoria pai) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.isReceita = isReceita;
		this.pai = pai;
	}



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

	public boolean isReceita() {
		return isReceita;
	}

	public void setReceita(boolean isReceita) {
		this.isReceita = isReceita;
	}	
	
}