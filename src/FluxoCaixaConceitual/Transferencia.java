package FluxoCaixaConceitual;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transferencia")
public class Transferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="origem_id")
	private Movimentacao origem;
	
	@ManyToOne
	@JoinColumn(name="destino_id")
	private Movimentacao destino;
	
	public Integer getId() {
		return id;
	}

	public Movimentacao getOrigem() {
		return origem;
	}

	public Movimentacao getDestino() {
		return destino;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setOrigem(Movimentacao origem) {
		this.origem = origem;
	}

	public void setDestino(Movimentacao destino) {
		this.destino = destino;
	}
	
}