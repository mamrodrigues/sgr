package br.com.sgr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class Endereco extends BaseModel {
	
	private static final long serialVersionUID = -5332217832839212712L;

	@Id
	@SequenceGenerator(name="endereco_seq", sequenceName="endereco_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_seq")
	@Column(name = "endereco_id", unique = true, nullable = false)
	private int enderecoId;
	
	private String endereco;

	private String cep;

	private String numero;

	private String cidade;

	private String estado;
	
	@OneToOne(mappedBy = "endereco")
	@JsonManagedReference(value="endereco-estabelecimento") //@JsonBackReference
	private Estabelecimento estabelecimento;
}
