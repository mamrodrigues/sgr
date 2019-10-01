package br.com.sgr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgr.domain.Cardapio;
import br.com.sgr.repository.CardapioRepository;

@RestController
@RequestMapping("/sgr")
public class CardapioController implements IController<Cardapio>{
	
	@Autowired
	private CardapioRepository cardapioRepository;

	@RequestMapping(value = "/cardapios", method = RequestMethod.POST)
	public void salvar(@RequestBody Cardapio cardapio) {
		cardapioRepository.save(cardapio);
	}
	
	@Override
	@RequestMapping(value = "/cardapios/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		cardapioRepository.remove(id, Cardapio.class);
	}
	
	@Override
	@RequestMapping(value = "/cardapios", method = RequestMethod.GET)
	public List<Cardapio> list() {
		return cardapioRepository.list(Cardapio.class);
	}

	@Override
	@RequestMapping(value = "/cardapios", method = RequestMethod.POST)
	public void save(@RequestBody Cardapio t) {
		cardapioRepository.save(t);
	}

	@Override
	@RequestMapping(value = "/cardapios/{id}", method = RequestMethod.GET)
	public Cardapio get(@PathVariable("id") Long id) {
		return cardapioRepository.get(id, Cardapio.class);
	}
	
	@Override
	public void update(Cardapio t) {
		// TODO Auto-generated method stub
	}

}
