package br.com.sgr.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Estabelecimento extends BaseModel {

	private static final long serialVersionUID = 7301559206009473592L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	private String nome;
	
	@Column(unique = true)
	private String cnpj;
	
	@OneToOne
	@JoinColumn(unique=true)
	private Endereco endereco;
	
	@OneToMany(mappedBy = "estabelecimento")
	private List<Funcionario> funcionarios;
	
	@OneToMany(mappedBy = "estabelecimento")
	private List<Cardapio> cardapio;
	
}
