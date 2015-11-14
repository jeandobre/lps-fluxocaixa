import java.util.Date;
import java.util.List;
import java.util.Locale.Category;

import br.com.fluxocaixa.facade.ContaFacade;
import br.com.fluxocaixa.facade.ContaFacade.CategoriaConta;
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
		
		// Listando Contas
		// Removendo Conta
		
		MovimentacaoFacade movimentacaoFacade = new MovimentacaoFacade();
	
		
		Movimentacao movimentacao = new Movimentacao(new Date(),0,12,"Observado",
				TipoMovimentacao.DESPESA, categoria,conta);
		
		List<CentroCusto> contas = contaFacade.getAll();
		for (CentroCusto centroCusto : contas) {
			System.out.println(centroCusto.getId());
			contaFacade.excluir(centroCusto);
		}
		
		
		
		
		
		
	}

}
