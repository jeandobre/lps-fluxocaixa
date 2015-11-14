package br.com.fluxocaixa.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimentacao")
public class Movimentacao {
	
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
	
	@Column(name="tipo_movimentacao")
	private int tipoMovimentacao;
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	@ManyToMany
    @JoinTable(name="movimentacao_centro_custo", joinColumns=
    	{@JoinColumn(name="movimentacao_id")}, inverseJoinColumns=
      	{@JoinColumn(name="centro_custo_id")})
	private List<CentroCusto> centroCusto;
	
	public Movimentacao(){
		
	}
	
	public Movimentacao(Date data, Integer numeroParcela, double valor,
			String observacao, TipoMovimentacao tipoMovimentacao, Categoria categoria,
			List<CentroCusto> centroCusto) {
		super();
		this.data = data;
		this.numeroParcela = numeroParcela;
		this.valor = valor;
		this.observacao = observacao;
		this.tipoMovimentacao = tipoMovimentacao.getValor();
		this.categoria = categoria;
		this.centroCusto = centroCusto;
	}

	public TipoMovimentacao recuperarTipoMovimentacao(){
		return TipoMovimentacao.getByValue(tipoMovimentacao);
	}
	
	public void confTipoMovimentacao(TipoMovimentacao tipoMovimentacao){
		setTipoMovimentacao(tipoMovimentacao.getValor());
	}


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

	private int getTipoMovimentacao() {
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

	private void setTipoMovimentacao(int tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}
	

	public Categoria getCategoria() {
		return categoria;
	}

	public List<CentroCusto> getCentroCusto() {
		return centroCusto;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setCentroCusto(List<CentroCusto> centroCusto) {
		this.centroCusto = centroCusto;
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