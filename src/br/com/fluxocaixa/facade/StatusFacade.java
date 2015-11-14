package br.com.fluxocaixa.facade;

import br.com.fluxocaixa.dao.StatusDAO;
import br.com.fluxocaixa.model.Status;

public class StatusFacade {
	
	StatusDAO statusDAO;
	private Status naoRealizado;
	private Status realizado;
	private Status atrasado;
	
	public StatusFacade(){
		statusDAO = new StatusDAO();
		configurarAmbiente();
	}
	
	private void configurarAmbiente(){
		naoRealizado = adicionarNovoStatus(Status.DESC_NAO_REALIZADO);
		realizado = adicionarNovoStatus(Status.DESC_REALIZADO);
		atrasado = adicionarNovoStatus(Status.DESC_ATRASADO);
	}
	
	public Status getNaoRealizado() {
		return naoRealizado;
	}

	public Status getRealizado() {
		return realizado;
	}

	public Status getAtrasado() {
		return atrasado;
	}

	public Status adicionarNovoStatus(String descricao){
		Status novoStatus = statusDAO.findByDescricao(descricao);
		
		if(novoStatus == null){
			novoStatus = new Status(descricao);
			statusDAO.salvar(novoStatus);
		}
				
		return novoStatus;
	}

}
