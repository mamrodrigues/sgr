package br.com.sgr.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	private double valor;
	
	@ManyToOne
	private Cardapio cardapio;
	
	@ManyToMany(mappedBy = "produtos")
	private List<Comanda> comandas;
	
}
