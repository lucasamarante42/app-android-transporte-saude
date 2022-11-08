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

import br.com.sglps.model.Destino;

//adicionando repositorio
@Repository
public class DestinoDAOImpl implements InterfaceDestinoDAO {

	// parametros jdbc
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

	}

	/*****************************************************************************/
	private SqlParameterSource getSqlParameterByModel(Destino destino) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();

		if (destino != null) {

			paramSource.addValue("idDestino", destino.getIdDestino());
			paramSource.addValue("nomeLocalDestino", destino.getNomeLocalDestino());
			paramSource.addValue("enderecoDestino", destino.getEnderecoDestino());
			paramSource.addValue("cidadeDestino", destino.getCidadeDestino());
			paramSource.addValue("telefoneDestino", destino.getTelefoneDestino());

		}

		return paramSource;
	}

	/*****************************************************************************/

	private static final class DestinoMapper implements RowMapper<Destino> {
		public Destino mapRow(ResultSet rs, int rowNum) throws SQLException {

			Destino destino = new Destino();

			destino.setIdDestino(rs.getInt("idDestino"));
			destino.setNomeLocalDestino(rs.getString("nomeLocalDestino"));
			destino.setEnderecoDestino(rs.getString("enderecoDestino"));
			destino.setCidadeDestino(rs.getString("cidadeDestino"));
			destino.setTelefoneDestino(rs.getString("telefoneDestino"));

			return destino;

		}
	}

	/*****************************************************************************/

	public void inserirDestino(Destino destino) {
		String sql = "INSERT INTO JCN_tbsDestino(nomeLocalDestino,enderecoDestino,"
	 			+ "cidadeDestino,telefoneDestino) values "
		 		+ "(:nomeLocalDestino, :enderecoDestino, :cidadeDestino, "
		 		+ ":telefoneDestino)";
		
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(destino));

	}
	
	/*****************************************************************************/

	public void atualizarDestino(Destino destino) {
		String sql = "UPDATE JCN_tbsDestino SET "
	 		    + "nomeLocalDestino = :nomeLocalDestino, "
	 		    + "enderecoDestino = :enderecoDestino, "
		  		+ "cidadeDestino = :cidadeDestino, "
		  		+ "telefoneDestino = :telefoneDestino "
		  		+ " WHERE idDestino = :idDestino";

		  namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(destino));

	}
	
	/*****************************************************************************/

	public List<Destino> buscarTodosDestinos() {
		String sql = "SELECT idDestino, nomeLocalDestino, enderecoDestino, "
				+ "cidadeDestino, telefoneDestino "
				+ "FROM JCN_tbsDestino";
	 
		List<Destino> list = namedParameterJdbcTemplate.query(sql,getSqlParameterByModel(null),
				new DestinoMapper());
		
		return list;
	}
	
	/*****************************************************************************/

	public Destino buscarDestinoPorId(Integer idDestino) {
		String sql = "SELECT * FROM JCN_tbsDestino WHERE idDestino= :idDestino";

		  return namedParameterJdbcTemplate.queryForObject(sql, 
				  getSqlParameterByModel(new Destino(idDestino)), new DestinoMapper());
	}

}
