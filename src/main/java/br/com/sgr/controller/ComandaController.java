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

import br.com.sgr.domain.Comanda;
import br.com.sgr.domain.Funcionario;
import br.com.sgr.repository.ComandaRepository;

@RestController
@RequestMapping("/sgr")
@CrossOrigin(origins = "http://localhost:3000")
public class ComandaController implements IController<Comanda>{
	
	@Autowired
	private ComandaRepository comandaRepository;
	
	@Override
	@RequestMapping(name="teste", value = "/comandas/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable("id") int id) {
		comandaRepository.remove(id, Comanda.class);
		return true;
	}

	@Override
	@RequestMapping(value = "/comandas", method = RequestMethod.GET)
	public List<Comanda> list() {
		return comandaRepository.list(Comanda.class);
	}

	@Override
	public boolean save(@RequestBody Comanda comanda) {
		comandaRepository.save(comanda);
		return true;
	}
	
	@RequestMapping(value = "/comandas", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Comanda saveAndGet(@RequestBody Comanda comanda) {
		if(comanda.getComandaId() == 0) {
			comandaRepository.save(comanda);
			return comanda;
		} else {
			Comanda c = comandaRepository.get(comanda.getComandaId(), Comanda.class);
			c.setNome(comanda.getNome());
			c.setFechada(comanda.isFechada());
			comandaRepository.save(c);
			return c;
		}
	}

	@Override
	@RequestMapping(value = "/comandas/{id}", method = RequestMethod.GET)
	public Comanda get(@PathVariable("id") int id) {
		return comandaRepository.get(id, Comanda.class);
	}
	
	@Override
	public boolean update(Comanda t) {
		// TODO Auto-generated method stub
		return true;
	}

}
