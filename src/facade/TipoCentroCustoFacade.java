package facade;

import java.util.ArrayList;
import java.util.List;

import dao.TipoCentroCustoDAO;
import FluxoCaixaConceitual.NomeAtributo;
import FluxoCaixaConceitual.TipoCentroCusto;

public class TipoCentroCustoFacade {
	
	TipoCentroCustoDAO tipoCentroCustoDAO = new TipoCentroCustoDAO();
	
	public boolean existeTipoCusto(String nome){
		return tipoCentroCustoDAO.
	}

	public TipoCentroCusto configurarNovoTipoCusto(String nomeCentroCusto, List<String> nomeAtributos ){
		List<NomeAtributo> nomeAtributos2 = new ArrayList<NomeAtributo>();
		TipoCentroCusto tipoCentroCusto = new TipoCentroCusto(nomeCentroCusto); 
		
		for (String nomeAtributo : nomeAtributos) {
			nomeAtributos2.add(new NomeAtributo(nomeAtributo, tipoCentroCusto));
		}
		
		
		
	}
}
