package br.com.sgr.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BaseRepository<T> {

	public BaseRepository() {
	}

	@PersistenceContext
	private EntityManager entityManager;

	public void save(T entity) {
		entityManager.persist(entity);
	}

	public void update(int id, Class<T> persistedClass) {
		T entity = entityManager.find(persistedClass, id);
		entityManager.persist(entity);
	}

	public void remove(int id, Class<T> persistedClass) {
		T entity = entityManager.find(persistedClass, id);
		entityManager.remove(entity);
	}

	public List<T> list(Class<T> persistedClass) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		return entityManager.createQuery(query).getResultList();
	}

	public T get(int id, Class<T> persistedClass) {
		return entityManager.find(persistedClass, id);
	}

}
