package br.com.fluxocaixa.model;


public enum TipoMovimentacao {
	DESPESA(1), RECEITA(2), TRANSFERENCIA(3);
	
	final private int valor;

	private TipoMovimentacao(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
	
	static public TipoMovimentacao getByValue(int value){
		for (TipoMovimentacao tipoMovimentacao : TipoMovimentacao.values()) {
			if(tipoMovimentacao.getValor() == value)
				return tipoMovimentacao;
		}
		
		return null;
	}
}

//@Entity
//@Table(name = "tipo_movimentacao",
//	uniqueConstraints=@UniqueConstraint(columnNames = {"descricao"}))
//public class TipoMovimentacao {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column
//	private Integer id;
//	
//	@Column
//	private String descricao;
//	
//	public TipoMovimentacao(){
//		
//	}
//	
//	public TipoMovimentacao(String descricao) {
//		super();
//		this.descricao = descricao;
//	}
//
//
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getDescricao() {
//		return descricao;
//	}
//
//	public void setDescricao(String descricao) {
//		this.descricao = descricao;
//	}
//}
