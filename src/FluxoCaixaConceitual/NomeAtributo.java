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
@Table(name = "nome_atributo",
	uniqueConstraints=@UniqueConstraint(columnNames = {"nome"}))
public class NomeAtributo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column
	private String nome;
	
	
	@ManyToOne
	@JoinColumn(name="tipo_centro_custo_id")
	private TipoCentroCusto tipoCentroCusto;
	
	public NomeAtributo() {
	}


	public NomeAtributo(String nome, TipoCentroCusto tipoCentroCusto) {
		super();
		this.nome = nome;
		this.tipoCentroCusto = tipoCentroCusto;
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


	public TipoCentroCusto getTipoCentroCusto() {
		return tipoCentroCusto;
	}


	public void setTipoCentroCusto(TipoCentroCusto tipoCentroCusto) {
		this.tipoCentroCusto = tipoCentroCusto;
	}

}