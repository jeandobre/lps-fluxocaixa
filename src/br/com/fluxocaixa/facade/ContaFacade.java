package br.com.fluxocaixa.facade;

import br.com.fluxocaixa.dao.TipoCentroCustoDAO;
import br.com.fluxocaixa.model.TipoCentroCusto;

public class ContaFacade {
	final static private String NOME_TIPO_CENTRO_CUSTO = "conta";
	final static private String [] NOME_ATRIBUTOS = {"id","tipo","banco"
	                                                 ,"agência","número da conta",
	                                                 "gerente", "telefone",
	                                                 "saldo inicial", "vencimento"};
	
	private TipoCentroCustoDAO tipoCustoDAO;
	private TipoCentroCusto conta;
	
	public ContaFacade(){
		tipoCustoDAO = new TipoCentroCustoDAO();
	}
	
	public void configurarAmbiente(){
		conta = tipoCustoDAO.findTipoCusto(NOME_TIPO_CENTRO_CUSTO);
		
		if(conta == null){
			TipoCentroCustoFacade tipoCentroCustoFacade = new TipoCentroCustoFacade();
			
			conta = tipoCentroCustoFacade.configurarNovoTipoCusto(NOME_TIPO_CENTRO_CUSTO, NOME_ATRIBUTOS);
		}
	}
	
	
	public TipoCentroCusto getTipoConta(){
		if (conta == null)
			conta = tipoCustoDAO.findTipoCusto(NOME_TIPO_CENTRO_CUSTO);
		
		return conta;
	}
}
