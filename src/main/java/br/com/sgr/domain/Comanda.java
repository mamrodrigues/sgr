package br.com.sgr.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class Comanda extends BaseModel {
	
	private static final long serialVersionUID = 2358804140523026854L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comanda_id", unique = true, nullable = false)
	private int comandaId;
	
	private String nome;
	
	@OneToMany(mappedBy = "comanda")
	@JsonManagedReference(value = "comanda-pedido")
	private List<Pedido> pedidos;
	
	private boolean isFechada;

}
