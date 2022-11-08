package br.com.sglps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.sglps.model.Usuario;


//adicionando repositorio
@Repository
public class UsuarioDAOImpl implements InterfaceUsuarioDAO{

    //parametros jdbc
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;


	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

	}
	
	/*****************************************************************************/	
	private SqlParameterSource getSqlParameterByModel(Usuario usuario){
		  MapSqlParameterSource paramSource = new MapSqlParameterSource();

		  if(usuario != null){
			  	
			    paramSource.addValue("idUsuario", usuario.getIdUsuario());
			    paramSource.addValue("nomeUsuario", usuario.getNomeUsuario());
			    paramSource.addValue("cpfUsuario", usuario.getCpfUsuario());
			    paramSource.addValue("cargoUsuario", usuario.getCargoUsuario());
			    paramSource.addValue("celularUsuario", usuario.getCelularUsuario());
			    paramSource.addValue("emailUsuario", usuario.getEmailUsuario());

			  }	  
		  
		  return paramSource;
		}	
			
	/*****************************************************************************/	

	private static final class UsuarioMapper implements RowMapper<Usuario>{
		   public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {

		       Usuario usuario = new Usuario();
		       usuario.setIdUsuario(rs.getInt("idUsuario"));
		   	   usuario.setNomeUsuario(rs.getString("nomeUsuario"));
		   	   usuario.setCpfUsuario(rs.getString("cpfUsuario"));
		   	   usuario.setCargoUsuario(rs.getString("cargoUsuario"));
		   	   usuario.setCelularUsuario(rs.getString("celularUsuario"));
		   	   usuario.setEmailUsuario(rs.getString("emailUsuario"));
		      		       
		       return usuario;
		     
		 }
		}
		
	
	/*****************************************************************************/	


	public void inserirUsuario(Usuario usuario) {
		 String sql = "INSERT INTO JCN_tbsUsuario(nomeUsuario,cpfUsuario,cargoUsuario,"
		 			+ "celularUsuario,emailUsuario) values "
			 		+ "(:nomeUsuario, :cpfUsuario, :cargoUsuario, :celularUsuario, :emailUsuario)";
			
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(usuario));
		
	}
	
	/*****************************************************************************/	
	/*
	public void excluirUsuario(int id) {
		 String sql = "DELETE FROM JCN_tbsUsuario WHERE id = :id";
		  
		 namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Usuario(id)));
		
	}*/

	/*****************************************************************************/	
	
	public void atualizarUsuario(Usuario usuario) {
		 String sql = "UPDATE JCN_tbsUsuario SET "
		 		    + "nomeUsuario = :nomeUsuario, "
		 		    + "cpfUsuario = :cpfUsuario, "
			  		+ "cargoUsuario = :cargoUsuario, "
			  		+ "celularUsuario = :celularUsuario, "
			  		+ "emailUsuario = :emailUsuario "
			  		+ " WHERE idUsuario = :idUsuario";

			  namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(usuario));	
		
	}
	
	/*****************************************************************************/	

	public List<Usuario> buscarTodosUsuarios() {
		 String sql = "SELECT idUsuario, nomeUsuario, cpfUsuario, cargoUsuario, celularUsuario,"
		 		    + "emailUsuario FROM JCN_tbsUsuario";
		 
			List<Usuario> list = namedParameterJdbcTemplate.query(sql,getSqlParameterByModel(null), new UsuarioMapper());
			
			return list;	
	}

	/*****************************************************************************/	
	
	public Usuario buscarUsuarioPorID(Integer idUsuario) {
		 String sql = "SELECT * FROM JCN_tbsUsuario WHERE idUsuario= :idUsuario";

		  return namedParameterJdbcTemplate.queryForObject(sql, 
				  getSqlParameterByModel(new Usuario(idUsuario)), new UsuarioMapper());
	}
	
	
	
	
	
	
	
	
}
