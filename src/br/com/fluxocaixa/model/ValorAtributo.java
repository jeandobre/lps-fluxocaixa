package br.com.fluxocaixa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "valor_atributo")
public class ValorAtributo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column
	private String value;
	
	@ManyToOne
	@JoinColumn(name="centro_custo_id")
	private CentroCusto centroCusto;

	@ManyToOne
	@JoinColumn(name="nome_atributo_id")
	private NomeAtributo nomeAtributo;
	
	public ValorAtributo(){
		
	}
	
	public ValorAtributo(Object value, CentroCusto centroCusto,
			NomeAtributo nomeAtributo) {
		super();
		this.value = nomeAtributo.recuperarTipoAtributo().valueToString(value);
		this.centroCusto = centroCusto;
		this.nomeAtributo = nomeAtributo;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CentroCusto getCentroCusto() {
		return centroCusto;
	}

	public NomeAtributo getNomeAtributo() {
		return nomeAtributo;
	}

	public void setCentroCusto(CentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public void setNomeAtributo(NomeAtributo nomeAtributo) {
		this.nomeAtributo = nomeAtributo;
	}
	
}