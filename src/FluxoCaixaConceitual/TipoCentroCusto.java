package FluxoCaixaConceitual;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_centro_custo")
public class TipoCentroCusto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column
	private String nome;
	
	@OneToMany(mappedBy = "tipoCentroCusto", targetEntity = NomeAtributo.class
			, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<NomeAtributo> nomesAtributo;
	
	@OneToMany(mappedBy = "tipoCentroCusto", targetEntity = CentroCusto.class
			, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CentroCusto> centroCustos;
	
	public TipoCentroCusto() {
		
	}
	

	public TipoCentroCusto(String nome) {
		super();
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<NomeAtributo> getNomesAtributo() {
		return nomesAtributo;
	}

	public void setNomesAtributo(List<NomeAtributo> nomesAtributo) {
		this.nomesAtributo = nomesAtributo;
	}

	public List<CentroCusto> getCentroCustos() {
		return centroCustos;
	}

	public void setCentroCustos(List<CentroCusto> centroCustos) {
		this.centroCustos = centroCustos;
	}	
}