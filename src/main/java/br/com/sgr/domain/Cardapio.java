package br.com.sgr.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class Cardapio extends BaseModel {
	
	private static final long serialVersionUID = 1883804561271180115L;

	@Id
	@SequenceGenerator(name="cardapio_seq", sequenceName="cardapio_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cardapio_seq")
	@Column(name = "cardapio_id", unique = true, nullable = false)
	private int cardapioId;
	
	private String nome;
	
	private String descricao;
	
	@OneToMany(mappedBy = "cardapio")
	@JsonManagedReference
	private List<Produto> produtos;
	
	@ManyToOne
	@JsonBackReference
	private Estabelecimento estabelecimento;

}
