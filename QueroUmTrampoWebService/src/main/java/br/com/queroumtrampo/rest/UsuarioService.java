package br.com.queroumtrampo.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.queroumtrampo.dao.UsuarioDAO;
import br.com.queroumtrampo.model.Usuario;

@Path("/usuario")
public class UsuarioService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> listarUsuarios() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		List<Usuario> listaUsuarios = usuarioDAO.findAll();

		return listaUsuarios;
	}
}
