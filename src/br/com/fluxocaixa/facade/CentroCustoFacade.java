package br.com.fluxocaixa.facade;

import java.util.List;

import br.com.fluxocaixa.model.CentroCusto;
import br.com.fluxocaixa.model.NomeAtributo;
import br.com.fluxocaixa.model.TipoCentroCusto;
import br.com.fluxocaixa.model.ValorAtributo;

public class CentroCustoFacade {

	
	public CentroCusto criarNovoCentroCusto(TipoCentroCusto tipoCentroCusto, NomeAtributo [] nomesAtributos, Object... valores) throws Exception{
		List<ValorAtributo> 
		
		for (int i = 0; i < valores.length; i++) {
			NomeAtributo nomeAtributo = nomesAtributos[i];
			Object valor = valores[i];
			
			nomeAtributo.validarValor(valor);
			
			ValorAtributo valorAtributo = new ValorAtributo(valor, centroCusto, nomeAtributo);
			
		}
		
	}

}
