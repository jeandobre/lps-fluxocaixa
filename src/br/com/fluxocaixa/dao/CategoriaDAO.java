package br.com.fluxocaixa.dao;

import java.util.List;

import br.com.fluxocaixa.model.Categoria;

public class CategoriaDAO extends GenericDAO<Categoria>{
	
	public List<Categoria> findByIsReceita(boolean isReceita){
		return findByColumnValue("isReceita", isReceita );
	}

}
