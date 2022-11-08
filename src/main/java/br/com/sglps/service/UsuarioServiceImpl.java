package br.com.sglps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sglps.dao.InterfaceUsuarioDAO;
import br.com.sglps.model.Usuario;



@Service
public class UsuarioServiceImpl implements InterfaceUsuarioService {
	
	//referencia InterfaceUsuarioDAO
	InterfaceUsuarioDAO usuarioDAO;
	
	/*******************************************************************************/
	
	//getters and setters (apenas o setUsuarioDAO)
	@Autowired
    public void setUsuarioDAO(InterfaceUsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	/*******************************************************************************/

	
	public void inserirUsuario(Usuario usuario) {
		usuarioDAO.inserirUsuario(usuario);
		
	}
	
	/*******************************************************************************/

	//public void excluirUsuario(int id) {
	//	usuarioDAO.excluirUsuario(id);
	//}
	
	/*******************************************************************************/

	public void atualizarUsuario(Usuario usuario) {
		usuarioDAO.atualizarUsuario(usuario);
		
	}
	
	/*******************************************************************************/

	public List<Usuario> buscarTodosUsuarios() {
		return usuarioDAO.buscarTodosUsuarios();
	}
	
	/*******************************************************************************/

	public Usuario buscarUsuarioPorID(Integer idUsuario) {
		return usuarioDAO.buscarUsuarioPorID(idUsuario); 
	}
    
    
    /*******************************************************************************/
	
	
	

}
