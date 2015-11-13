package br.com.fluxocaixa.facade;

import br.com.fluxocaixa.dao.StatusDAO;
import br.com.fluxocaixa.model.Status;

public class StatusFacade {
	
	StatusDAO statusDAO;
	
	public StatusFacade(){
		statusDAO = new StatusDAO();
	}
	
	public Status adicionarNovoStatus(String descricao){
		Status novoStatus = new Status(descricao);
		
		statusDAO.salvar(novoStatus);
		
		return novoStatus;
	}

}
