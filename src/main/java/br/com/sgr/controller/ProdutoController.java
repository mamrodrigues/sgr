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

import br.com.sgr.domain.Cardapio;
import br.com.sgr.domain.Produto;
import br.com.sgr.repository.ProdutoRepository;

@RestController
@RequestMapping("/sgr")
@CrossOrigin(origins = "http://localhost:3000")
public class ProdutoController  implements IController<Produto>{
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public List<Produto> list() {
		return produtoRepository.list(Produto.class);
	}
	
	@RequestMapping(value = "/cardapios/{idCardapio}/produtos", method = RequestMethod.GET)
	public List<Produto> listarProdutosPorCardapio(@PathVariable("idCardapio") int idCardapio) {
		return produtoRepository.listaProdutosPorCardapio(idCardapio);
	}
	
	@RequestMapping(value = "/comandas/{idComanda}/produtos", method = RequestMethod.GET)
	public List<Produto> listarProdutosPorComanda(@PathVariable("idComanda") int idComanda) {
		return produtoRepository.listaProdutosPorComanda(idComanda);
	}

	@Override
	//@RequestMapping(value = "/produtos", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean save(@RequestBody Produto t) {
		produtoRepository.save(t);
		return true;
	}
	
	@RequestMapping(value = "/produtos", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Produto saveAndGet(@RequestBody Produto produto) {
		if(produto.getProdutoId() == 0) {
			produtoRepository.save(produto);
			return produto;
		} else {
			Produto p = produtoRepository.get(produto.getProdutoId(), Produto.class);
			p.setNome(produto.getNome());
			p.setDescricao(produto.getDescricao());
			p.setValor(produto.getValor());
			produtoRepository.save(p);
			return p;
		}
	}

	@Override
	@RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable("id") int id) {
		produtoRepository.remove(id, Produto.class);
		return true;
	}

	@Override
	@RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
	public Produto get(@PathVariable("id") int id) {
		return produtoRepository.get(id, Produto.class);
	}

	@Override
	public boolean update(Produto t) {
		// TODO Auto-generated method stub
		return true;
	}
}
