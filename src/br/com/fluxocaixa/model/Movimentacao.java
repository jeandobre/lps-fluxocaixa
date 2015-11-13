package br.com.fluxocaixa.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movimentacao")
public abstract class Movimentacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column
	private Date data;
	
	@Column
	private Integer numeroParcela;
	
	@Column
	private double valor;
	
	@Column
	private String observacao;
	
	
	@ManyToOne
	@JoinColumn(name="tipo_movimentacao_id")
	private TipoMovimentacao tipoMovimentacao;
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	@ManyToMany
    @JoinTable(name="movimentacao_centro_custo", joinColumns=
    	{@JoinColumn(name="movimentacao_id")}, inverseJoinColumns=
      	{@JoinColumn(name="centro_custo_id")})
	private List<CentroCusto> centroCusto;

	public Integer getId() {
		return this.id;
	}
	
	public Date getData() {
		return data;
	}

	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public double getValor() {
		return valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public List<HistoricoStatus> listarStatusPossiveis() {
		throw new UnsupportedOperationException();
	}

	public void calcularParcelas() {
		throw new UnsupportedOperationException();
	}

	public void MostrarDados() {
		throw new UnsupportedOperationException();
	}

	public void MostrarDataPagamento() {
		throw new UnsupportedOperationException();
	}

	public void validarDataPagamento() {
		throw new UnsupportedOperationException();
	}

	public void validarValorDespesa() {
		throw new UnsupportedOperationException();
	}

}