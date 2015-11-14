import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale.Category;

import br.com.fluxocaixa.facade.ContaFacade;
import br.com.fluxocaixa.facade.ContaFacade.CategoriaConta;
import br.com.fluxocaixa.facade.CategoriaFacade;
import br.com.fluxocaixa.facade.MovimentacaoFacade;
import br.com.fluxocaixa.facade.StatusFacade;
import br.com.fluxocaixa.model.Categoria;
import br.com.fluxocaixa.model.CentroCusto;
import br.com.fluxocaixa.model.Movimentacao;
import br.com.fluxocaixa.model.Status;
import br.com.fluxocaixa.model.TipoMovimentacao;

public class TesteCaixa {

	public static void main(String[] args) throws Exception {
		StatusFacade statusFacade = new StatusFacade();
		ContaFacade contaFacade = new ContaFacade();

		// Adicionando Contas
		CentroCusto conta = contaFacade.criarNovaConta(CategoriaConta.CARTEIRA, "banco do brasil",
				475, 58548, "Carlinhos", "9247-4584", 0.00, 15);
		
		Categoria [] categorias = {new Categoria("despesas gerais", null, false),
				new Categoria("receitas gerais", null, true)};
		
		CategoriaFacade categoriaFacade = new CategoriaFacade();
		
		for (Categoria categoria2 : categorias) {
			categoriaFacade.criarCategoria(categoria2);
		}
		
		// Listando Contas
		// Removendo Conta
		
		MovimentacaoFacade movimentacaoFacade = new MovimentacaoFacade();

		
		List<CentroCusto> centros = new ArrayList<CentroCusto>();
		
		centros.add(conta);

		Movimentacao despesa = new Movimentacao(new Date(),0,12.0,"Observado",
				TipoMovimentacao.DESPESA, categorias[0],centros);
		Movimentacao receita = new Movimentacao(new Date(),0,20.0,"receita",
				TipoMovimentacao.RECEITA, categorias[1],centros);
		
		
		MovimentacaoFacade movimenFacade = new MovimentacaoFacade();
		
		movimenFacade.inserir(despesa, statusFacade.getAtrasado());
		movimenFacade.inserir(receita, statusFacade.getNaoRealizado());
		
		
		
		System.out.println("Listando Categorias Despesas");
		
		
		for (Categoria categoria : categoriaFacade.listarCategoriaDespesas()) {
			System.out.println("Categoria: " + categoria.getNome());
		}
		
		System.out.println("Listando Categorias Receitas");
		
		
		for (Categoria categoria : categoriaFacade.listarCategoriaReceitas()) {
			System.out.println("Categoria: " + categoria.getNome());
		}
		
		
		List<CentroCusto> contas = contaFacade.getAll();
		for (CentroCusto centroCusto : contas) {
			System.out.println(centroCusto.getId());
			contaFacade.excluir(centroCusto);
		}
		
	}

}
