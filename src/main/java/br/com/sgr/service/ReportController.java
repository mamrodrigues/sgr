package br.com.sgr.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReportController {
	
	/*
	 * public Contrato create(Contrato contrato) {
	 * 
	 * Agendamento agendamento = new Agendamento(); agendamento.setData(new Date());
	 * Integer idAgendamento = new AgendamentoDAO().persist(agendamento);
	 * agendamento.setId(idAgendamento); contrato.setAgendamento(agendamento);
	 * 
	 * double valorServicos = 0;
	 * 
	 * for(Servico servico: contrato.getServicos()) { valorServicos +=
	 * TipoServico.valueOf(servico.getTipo()).getValor(); Integer idServico = new
	 * ServicoDAO().persist(servico); servico.setId(idServico); }
	 * contrato.setValorServicos(valorServicos);
	 * contrato.setValorTotal(valorServicos + contrato.getValorDeslocamento());
	 * 
	 * EnderecoDAO enderecoDAO = new EnderecoDAO(); ObjectMapper mapper = new
	 * ObjectMapper();
	 * 
	 * try { Contratada contratada = mapper.readValue(new
	 * File(".//mocks//contratada.json"), Contratada.class); Integer idEndereco =
	 * enderecoDAO.persist(contratada.getEndereco());
	 * contratada.getEndereco().setId(idEndereco);
	 * 
	 * Integer idContratada = new ContratadaDAO().persist(contratada);
	 * contratada.setId(idContratada);
	 * 
	 * contrato.setContratada(contratada); } catch (IOException e) {
	 * e.printStackTrace(); }
	 * 
	 * 
	 * Integer idEndereco = enderecoDAO.persist(contrato.getEndereco());
	 * contrato.getEndereco().setId(idEndereco);
	 * 
	 * Integer idEnderecoContratante =
	 * enderecoDAO.persist(contrato.getCliente().getEndereco());
	 * contrato.getCliente().getEndereco().setId(idEnderecoContratante);
	 * 
	 * Integer idContratante = new ClienteDAO().persist(contrato.getCliente());
	 * contrato.getCliente().setId(idContratante);
	 * 
	 * Integer idContrato = new ContratoDAO().persist(contrato);
	 * contrato.setId(idContrato);
	 * 
	 * return contrato; }
	 */
}
