package br.com.sgr.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class Pedido extends BaseModel {
	
	@Id
	@SequenceGenerator(name="pedido_seq", sequenceName="pedido_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_seq")
	@Column(name = "pedido_seq", unique = true, nullable = false)
	private int pedidoId;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "produto_id")
	@JsonBackReference(value = "produto-pedido")
	private Produto produto;
 
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "comanda_id")
	@JsonBackReference(value = "comanda-pedido")
	private Comanda comanda;
	
}
