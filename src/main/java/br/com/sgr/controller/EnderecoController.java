package br.com.sgr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgr.domain.Endereco;
import br.com.sgr.repository.EnderecoRepository;

@RestController
@RequestMapping("/sgr")
@CrossOrigin(origins = "http://localhost:3000")
public class EnderecoController implements IController<Endereco>{
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public boolean save(Endereco endereco) {
		enderecoRepository.save(endereco);
		return true;
	}
	
	@RequestMapping(value = "/enderecos", method = RequestMethod.POST)
	public Endereco saveAndGet(@RequestBody Endereco endereco) {
		enderecoRepository.save(endereco);
		return endereco;
	}
	
	@Override
	@RequestMapping(value = "/enderecos/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable("id") int id) {
		enderecoRepository.remove(id, Endereco.class);
		return true;
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
	public boolean update(Endereco t) {
		// TODO Auto-generated method stub
		return true;
	}

}
