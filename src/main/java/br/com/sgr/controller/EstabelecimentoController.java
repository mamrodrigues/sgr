package br.com.sgr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgr.domain.Estabelecimento;
import br.com.sgr.repository.EstabelecimentoRepository;

//@CrossOrigin(origins = "https://sgr.herokuapp.com", maxAge = 3600)
@RestController
@RequestMapping("/sgr")
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;

	@RequestMapping(value = "/estabelecimentos", method = RequestMethod.POST)
	public void salvar(@RequestBody Estabelecimento estabelecimento) {
		estabelecimentoRepository.save(estabelecimento);
	}
	
	@RequestMapping(value = "/estabelecimentos", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		estabelecimentoRepository.remove(id, Estabelecimento.class);
	}

	@RequestMapping(value = "/estabelecimentos/{id}", method = RequestMethod.GET)
	public Estabelecimento recuperar(@PathVariable("id") Long id) {
		return estabelecimentoRepository.get(id, Estabelecimento.class);
	}

	@RequestMapping(value = "/estabelecimentos", method = RequestMethod.GET)
	public List<Estabelecimento> listar() {
		return estabelecimentoRepository.list(Estabelecimento.class);
	}

}