package FluxoCaixaConceitual;

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
	private List<CentroCusto> centroCustos;

	@ManyToOne
	@JoinColumn(name="nome_atributo_id")
	private List<NomeAtributo> nomeAtributos;

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

	public List<CentroCusto> getCentroCustos() {
		return centroCustos;
	}

	public void setCentroCustos(List<CentroCusto> centroCustos) {
		this.centroCustos = centroCustos;
	}

	public List<NomeAtributo> getNomeAtributos() {
		return nomeAtributos;
	}

	public void setNomeAtributos(List<NomeAtributo> nomeAtributos) {
		this.nomeAtributos = nomeAtributos;
	}
	
}