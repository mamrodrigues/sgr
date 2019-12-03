package br.com.sgr.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
//@JsonDeserialize(using = EnderecoDeserealizer.class)
public class Estabelecimento extends BaseModel {

	private static final long serialVersionUID = 7301559206009473592L;

	@Id
	@SequenceGenerator(name="estabelecimento_seq", sequenceName="estabelecimento_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estabelecimento_seq")
	@Column(name = "estabelecimento_id", unique = true, nullable = false)
	private int estabelecimentoId;
	
	private String nome;
	
	private String endereco;

	private String cep;

	private String numero;

	private String cidade;

	private String estado;
	
	@Column(unique = true)
	private String cnpj;
	
//	@OneToOne
//	@JoinColumn(name = "endereco_id")
//	@JsonBackReference(value="endereco-estabelecimento") //@JsonManagedReference
//	private Endereco endereco;
	
	@OneToMany
	@JsonManagedReference(value="funcionario-estabelecimento")
	private List<Funcionario> funcionarios;
	
	@OneToMany
	@JsonManagedReference(value="cardapio-estabelecimento")
	private List<Cardapio> cardapio;
	
}
