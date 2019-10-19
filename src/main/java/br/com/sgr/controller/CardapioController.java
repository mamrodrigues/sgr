package br.com.sgr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgr.domain.Cardapio;
import br.com.sgr.repository.CardapioRepository;

@RestController
@RequestMapping("/sgr")
@CrossOrigin(origins = "http://localhost:3000")
public class CardapioController implements IController<Cardapio>{
	
	@Autowired
	private CardapioRepository cardapioRepository;
	
	@Override
	@RequestMapping(value = "/cardapios/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable("id") int id) {
		cardapioRepository.remove(id, Cardapio.class);
		return true;
	}
	
	@Override
	@RequestMapping(value = "/cardapios", method = RequestMethod.GET)
	public List<Cardapio> list() {
		return cardapioRepository.list(Cardapio.class);
	}

	@Override
	@RequestMapping(value = "/cardapios", method = RequestMethod.POST)
	public boolean save(@RequestBody Cardapio t) {
		cardapioRepository.save(t);
		return true;
	}

	@Override
	@RequestMapping(value = "/cardapios/{id}", method = RequestMethod.GET)
	public Cardapio get(@PathVariable("id") int id) {
		return cardapioRepository.get(id, Cardapio.class);
	}
	
	@Override
	public boolean update(Cardapio t) {
		// TODO Auto-generated method stub
		return true;
	}

}
