package br.com.fluxocaixa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historico_status")
public class HistoricoStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="status_id")
	private Status status;
	
	@ManyToOne
	@JoinColumn(name="movimentacao_id")
	private Movimentacao movimentacao;
	
	public HistoricoStatus() {
	}
	
	

	public HistoricoStatus(Status status, Movimentacao movimentacao) {
		super();
		this.status = status;
		this.movimentacao = movimentacao;
		data = new Date();
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Movimentacao getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}
}