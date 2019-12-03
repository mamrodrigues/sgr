package br.com.sgr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgr.domain.Estabelecimento;
import br.com.sgr.domain.Funcionario;
import br.com.sgr.repository.FuncionarioRepository;

@RestController
@RequestMapping("/sgr")
@CrossOrigin(origins = "http://localhost:3000")
public class FuncionarioController implements IController<Funcionario>{
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	@RequestMapping(value = "/funcionarios", method = RequestMethod.GET)
	public List<Funcionario> list() {
		return funcionarioRepository.list(Funcionario.class);
	}

	@Override
	public boolean save(@RequestBody Funcionario t) {
		funcionarioRepository.save(t);
		return true;
	}
	
	@RequestMapping(value = "/funcionarios", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Funcionario saveAndGet(@RequestBody Funcionario funcionario) {
		if(funcionario.getId() == 0) {
			funcionarioRepository.save(funcionario);
			return funcionario;
		} else {
			Funcionario f = funcionarioRepository.get(funcionario.getId(), Funcionario.class);
			f.setNome(funcionario.getNome());
			f.setCpf(funcionario.getCpf());
			f.setDataNascimento(funcionario.getDataNascimento());
			funcionarioRepository.save(f);
			return f;
		}
	}

	@Override
	@RequestMapping(value = "/funcionarios/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable("id") int id) {
		funcionarioRepository.remove(id, Funcionario.class);
		return true;
	}

	@Override
	@RequestMapping(value = "/funcionarios/{id}", method = RequestMethod.GET)
	public Funcionario get(@PathVariable("id") int id) {
		return funcionarioRepository.get(id, Funcionario.class);
	}
	
	@Override
	public boolean update(Funcionario t) {
		// TODO Auto-generated method stub
		return true;
	}

}
