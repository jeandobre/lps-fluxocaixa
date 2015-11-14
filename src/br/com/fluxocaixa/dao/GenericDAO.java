package br.com.fluxocaixa.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.fluxocaixa.model.TipoCentroCusto;
import br.com.fluxocaixa.model.TipoMovimentacao;
import br.com.fluxocaixa.util.HibernateUtil;

public class GenericDAO<Entidade> {

	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected boolean exists(final Criteria query) {
		query.setProjection(Projections.rowCount());
		return query.uniqueResult() != null;
	}

	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			salvar(entidade, sessao);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

	public void salvar(Entidade entidade, Session sessao) {
		sessao.save(entidade);
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			return listar(sessao);
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

	public List<Entidade> listar(Session sessao) {
		Criteria consulta = sessao.createCriteria(classe);
		List<Entidade> resultado = consulta.list();
		return resultado;
	}

	@SuppressWarnings("unchecked")
	public Entidade buscar(Long codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			return buscar(codigo, sessao);
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

	private Entidade buscar(Long codigo, Session sessao) {
		Criteria consulta = sessao.createCriteria(classe);
		consulta.add(Restrictions.idEq(codigo));
		Entidade resultado = (Entidade) consulta.uniqueResult();
		return resultado;
	}

	public void excluir(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			delete(entidade, sessao);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

	public void delete(Entidade entidade, Session sessao) {
		sessao.delete(entidade);
	}

	public void editar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			update(entidade, sessao);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

	public void update(Entidade entidade, Session sessao) {
		sessao.update(entidade);
	}

	public void merge(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			merge(entidade, sessao);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

	public void merge(Entidade entidade, Session sessao) {
		sessao.merge(entidade);
	}

	public Entidade uniqueResultByColumnValue(String nomeColuna,
			Object valorColuna) {
		String[] nomesColuna = { nomeColuna };
		Object[] valoresColuna = { valorColuna };

		return uniqueResultByColumnsValues(nomesColuna, valoresColuna);
	}

	public Entidade uniqueResultByColumnsValues(String[] nomesColuna,
			Object[] valoresColuna) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = createByColumnsValues(nomesColuna,
					valoresColuna, sessao);

			return (Entidade) consulta.uniqueResult();
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

	public List<Entidade> findByColumnValue(String nomeColuna,
			Object valorColuna) {
		String[] nomesColuna = { nomeColuna };
		Object[] valoresColuna = { valorColuna };

		return findByColumnsValues(nomesColuna, valoresColuna);
	}

	public List<Entidade> findByColumnsValues(String[] nomesColuna,
			Object[] valoresColuna) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = createByColumnsValues(nomesColuna,
					valoresColuna, sessao);

			return consulta.list();
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

	private Criteria createByColumnsValues(String[] nomesColuna,
			Object[] valoresColuna, Session sessao) {
		Criteria consulta = sessao.createCriteria(classe);
		for (int i = 0; i < nomesColuna.length; i++) {
			consulta.add(Restrictions.eq(nomesColuna[i], valoresColuna[i]));
		}
		return consulta;
	}
}
