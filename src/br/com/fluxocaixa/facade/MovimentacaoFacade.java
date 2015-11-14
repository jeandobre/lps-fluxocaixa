package br.com.fluxocaixa.facade;

import org.hibernate.Session;

import br.com.fluxocaixa.dao.HistoricoStatusDAO;
import br.com.fluxocaixa.dao.MovimentacaoDAO;
import br.com.fluxocaixa.dao.TransactionBlock;
import br.com.fluxocaixa.dao.TransactionBlock.Command;
import br.com.fluxocaixa.model.Categoria;
import br.com.fluxocaixa.model.HistoricoStatus;
import br.com.fluxocaixa.model.Movimentacao;
import br.com.fluxocaixa.model.Status;
import br.com.fluxocaixa.model.TipoMovimentacao;

public class MovimentacaoFacade {

	public Movimentacao inserir(Movimentacao movimentacao,Status status) throws Exception {
		
		if(movimentacao.getObservacao() == null || movimentacao.getObservacao().isEmpty()){
			throw new Exception("Observacao vazia");
		}
		
		if(movimentacao.getValor() <= 0){
			throw new Exception("Valor menor ou igual a zero");
		}
		
		if(movimentacao.getNumeroParcela().intValue() < 0){
			throw new Exception("Parcela menor que zero");
		}
		
		if(movimentacao.getNumeroParcela().intValue() < 0){
			throw new Exception("Parcela menor que zero");
		}
		
		Categoria categoria = movimentacao.getCategoria();
		TipoMovimentacao tipoMovimentacao = movimentacao.recuperarTipoMovimentacao();
		
		if(categoria != null){
			if(categoria.isReceita() && tipoMovimentacao != TipoMovimentacao.RECEITA )
				throw new Exception("Utilizando categoria de despesa em uma receita");
			
			if(!categoria.isReceita() && tipoMovimentacao != TipoMovimentacao.DESPESA )
				throw new Exception("Utilizando categoria de receita  em uma despesa");
		}
		
		if(status.isRealizado() && movimentacao.getData() == null){
			throw new Exception("Movimentação foi realizada, porém não tem a data de pagamento");
		}
		
		Command command = new Command() {
			@Override
			public void run(Session sessao) {
				new MovimentacaoDAO().salvar(movimentacao, sessao);
				new HistoricoStatusDAO().salvar(new HistoricoStatus(status, movimentacao),sessao);
			}
		};
		
		new TransactionBlock().doInTransaction(command);
		
		return null;
	}
}
