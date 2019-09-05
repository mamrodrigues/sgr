package br.com.sgr.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class BaseDAO<BaseModel> {

	protected static SessionFactory factory;

	public BaseDAO() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public Integer persist(BaseModel entity) {
		Session session = factory.openSession();
		Integer id = null;
		try {
			Transaction tx = session.beginTransaction();
			id = (Integer) session.save(entity);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return id;
	}

	public void update(BaseModel entity) {
		Session session = factory.openSession();

		try {
			Transaction tx = session.beginTransaction();
			session.update(entity);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public BaseModel findById(Class<BaseModel> classBaseModel, int id) {

		Session session = factory.openSession();
		BaseModel baseModel = null;

		try {
			baseModel = session.find(classBaseModel, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return baseModel;
	}

	public void delete(BaseModel entity) {
		Session session = factory.openSession();

		try {
			Transaction tx = session.beginTransaction();
			session.delete(entity);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public List<BaseModel> findAll(Class<BaseModel> classBaseModel) {
		Session session = factory.openSession();

		try {
			return session.createCriteria(classBaseModel).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
