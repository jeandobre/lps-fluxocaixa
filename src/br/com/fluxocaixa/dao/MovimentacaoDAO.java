package br.com.fluxocaixa.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.fluxocaixa.model.Movimentacao;
import br.com.fluxocaixa.model.TipoMovimentacao;
import br.com.fluxocaixa.util.HibernateUtil;

public class MovimentacaoDAO extends GenericDAO<Movimentacao> {
	
	List<Movimentacao> listar(TipoMovimentacao tipoMovimentacao){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			Criteria consulta = sessao.createCriteria(Movimentacao.class);
			consulta.add(Restrictions.eq("tipoMovimentacao", tipoMovimentacao));
			List<Movimentacao> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
		
	}
}
