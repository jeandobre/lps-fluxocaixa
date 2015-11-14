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


@Entity
@Table(name = "centro_custo")
public class CentroCusto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@OneToMany(mappedBy = "centroCusto", targetEntity = ValorAtributo.class
			, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ValorAtributo> valores;
	
	@ManyToOne
	@JoinColumn(name="centro_custo_id")	
	private TipoCentroCusto tipoCentroCusto;
	
	
	public CentroCusto(){
		
	}
	
	public CentroCusto(TipoCentroCusto tipoCentroCusto) {
		super();
		this.tipoCentroCusto = tipoCentroCusto;
	}

	public TipoCentroCusto getTipoCentroCusto() {
		return tipoCentroCusto;
	}

	public void setTipoCentroCusto(TipoCentroCusto tipoCentroCusto) {
		this.tipoCentroCusto = tipoCentroCusto;
	}
	
	public Integer getId() {
		return this.id;
	}

	public List<ValorAtributo> getValores() {
		return valores;
	}

	public void setValores(List<ValorAtributo> valores) {
		this.valores = valores;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}