package br.com.sgr.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sgr.model.Estabelecimento;

@Repository
public class EstabelecimentoDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Estabelecimento estabelecimento) {
		entityManager.persist(estabelecimento);
	}
}
