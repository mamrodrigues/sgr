package br.com.sgr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgr.domain.Estabelecimento;
import br.com.sgr.repository.EstabelecimentoRepository;

@RestController
@RequestMapping("/sgr")
@CrossOrigin(origins = "http://localhost:3000")
public class EstabelecimentoController implements IController<Estabelecimento>{
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;

	@Override
	@RequestMapping(value = "/estabelecimentos/{id}", method = RequestMethod.GET)
	public Estabelecimento get(@PathVariable("id") int id) {
		return estabelecimentoRepository.get(id, Estabelecimento.class);
	}

	@Override
	@RequestMapping(value = "/estabelecimentos", method = RequestMethod.GET)
	public List<Estabelecimento> list() {
		return estabelecimentoRepository.list(Estabelecimento.class);
	}

	@Override
	@RequestMapping(value = "/estabelecimentos", method = RequestMethod.POST)
	public boolean save(@RequestBody Estabelecimento t) {
		estabelecimentoRepository.save(t);
		return true;
	}

	@Override
	@RequestMapping(value = "/estabelecimentos/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable("id") int id) {
		estabelecimentoRepository.remove(id, Estabelecimento.class);
		return true;
	}
	
	@Override
	public boolean update(Estabelecimento t) {
		// TODO Auto-generated method stub
		return true;
	}

}