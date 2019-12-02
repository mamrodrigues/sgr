package br.com.sgr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgr.domain.Comanda;
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
	@RequestMapping(value = "/comandas", method = RequestMethod.POST)
	public boolean save(@RequestBody Comanda comanda) {
		comandaRepository.save(comanda);
		return true;
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