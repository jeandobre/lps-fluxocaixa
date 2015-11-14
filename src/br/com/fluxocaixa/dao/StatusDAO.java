package br.com.fluxocaixa.dao;

import br.com.fluxocaixa.model.Status;

public class StatusDAO extends GenericDAO<Status>{
	
	
	public Status findByDescricao(String descricao){
		return uniqueResultByColumnValue("descricao", descricao);
	}

}
