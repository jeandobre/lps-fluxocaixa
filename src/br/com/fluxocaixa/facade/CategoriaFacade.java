package br.com.fluxocaixa.facade;

import br.com.fluxocaixa.dao.CategoriaDAO;
import br.com.fluxocaixa.model.Categoria;

public class CategoriaFacade {

	public Categoria criarCategoria(Categoria categoria){
		 new CategoriaDAO().salvar(categoria);
		 
		 return categoria;
	}
}
