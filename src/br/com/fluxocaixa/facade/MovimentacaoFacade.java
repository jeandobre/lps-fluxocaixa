package br.com.fluxocaixa.facade;

import java.util.List;

import br.com.fluxocaixa.model.Categoria;
import br.com.fluxocaixa.model.CentroCusto;
import br.com.fluxocaixa.model.Movimentacao;
import br.com.fluxocaixa.model.Status;

public class MovimentacaoFacade {

	static class MovimentacaoFacadeStruct {
		public double valor;
		public Integer numeroParcela;
		public String observacao;
		public Categoria categoria;
		public TipoMovimentacaoEnum tipoMovimentacao;
		public Status status;
		public List<CentroCusto> centroCusto;
	}

	public Movimentacao inserir(MovimentacaoFacadeStruct movimentacaoFacadeStruct) {
		
	}
}
