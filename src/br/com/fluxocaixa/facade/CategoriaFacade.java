package br.com.fluxocaixa.facade;

import java.util.List;

import br.com.fluxocaixa.dao.CategoriaDAO;
import br.com.fluxocaixa.model.Categoria;

public class CategoriaFacade {

	public Categoria criarCategoria(Categoria categoria) throws Exception{
		Categoria pai =categoria.getPai(); 
		
		if( pai != null && pai.isReceita() != categoria.isReceita())
			throw new Exception("Pai da categoria é de outro tipo");
		
		List<Categoria> filhos = categoria.getFilhos();
		
		if( filhos != null)
			for (Categoria filho : filhos) {
				if(filho.isReceita() != categoria.isReceita())
					throw new Exception("Filho da categoria é de outro tipo");
			}
		
		
		 new CategoriaDAO().salvar(categoria);
		 
		 return categoria;
	}
	
	public List<Categoria> listarCategoriaDespesas(){
		return new CategoriaDAO().findByIsReceita(false);
	}
	
	public List<Categoria> listarCategoriaReceitas(){
		return new CategoriaDAO().findByIsReceita(true);	
	}
}
