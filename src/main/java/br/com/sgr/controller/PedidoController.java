package br.com.sgr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgr.domain.Pedido;
import br.com.sgr.repository.PedidoRepository;

@RestController
@RequestMapping("/sgr")
@CrossOrigin(origins = "http://localhost:3000")
public class PedidoController implements IController<Pedido>{

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	@RequestMapping(name="teste", value = "/pedidos/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable("id") int id) {
		pedidoRepository.remove(id, Pedido.class);
		return true;
	}

	@Override
	@RequestMapping(value = "/pedidos", method = RequestMethod.GET)
	public List<Pedido> list() {
		return pedidoRepository.list(Pedido.class);
	}

	@Override
	@RequestMapping(value = "/pedidos", method = RequestMethod.POST)
	public boolean save(@RequestBody Pedido pedido) {
		pedidoRepository.save(pedido);
		return true;
	}

	@Override
	@RequestMapping(value = "/pedidos/{id}", method = RequestMethod.GET)
	public Pedido get(@PathVariable("id") int id) {
		return pedidoRepository.get(id, Pedido.class);
	}
	
	@RequestMapping(value = "/pedidos/comandas/{idComanda}", method = RequestMethod.GET)
	public List<Pedido> getPedidosComanda(@PathVariable("idComanda") int idComanda) {
		return pedidoRepository.getPedidosComanda(idComanda);
	}
	
	@Override
	public boolean update(Pedido t) {
		// TODO Auto-generated method stub
		return true;
	}
}
