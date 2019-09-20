package br.com.sgr.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Cardapio extends BaseModel {
	
	private static final long serialVersionUID = 1883804561271180115L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@OneToMany(mappedBy = "cardapio")
	private List<Produto> produtos;
	
	@ManyToOne
	private Estabelecimento estabelecimento;

}
