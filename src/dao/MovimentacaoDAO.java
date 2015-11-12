package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;
import FluxoCaixaConceitual.Movimentacao;
import FluxoCaixaConceitual.TipoMovimentacao;

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
