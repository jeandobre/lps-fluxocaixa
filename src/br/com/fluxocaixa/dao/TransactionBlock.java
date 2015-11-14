package br.com.fluxocaixa.dao;

import org.hibernate.Session;

import br.com.fluxocaixa.util.HibernateUtil;

public class TransactionBlock {

    public static interface Command {
        void run(Session sessao);
    }

    public void doInTransaction(Command cmd) {
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        org.hibernate.Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            cmd.run(sessao);
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
}
