package br.com.fluxocaixa.facade;

import java.util.Iterator;

import br.com.fluxocaixa.dao.CentroCustoDAO;
import br.com.fluxocaixa.dao.TipoCentroCustoDAO;
import br.com.fluxocaixa.model.CentroCusto;
import br.com.fluxocaixa.model.NomeAtributo;
import br.com.fluxocaixa.model.NomeAtributo.TipoAtributo;
import br.com.fluxocaixa.model.TipoCentroCusto;

public class ContaFacade {
	final static private String NOME_TIPO_CENTRO_CUSTO = "conta";
	final static private NomeAtributo[] NOME_ATRIBUTOS = {
			new NomeAtributo("tipo", true, TipoAtributo.STRING),
			new NomeAtributo("banco", true, TipoAtributo.STRING),
			new NomeAtributo("agência", true, TipoAtributo.INT),
			new NomeAtributo("número da conta", true, TipoAtributo.INT),
			new NomeAtributo("gerente", true, TipoAtributo.STRING),
			new NomeAtributo("telefone", true, TipoAtributo.STRING),
			new NomeAtributo("saldo inicial", true, TipoAtributo.DOUBLE),
			new NomeAtributo("vencimento", true, TipoAtributo.INT), };

	private TipoCentroCustoDAO tipoCustoDAO;
	private TipoCentroCusto tipoConta;

	static enum CategoriaConta {
		CARTÃO_CREDITO("cartao_credito"), CONTA_CORRENTE("conta_corrente"), CONTA_POUPANCA(
				"conta_poupanca"), CARTEIRA("carteira");

		private final String valor;

		CategoriaConta(String valor) {
			this.valor = valor;
		}

		public String getValor() {
			return valor;
		}
	}

	public ContaFacade() {
		tipoCustoDAO = new TipoCentroCustoDAO();

		configurarAmbiente();
	}

	private void configurarAmbiente() {
		tipoConta = tipoCustoDAO.findTipoCustoByNome(NOME_TIPO_CENTRO_CUSTO);

		if (tipoConta == null) {
			TipoCentroCustoFacade tipoCentroCustoFacade = new TipoCentroCustoFacade();

			tipoConta = tipoCentroCustoFacade.configurarNovoTipoCusto(
					NOME_TIPO_CENTRO_CUSTO, NOME_ATRIBUTOS);
		}
		
		for (NomeAtributo nomeAtributo : NOME_ATRIBUTOS) {
			nomeAtributo.setTipoCentroCusto(tipoConta);
		}
	}

	public TipoCentroCusto getTipoConta() {
//		if (tipoConta == null)
//			tipoConta = tipoCustoDAO
//					.findTipoCustoByNome(NOME_TIPO_CENTRO_CUSTO);

		return tipoConta;
	}

	public CentroCusto criarNovaConta(CategoriaConta tipoConta, String banco,
			int agencia, int numeroConta, String telefone, double saldoInicial,
			int vencimento) throws Exception {

		if (agencia <= 0) {
			throw new Exception("O valor da agência é menor ou igual a zero");
		}

		if (numeroConta <= 0) {
			throw new Exception("O número da conta");
		}

		String[] valores = {};

		CentroCustoFacade centroCustoFacade = new CentroCustoFacade();

		return centroCustoFacade.criarNovoCentroCusto(getTipoConta(),
				NOME_ATRIBUTOS, new Integer(tipoConta.getValor()), banco,
				new Integer(agencia), new Integer(numeroConta), telefone,
				new Double(saldoInicial), new Integer(vencimento));
	}

}
