package br.com.sgr.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class Produto extends BaseModel {
	
	private static final long serialVersionUID = -7252273539661743152L;

	@Id
	@SequenceGenerator(name="produto_seq", sequenceName="produto_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
	@Column(name = "produto_id", unique = true, nullable = false)
	private int produtoId;
	
	private String nome;
	
	private String descricao;
	
	private double valor;
	
	@ManyToOne
	@JsonBackReference
	private Cardapio cardapio;
	
	@ManyToMany(mappedBy = "produtos")
	private List<Comanda> comandas;
	
}
