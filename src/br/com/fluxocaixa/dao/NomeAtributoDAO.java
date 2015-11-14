package br.com.fluxocaixa.dao;

import java.util.List;

import br.com.fluxocaixa.model.NomeAtributo;
import br.com.fluxocaixa.model.TipoCentroCusto;

public class NomeAtributoDAO extends GenericDAO<NomeAtributo>{
	
	public List<NomeAtributo> findByTipoCentroCusto(final TipoCentroCusto tipoCentroCusto){
		return findByColumnValue("tipoCentroCusto", tipoCentroCusto);
	}

}
