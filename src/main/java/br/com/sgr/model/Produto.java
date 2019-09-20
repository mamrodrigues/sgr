package br.com.sgr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Produto extends BaseModel {
	
	private static final long serialVersionUID = -7252273539661743152L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	private String nome;
	
	private String descricao;
	
	private Double valor;
	
	@ManyToOne
	private Cardapio cardapio;
	
	@ManyToOne
	private Comanda comanda;
	
}
