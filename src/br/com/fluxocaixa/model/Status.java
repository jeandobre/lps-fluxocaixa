	package br.com.fluxocaixa.model;

	import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "status",
	uniqueConstraints=@UniqueConstraint(columnNames = {"descricao"}))
public class Status {
	static public final String DESC_NAO_REALIZADO = "nao realizado";
	static public final String DESC_REALIZADO = "realizado";
	static public final String DESC_ATRASADO = "realizado";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column(name="descricao")
	private String descricao;
	
	public Status(){
		
	}

	public Status(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isRealizado(){
		return descricao.equals(DESC_REALIZADO);
	}
	
	public boolean isNaoRealizado(){
		return descricao.equals(DESC_NAO_REALIZADO);
	}
	
	public boolean isAtrasado(){
		return descricao.equals(DESC_ATRASADO);
	}
	
}

