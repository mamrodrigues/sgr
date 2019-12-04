package br.com.sgr.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.sgr.domain.Pedido;
import br.com.sgr.domain.Produto;

@Repository
public class PedidoRepository extends BaseRepository<Pedido> {
	
//	public List<Pedido> getPedidosComanda(int comandaId){
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		
//		CriteriaQuery<Pedido> cq = cb.createQuery(Pedido.class);
////        Root<Pedido> p = cq.from(Pedido.class);		
////		
////        CriteriaQuery<Pedido> all = cq.select(p);
////        TypedQuery<Pedido> allQuery = entityManager.createQuery(all);
////        return allQuery.getResultList();
//        
//        
//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Pedido> query = builder.createQuery(Pedido.class);
//		Root<Pedido> from = query.from(Pedido.class);
//		TypedQuery<Pedido> typedQuery = entityManager.createQuery(
//				query
//				.select(from)
//				.where(
//						builder.equal(
//								from.join("comanda").get("comandaId"), comandaId
//								)
//						)
//		);
//		return typedQuery.getResultList();
//        
//		
////		TypedQuery<Pedido> query =
////				entityManager.createQuery("select p from Pedido p where p.comanda.comandaId= :pIdComanda", Pedido.class);
////
////		query.setParameter("pIdComanda", idComanda);
////		return query.getResultList();
//	}
	
	public List<Pedido> getPedidosComanda(int idComanda) {
		String queryString = "select pe from Pedido pe " + 
				"join pe.produto pr " +
				"where pe.comanda.comandaId = :pIdComanda";
		
		TypedQuery<Pedido> query =
				entityManager.createQuery(queryString, Pedido.class);
		query.setParameter("pIdComanda", idComanda);
		return query.getResultList();
	}

}
