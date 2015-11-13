package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;
import FluxoCaixaConceitual.TipoCentroCusto;

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

}
