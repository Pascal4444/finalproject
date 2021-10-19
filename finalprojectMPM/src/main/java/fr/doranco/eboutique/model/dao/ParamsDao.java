package fr.doranco.eboutique.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.eboutique.entity.Params;
import fr.doranco.eboutique.model.connection.HibernateConnector;

public class ParamsDao implements IParamsDao {

	public ParamsDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addParams(Params params) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.save(params);
			tx = session.beginTransaction();
			tx.commit();
			
		} catch(HibernateException e) {
			tx.rollback();
			System.out.println(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void updateParams(Params params) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.update(params);
			tx = session.beginTransaction();
			tx.commit();
			
		} catch(HibernateException e) {
			tx.rollback();
			System.out.println(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		
	}

	@Override
	public void deleteParams(Integer id) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.delete(id);
			tx = session.beginTransaction();
			tx.commit();
			
		} catch(HibernateException e) {
			tx.rollback();
			System.out.println(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		
	}

	@Override
	public Params getParamsById(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		return session.find(Params.class, id);
	}

}
