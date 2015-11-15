import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.fluxocaixa.dao.NegocioDAO;
import br.com.fluxocaixa.model.Carteira;
import br.com.fluxocaixa.model.Categoria;
import br.com.fluxocaixa.model.CategoriaCredito;
import br.com.fluxocaixa.model.CategoriaDebito;
import br.com.fluxocaixa.model.CentroCusto;
import br.com.fluxocaixa.model.ContaCorrente;
import br.com.fluxocaixa.model.Despesa;
import br.com.fluxocaixa.model.NaoRealizado;
import br.com.fluxocaixa.model.Realizado;
import br.com.fluxocaixa.model.Receita;

public class Principal {
	
	
	public static void main(String[] args) {

	}
	
	void exemploListarMovimentos(){
		NegocioDAO negocio = new NegocioDAO();  
		List<Despesa> lista = negocio.listarDespesas(new Date(), new Date(), "");
		for(Despesa d: lista){
			System.out.println(d);
		}
		
		List<Receita> ls = negocio.listarReceitas();
		for(Receita r: ls){
			System.out.println(r);
		}
	}
	
	void exemploCategoriaCredito(){
		NegocioDAO negocio = new NegocioDAO(); 
		
		Categoria categoria = new CategoriaCredito();
		categoria.setNome("Salário");
	    categoria.setDescricao("Salário mensal"); 
		categoria.setPai(null);

		negocio.salvarGenerico(categoria);
	}
	
	void exemploCategoriaDebito(){
		NegocioDAO negocio = new NegocioDAO(); 
		
		Categoria categoria = new CategoriaDebito();
		categoria.setNome("Conta de água");
	    categoria.setDescricao("Conta mensal de águal (Sanesul)"); 
		categoria.setPai(null);

		negocio.salvarGenerico(categoria);
	}
	
	void exemploReceita(){
		NegocioDAO negocio = new NegocioDAO(); 
		
		//aqui tem que negar quando for categoria debito
		Receita receita = new Receita();
		receita.setCategoria(new CategoriaCredito());
		receita.getCategoria().setNome("Vendas");
		receita.getCategoria().setDescricao("Vendas gerais");
		
		receita.setData(new Date());
		receita.setNumeroParcela(1);
		receita.setValor(new Float(250));
		receita.setObservacao("venda para cliente prazo de 1 mês");
		
		NaoRealizado estado = new NaoRealizado();
		estado.setMovimentacao(receita);
		estado.setData(new Date());
		
		Carteira conta = new Carteira();
		conta.setNome("Carteira Jean");
		conta.setDescricao("Carteira local");
		
		List<CentroCusto> custos = new ArrayList<CentroCusto>(1);
		custos.add(conta);
		receita.setCentrosCusto(custos);
		
		negocio.inserirReceitas(receita, estado);
	}
	
	void exemploDespesa(){
		NegocioDAO negocio = new NegocioDAO(); 
		
		Despesa despesa = new Despesa();
		CategoriaDebito categoria = (CategoriaDebito) negocio.getById(CategoriaDebito.class, 1);
		ContaCorrente cc = (ContaCorrente) negocio.getById(ContaCorrente.class, 1);
		
		despesa.setCategoria(categoria);
		
		despesa.setData(new Date());
		despesa.setNumeroParcela(1);
		despesa.setValor(new Float(65.90));
		despesa.setObservacao("Pagamento refernte ao fluxo geral");
		
		Realizado estado = new Realizado();
		estado.setMovimentacao(despesa);
		estado.setData(new Date());
		
		List<CentroCusto> custos = new ArrayList<CentroCusto>(1);
		custos.add(cc);
		despesa.setCentrosCusto(custos);
		
		negocio.inserirDespesas(despesa, estado);
	}

}
