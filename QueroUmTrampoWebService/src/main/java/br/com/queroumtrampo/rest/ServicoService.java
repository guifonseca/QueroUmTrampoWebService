package br.com.queroumtrampo.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.queroumtrampo.dao.ServicoDAO;
import br.com.queroumtrampo.model.Servico;
import br.com.queroumtrampo.model.Servicos;

@Path("/servicos")
public class ServicoService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Servicos listarServicos() {
		ServicoDAO servicoDAO = new ServicoDAO();

		List<Servico> listaServicos = servicoDAO.findAll();

		Servicos servicos = new Servicos();
		
		servicos.setServicos(listaServicos);

		return servicos;
	}
}
