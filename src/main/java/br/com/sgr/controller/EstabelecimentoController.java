package br.com.sgr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgr.dao.EstabelecimentoDAO;
import br.com.sgr.model.Estabelecimento;

//@CrossOrigin(origins = "https://sgr.herokuapp.com", maxAge = 3600)
@RestController
@RequestMapping("/sgr")
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoDAO estabelecimentoDAO;

	@RequestMapping(value = "/estabelecimentos", method = RequestMethod.POST)
	public void salvar(@RequestBody Estabelecimento estabelecimento) {
		estabelecimentoDAO.persist(estabelecimento);
	}

//	@RequestMapping(value = "/estabelecimentos/{id}", method = RequestMethod.GET)
//	public Estabelecimento recuperar(@PathVariable("id") int id) {
//		return estabelecimentoDAO.(Estabelecimento.class, id);
//	}

//	@RequestMapping(value = "/estabelecimentos", params = { "nome" }, method = RequestMethod.GET)
//	public List<Estabelecimento> recuperar(@RequestParam("nome") String nome) {
//		return new EstabelecimentoDAO().findByName(nome);
//	}

//	@RequestMapping(value = "/estabelecimentos", method = RequestMethod.GET)
//	public List<Estabelecimento> listar() {
//		return estabelecimentoDAO.findAll(Estabelecimento.class);
//	}

}