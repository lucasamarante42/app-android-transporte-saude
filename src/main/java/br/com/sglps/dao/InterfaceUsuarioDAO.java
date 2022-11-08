package br.com.sglps.dao;

import java.util.List;

import br.com.sglps.model.Usuario;

public interface InterfaceUsuarioDAO {
	
	public void inserirUsuario(Usuario usuario);	
	public void atualizarUsuario(Usuario usuario);
	
	public List<Usuario> buscarTodosUsuarios();
	public Usuario buscarUsuarioPorID(Integer idUsuario);
	
	//public void excluirUsuario(int idUsuario);

}
