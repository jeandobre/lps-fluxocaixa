package br.com.fluxocaixa.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.fluxocaixa.model.TipoCentroCusto;
import br.com.fluxocaixa.util.HibernateUtil;

public class TipoCentroCustoDAO extends GenericDAO<TipoCentroCusto>{
	
	public boolean existeTipoCusto(String nome){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(TipoCentroCusto.class);
			consulta.add(Restrictions.eq("nome", nome));
			return exists(consulta);
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	public TipoCentroCusto findTipoCustoByNome(String nome){
		return uniqueResultByColumnValue("nome", nome);
	}

}
