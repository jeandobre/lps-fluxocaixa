package br.com.fluxocaixa.facade;

import java.util.ArrayList;
import java.util.List;

import br.com.fluxocaixa.dao.CentroCustoDAO;
import br.com.fluxocaixa.model.CentroCusto;
import br.com.fluxocaixa.model.NomeAtributo;
import br.com.fluxocaixa.model.TipoCentroCusto;
import br.com.fluxocaixa.model.ValorAtributo;

public class CentroCustoFacade {
	
	public CentroCusto criarNovoCentroCusto(TipoCentroCusto tipoCentroCusto,List<NomeAtributo>  nomesAtributos, Object... valores) throws Exception{
		List<ValorAtributo> valoresAtributos = new ArrayList<ValorAtributo>(); 
		CentroCusto centroCusto = new CentroCusto(tipoCentroCusto);
		
		if(valores.length != nomesAtributos.size()){
			throw new Exception("O número de valores eatributos passados não batem");
		}
		
		for (int i = 0; i < valores.length; i++) {
			NomeAtributo nomeAtributo = nomesAtributos.get(i);
			Object valor = valores[i];
			
			nomeAtributo.validarValor(valor);
			
			valoresAtributos.add(new ValorAtributo(valor, centroCusto, nomeAtributo));
		}
		
		centroCusto.setValores(valoresAtributos);
		
		CentroCustoDAO centroCustoDAO = new CentroCustoDAO();
		
		centroCustoDAO.salvar(centroCusto);
	
		return centroCusto;
	}
	
	public List<CentroCusto> getAll(){
		return new CentroCustoDAO().listar();
	}

	public CentroCusto excluir(CentroCusto centroCusto) {
		// TODO Auto-generated method stub
		new CentroCustoDAO().excluir(centroCusto);
		
		return centroCusto;
	}

}
