package br.com.sgr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgr.domain.Endereco;
import br.com.sgr.repository.EnderecoRepository;

@RestController
@RequestMapping("/sgr")
public class EnderecoController implements IController<Endereco>{
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	@RequestMapping(value = "/enderecos", method = RequestMethod.POST)
	public void save(@RequestBody Endereco endereco) {
		enderecoRepository.save(endereco);
	}
	
	@Override
	@RequestMapping(value = "/enderecos/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		enderecoRepository.remove(id, Endereco.class);
	}

	@Override
	@RequestMapping(value = "/enderecos", method = RequestMethod.GET)
	public List<Endereco> list() {
		return enderecoRepository.list(Endereco.class);
	}

	@Override
	@RequestMapping(value = "/enderecos/{id}", method = RequestMethod.GET)
	public Endereco get(@PathVariable("id") int id) {
		return enderecoRepository.get(id, Endereco.class);
	}
	
	@Override
	public void update(Endereco t) {
		// TODO Auto-generated method stub
	}

}
