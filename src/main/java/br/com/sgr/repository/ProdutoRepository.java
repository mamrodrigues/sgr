package br.com.sgr.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.sgr.domain.Produto;

@Repository
public class ProdutoRepository extends BaseRepository<Produto> {

	public List<Produto> listaProdutosPorCardapio(int idCardapio) {		
		TypedQuery<Produto> query =
				entityManager.createQuery("select p from Produto p where p.cardapio.id= :pIdCardapio", Produto.class);

		query.setParameter("pIdCardapio", idCardapio);
		return query.getResultList();
	}
	
	public List<Produto> listaProdutosPorComanda(int idComanda) {
		String queryString = "select pr from Produto pr " + 
				"join pr.pedidos pe " +
				"where pe.comanda.comandaId = :pIdComanda";
		
		TypedQuery<Produto> query =
				entityManager.createQuery(queryString, Produto.class);
		query.setParameter("pIdComanda", idComanda);
		return query.getResultList();
	}
}
