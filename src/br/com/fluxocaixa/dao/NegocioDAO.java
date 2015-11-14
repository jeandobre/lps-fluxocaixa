package br.com.fluxocaixa.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mysql.fabric.xmlrpc.base.Data;

import br.com.fluxocaixa.model.Categoria;
import br.com.fluxocaixa.model.Despesa;
import br.com.fluxocaixa.model.FluxoCaixa;
import br.com.fluxocaixa.model.Realizado;
import br.com.fluxocaixa.model.Receita;
import br.com.fluxocaixa.model.Status;
import br.com.fluxocaixa.util.Conexao;

public class NegocioDAO {

	private Session session;

	public void salvarGenerico(Object object) {
		// obtem uma sessao
		session = Conexao.getInstance();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(object);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();

			tx.rollback();
		} finally {
			session.close();
		}
	}

	public void inserirReceitas(Receita receita, Status estado) {
		
		if(estado == null){
			System.out.println("Estado da receita inválido");
			return;
		}
		
		if(receita.getCentrosCusto().isEmpty()){
			System.out.println("Nenhum centro de custo foi selecionado");
			return;
		}
		
		if(receita.getCategoria() == null){
			System.out.println("Categoria da receita precisa ser selecionada");
			return;
		}
		
		if(estado instanceof Realizado &&  estado.getData().compareTo(new Date()) > 0){
			System.out.println("Data de pagamento inválida");
			return;
		}
		
		if(receita.getValor() <= 0){
			System.out.println("Valor inválido");
			return;
		}
		
		if(receita.getNumeroParcela() <= 0){
			System.out.println("Número de parcelas inválido");
			return;
		}
		
		
		salvarGenerico(receita);
	}

}
