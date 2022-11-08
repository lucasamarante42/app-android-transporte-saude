package br.com.sglps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import br.com.sglps.model.Rota;

//adicionando repositorio
@Repository
public class RotaDAOImpl implements InterfaceRotaDAO {

	// parametros jdbc
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

	}

	/*****************************************************************************/
	private SqlParameterSource getSqlParameterByModel(Rota rota) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();

		if (rota != null) {

			paramSource.addValue("idRota", rota.getIdRota());
			paramSource.addValue("destinoRota", rota.getDestinoRota());
			paramSource.addValue("distanciaRota", rota.getDistanciaRota());
			paramSource.addValue("tempoEstimadoRota", rota.getTempoEstimadoRota());

		}

		return paramSource;
	}

	/*****************************************************************************/

	private static final class RotaMapper implements RowMapper<Rota> {
		public Rota mapRow(ResultSet rs, int rowNum) throws SQLException {

			Rota rota = new Rota();

			rota.setIdRota(rs.getInt("idRota"));
			rota.setDestinoRota(rs.getString("destinoRota"));
			rota.setDistanciaRota(rs.getString("distanciaRota"));
			rota.setTempoEstimadoRota(rs.getString("tempoEstimadoRota"));

			return rota;

		}
	}

	/*****************************************************************************/

	public void inserirRota(Rota rota) {
		String sql = "INSERT INTO JCN_tbsRota(destinoRota,distanciaRota,"
	 			+ "tempoEstimadoRota) values "
		 		+ "(:destinoRota, :distanciaRota, "
		 		+ ":tempoEstimadoRota)";
		
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(rota));

	}

	/*****************************************************************************/
	
	public void atualizarRota(Rota rota) {
		String sql = "UPDATE JCN_tbsRota SET "
	 		    + "destinoRota = :destinoRota, "
	 		    + "distanciaRota = :distanciaRota, "
		  		+ "tempoEstimadoRota = :tempoEstimadoRota "
		  		+ " WHERE idRota = :idRota";

		  namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(rota));

	}

	/*****************************************************************************/
	
	public List<Rota> buscarTodasRotas() {
		String sql = "SELECT idRota, destinoRota, distanciaRota, "
				+ "tempoEstimadoRota "
				+ "FROM JCN_tbsRota";
	 
		List<Rota> list = namedParameterJdbcTemplate.query(sql,getSqlParameterByModel(null),
				new RotaMapper());
		
		return list;
	}
	
	/*****************************************************************************/


	public Rota buscarRotaPorId(Integer idRota) {
		String sql = "SELECT * FROM JCN_tbsRota WHERE idRota= :idRota";

		  return namedParameterJdbcTemplate.queryForObject(sql, 
				  getSqlParameterByModel(new Rota(idRota)), new RotaMapper());
		
	}

}
