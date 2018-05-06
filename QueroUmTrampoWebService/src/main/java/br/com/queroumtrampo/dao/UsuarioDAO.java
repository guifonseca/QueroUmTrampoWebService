package br.com.queroumtrampo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.queroumtrampo.model.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario> {

	private static final long serialVersionUID = 354828901321782952L;

	public UsuarioDAO() {
		super(Usuario.class);
	}

	public void insert( Usuario usuario )
	{
		beginTransaction( );
		super.save( usuario );
		commitAndCloseTransaction( );
	}
	
	public Usuario find( int entityID )
	{
		beginTransaction( );
		Usuario usuario = super.find( entityID );
		closeTransaction( );
		
		return usuario;
	}
	
	public Usuario update( Usuario usuario )
	{
		beginTransaction( );
		Usuario usuarioNew = super.update( usuario );
		commitAndCloseTransaction( );
		
		return usuarioNew;
	}
	
	public Usuario findUserByName( String email )
	{
		Map<String, Object> parametros = new HashMap<String, Object>( );
		parametros.put( "email", email );
		
		beginTransaction( );
		Usuario usuario = super.findOneResult( "usuario.buscaPorEmail", parametros );
		closeTransaction( );
		
		return usuario;
	}
	
	public void delete( Usuario usuario )
	{
		beginTransaction( );
		super.delete( usuario.getId( ), Usuario.class );
		commitAndCloseTransaction( );
	}
	
	public List<Usuario> findAll( )
	{
		beginTransaction( );
		List<Usuario> usuarios = super.findAll( );
	    closeTransaction( );
	    
	    return usuarios;
	}
}
