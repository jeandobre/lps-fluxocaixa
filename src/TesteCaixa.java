import br.com.fluxocaixa.facade.ContaFacade;
import br.com.fluxocaixa.facade.StatusFacade;
import br.com.fluxocaixa.model.Status;

public class TesteCaixa {

	public static void main(String[] args) {
		StatusFacade statusFacade = new StatusFacade();
		ContaFacade contaFacade = new ContaFacade();

		contaFacade.configurarAmbiente();

		Status aguardandoPagamento = statusFacade
				.adicionarNovoStatus("aguardando pagamento");
		Status pago = statusFacade
				.adicionarNovoStatus("pago");
		Status atrasado = statusFacade
				.adicionarNovoStatus("atrasado");
		
		
		//Adicionando Contas
		
		
		// Listando Contas
		
		// Removendo Conta
		
		

	}

}
