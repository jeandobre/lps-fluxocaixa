package br.com.fluxocaixa.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "nome_atributo", uniqueConstraints = @UniqueConstraint(columnNames = {
		"nome", "tipo_centro_custo_id" }))
public class NomeAtributo {

	static public enum TipoAtributo {
		STRING(1), INT(2), DOUBLE(3), DATE(4);

		private final int value;

		TipoAtributo(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public boolean checkValueType(Object value) {
			switch (this.value) {
			case 2:
				return value instanceof Integer;
			case 3:
				return value instanceof Double;
			case 4:
				return value instanceof Date;
			case 1:
			default:
				return value instanceof String;
			}
		}

		public static TipoAtributo fromValue(int value) {
			TipoAtributo[] tipos = TipoAtributo.values();

			for (TipoAtributo tipoAtributo : tipos) {
				if (tipoAtributo.getValue() == value) {
					return tipoAtributo;
				}
			}

			return null;
		}

		public String valueToString(Object value2) {
			switch (this.value) {
			case 4:
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				
				return df.format((Date)value2);
			case 1:
			case 2:
			case 3:
			default:
				return value2.toString();
			}
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;

	@Column
	private String nome;

	@Column
	private boolean isObrigatorio;

	@Column
	private int tipo;

	@Transient
	private TipoAtributo tipoAtributo;

	@ManyToOne
	@JoinColumn(name = "tipo_centro_custo_id")
	private TipoCentroCusto tipoCentroCusto;

	public NomeAtributo() {
	}

	public NomeAtributo(String nome, boolean isObrigatorio, TipoAtributo tipo) {
		super();
		this.nome = nome;
		this.isObrigatorio = isObrigatorio;
		confTipoAtributo(tipo);
	}

	public NomeAtributo(String nome, TipoCentroCusto tipoCentroCusto,
			boolean isObrigatorio, TipoAtributo tipo) {
		super();
		this.nome = nome;
		this.tipoCentroCusto = tipoCentroCusto;
		this.isObrigatorio = isObrigatorio;
		confTipoAtributo(tipo);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isObrigatorio() {
		return isObrigatorio;
	}

	public void setObrigatorio(boolean isObrigatorio) {
		this.isObrigatorio = isObrigatorio;
	}

	public TipoAtributo recuperarTipoAtributo() {
		if(tipoAtributo == null)
			tipoAtributo = TipoAtributo.fromValue(tipo);
			
		return tipoAtributo;
	}

	public void confTipoAtributo(TipoAtributo tipoAtributo) {
		this.tipoAtributo = tipoAtributo;
		tipo = tipoAtributo.getValue();
	}

	private int getTipo() {
		return tipo;
	}

	private void setTipo(int tipo) {
		this.tipo = tipo;
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

	public void validarValor(Object value) throws Exception {
		if (isObrigatorio && value == null) {
			throw new Exception("Atributo " + nome + " com valor vazio");
		}

		if (!recuperarTipoAtributo().checkValueType(value)) {
			throw new Exception("Valor '" + tipoCentroCusto
					+ "' passado ao atributo " + nome
					+ " não confere com o tipo");
		}

	}
}