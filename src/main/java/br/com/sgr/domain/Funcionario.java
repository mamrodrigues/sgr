package br.com.sgr.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Funcionario extends BaseModel {
	
	private static final long serialVersionUID = -5007239783182270998L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	private String nome;
	
	@Column(unique = true)
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	@Enumerated(EnumType.STRING)
	private Perfil perfil;
	
	@ManyToOne
	private Estabelecimento estabelecimento;

}
