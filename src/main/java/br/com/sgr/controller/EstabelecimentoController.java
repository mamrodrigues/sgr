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
	public boolean save(Estabelecimento t) {
		estabelecimentoRepository.save(t);
		return true;
	}
	
	@RequestMapping(value = "/estabelecimentos", method = RequestMethod.POST)
	public Estabelecimento saveAndGet(@RequestBody Estabelecimento estabelecimento) {
		if(estabelecimento.getEstabelecimentoId() == 0) {
			estabelecimentoRepository.save(estabelecimento);
			return estabelecimento;
		} else {
			Estabelecimento e = estabelecimentoRepository.get(estabelecimento.getEstabelecimentoId(), Estabelecimento.class);
			e.setEndereco(estabelecimento.getEndereco());
			e.setCep(estabelecimento.getCep());
			e.setNumero(estabelecimento.getNumero());
			e.setEstado(estabelecimento.getEstado());
			e.setCidade(estabelecimento.getCidade());
			e.setNome(estabelecimento.getNome());
			e.setCnpj(estabelecimento.getCnpj());
			estabelecimentoRepository.save(e);
			return e;
		}
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