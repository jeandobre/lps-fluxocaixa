package br.com.fluxocaixa.facade;

import java.util.ArrayList;
import java.util.List;

import br.com.fluxocaixa.dao.TipoCentroCustoDAO;
import br.com.fluxocaixa.model.NomeAtributo;
import br.com.fluxocaixa.model.TipoCentroCusto;

public class TipoCentroCustoFacade {
	
	private TipoCentroCustoDAO tipoCentroCustoDAO;
	
	public TipoCentroCustoFacade(){
		tipoCentroCustoDAO = new TipoCentroCustoDAO();
	}
	
	public TipoCentroCustoFacade(TipoCentroCustoDAO tipoCentroCustoDAO) {
		super();
		this.tipoCentroCustoDAO = tipoCentroCustoDAO;
	}

	public boolean existeTipoCusto(String nome){
		return tipoCentroCustoDAO.existeTipoCusto(nome);
	}

	public TipoCentroCusto configurarNovoTipoCusto(String nomeCentroCusto, NomeAtributo [] nomeAtributos ){
		List<NomeAtributo> nomeAtributos2 = new ArrayList<NomeAtributo>();
		TipoCentroCusto tipoCentroCusto = new TipoCentroCusto(nomeCentroCusto); 
		
		for (NomeAtributo nomeAtributo : nomeAtributos) {
			nomeAtributo.setTipoCentroCusto(tipoCentroCusto);
			nomeAtributos2.add(nomeAtributo);
		}
		
		tipoCentroCusto.setNomesAtributo(nomeAtributos2);
		
		tipoCentroCustoDAO.salvar(tipoCentroCusto);
		
		return tipoCentroCusto;
	}
}
