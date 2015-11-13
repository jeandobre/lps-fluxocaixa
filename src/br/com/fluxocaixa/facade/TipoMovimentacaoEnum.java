package br.com.fluxocaixa.facade;

import br.com.fluxocaixa.dao.TipoMovimentacaoDAO;
import br.com.fluxocaixa.model.TipoMovimentacao;

public enum TipoMovimentacaoEnum {
	DESPESA("despesa"), RECEITA("receita"), TRANSFERENCIA("transferencia");
	
	private TipoMovimentacao tipoMovimentacao;
	
	TipoMovimentacaoEnum(String descricao){
		TipoMovimentacaoDAO tipoMovimentacaoDAO = new TipoMovimentacaoDAO();
		
		tipoMovimentacao = tipoMovimentacaoDAO.findTipoMovimentacaoByDescricao(descricao);
		
		if(tipoMovimentacao == null){
			tipoMovimentacao = new TipoMovimentacao(descricao);
			
			tipoMovimentacaoDAO.salvar(tipoMovimentacao);
		}
	}
	
	public TipoMovimentacao getTipoMovimentacao(){
		return tipoMovimentacao;
	}	
}
