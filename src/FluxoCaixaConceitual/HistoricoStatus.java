package FluxoCaixaConceitual;

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
	
	@Column(name="desc")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="status_id")
	private Status status;
	
	@ManyToOne
	@JoinColumn(name="fluxo_caixa_id")
	private Movimentacao fluxoCaixa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Movimentacao getFluxoCaixa() {
		return fluxoCaixa;
	}

	public void setFluxoCaixa(Movimentacao fluxoCaixa) {
		this.fluxoCaixa = fluxoCaixa;
	}
}