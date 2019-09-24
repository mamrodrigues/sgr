package br.com.sgr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Endereco extends BaseModel {
	
	private static final long serialVersionUID = -5332217832839212712L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	private String endereco;

	private String cep;

	private String numero;

	private String cidade;

	private String estado;
	
	@OneToOne(mappedBy = "endereco")
	@JoinColumn(unique = true)
	private Estabelecimento estabelecimento;

}
