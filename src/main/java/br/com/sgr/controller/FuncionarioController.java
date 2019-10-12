package br.com.sgr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgr.domain.Funcionario;
import br.com.sgr.repository.FuncionarioRepository;

@RestController
@RequestMapping("/sgr")
public class FuncionarioController implements IController<Funcionario>{
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	@RequestMapping(value = "/funcionarios", method = RequestMethod.GET)
	public List<Funcionario> list() {
		return funcionarioRepository.list(Funcionario.class);
	}

	@Override
	@RequestMapping(value = "/funcionarios", method = RequestMethod.POST)
	public void save(@RequestBody Funcionario t) {
		funcionarioRepository.save(t);
	}

	@Override
	@RequestMapping(value = "/funcionarios/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		funcionarioRepository.remove(id, Funcionario.class);
	}

	@Override
	@RequestMapping(value = "/funcionarios/{id}", method = RequestMethod.GET)
	public Funcionario get(@PathVariable("id") int id) {
		return funcionarioRepository.get(id, Funcionario.class);
	}
	
	@Override
	public void update(Funcionario t) {
		// TODO Auto-generated method stub
	}

}
