package br.com.fluxocaixa.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "movimentos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="tipo",
        discriminatorType=DiscriminatorType.STRING
)
public abstract class FluxoCaixa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(name="numero_parcela")
	@NotNull
	private Integer numeroParcela;
	
	@Column
	@NotNull
	private Float valor;
	
	@Column
	private String observacao;
	
	@ManyToOne(cascade=javax.persistence.CascadeType.ALL)
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	@ManyToMany(cascade=javax.persistence.CascadeType.ALL, targetEntity=CentroCusto.class)
    @JoinTable(name="detalhe_movimentos", joinColumns=
    	{@JoinColumn(name="movimento_id")}, inverseJoinColumns=
      	{@JoinColumn(name="centro_custo_id")})
	private List<CentroCusto> centrosCusto;
	
	@OneToMany(mappedBy="movimento")
	private List<Status> estados;
	
	public FluxoCaixa(){
		centrosCusto = new ArrayList<>();
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

	public void setData(Date data) {
		this.data = data;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
		
		if(numeroParcela > 1 && valor > 0)
		    valor = new Float(valor / numeroParcela);
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}	

	public Categoria getCategoria() {
		return categoria;
	}

	public List<CentroCusto> getCentrosCusto() {
		return centrosCusto;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setCentrosCusto(List<CentroCusto> centroCusto) {
		this.centrosCusto = centroCusto;
	}

	public List<Status> listarStatusPossiveis() {
		return new ArrayList<Status>();
	}

	public List<Status> getEstados() {
		return estados;
	}

	public void setStatus(Status estado) {
		if(this.estados == null) estados = new ArrayList<>();
		estado.setData(new Date());
		estados.add(estado);
	}
}