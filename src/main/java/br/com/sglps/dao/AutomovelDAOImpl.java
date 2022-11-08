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


import br.com.sglps.model.Automovel;




//adicionando repositorio
@Repository
public class AutomovelDAOImpl implements InterfaceAutomovelDAO {

	// parametros jdbc
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

	}

	/*****************************************************************************/
	private SqlParameterSource getSqlParameterByModel(Automovel automovel) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();

		if (automovel != null) {

			paramSource.addValue("idAutomovel", automovel.getIdAutomovel());
			paramSource.addValue("nomeAutomovel", automovel.getNomeAutomovel());
			paramSource.addValue("marcaAutomovel", automovel.getMarcaAutomovel());
			paramSource.addValue("capacidadePassageirosAutomovel", automovel.getCapacidadePassageirosAutomovel());
			paramSource.addValue("anoAutomovel", automovel.getAnoAutomovel());
			paramSource.addValue("pertencenteAutomovel", automovel.getPertencenteAutomovel());
			paramSource.addValue("statusAutomovel", automovel.getStatusAutomovel());
			paramSource.addValue("motivoAutomovel", automovel.getMotivoAutomovel());

		}

		return paramSource;
	}

	/*****************************************************************************/

	private static final class AutomovelMapper implements RowMapper<Automovel> {
		public Automovel mapRow(ResultSet rs, int rowNum) throws SQLException {

			Automovel automovel = new Automovel();

			automovel.setIdAutomovel(rs.getInt("idAutomovel"));
			automovel.setNomeAutomovel(rs.getString("nomeAutomovel"));
			automovel.setMarcaAutomovel(rs.getString("marcaAutomovel"));
			automovel.setCapacidadePassageirosAutomovel(rs.getInt("capacidadePassageirosAutomovel"));
			automovel.setAnoAutomovel(rs.getInt("anoAutomovel"));
			automovel.setPertencenteAutomovel(rs.getString("pertencenteAutomovel"));
			automovel.setStatusAutomovel(rs.getString("statusAutomovel"));
			automovel.setMotivoAutomovel(rs.getString("motivoAutomovel"));

			return automovel;

		}
	}

	/*****************************************************************************/
	public void inserirAutomovel(Automovel automovel) {
		String sql = "INSERT INTO JCN_tbsAutomovel(nomeAutomovel,marcaAutomovel,capacidadePassageirosAutomovel,"
	 			+ "anoAutomovel,pertencenteAutomovel,statusAutomovel,motivoAutomovel) values "
		 		+ "(:nomeAutomovel, :marcaAutomovel, :capacidadePassageirosAutomovel, "
		 		+ ":anoAutomovel, :pertencenteAutomovel, :statusAutomovel, :motivoAutomovel)";
		
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(automovel));

	}

	/*****************************************************************************/
	public void atualizarAutomovel(Automovel automovel) {
		String sql = "UPDATE JCN_tbsAutomovel SET "
	 		    + "nomeAutomovel = :nomeAutomovel, "
	 		    + "marcaAutomovel = :marcaAutomovel, "
		  		+ "capacidadePassageirosAutomovel = :capacidadePassageirosAutomovel, "
		  		+ "anoAutomovel = :anoAutomovel, "
		  		+ "pertencenteAutomovel = :pertencenteAutomovel, "
		  		+ "statusAutomovel = :statusAutomovel,"
		  		+ "motivoAutomovel = :motivoAutomovel"
		  		+ " WHERE idAutomovel = :idAutomovel";

		  namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(automovel));	

	}
	
	/*****************************************************************************/
	public List<Automovel> buscarTodosAutomoveis() {
		String sql = "SELECT idAutomovel, nomeAutomovel, marcaAutomovel, "
				+ "capacidadePassageirosAutomovel, anoAutomovel,"
				+ "pertencenteAutomovel,statusAutomovel,"
	 		    + "motivoAutomovel FROM JCN_tbsAutomovel ORDER BY nomeAutomovel ASC";
	 
		List<Automovel> list = namedParameterJdbcTemplate.query(sql,getSqlParameterByModel(null),new AutomovelMapper());
		
		return list;
	}

	
	/*****************************************************************************/
	public Automovel buscarAutomovelPorId(Integer idAutomovel) {
		String sql = "SELECT * FROM JCN_tbsAutomovel WHERE idAutomovel= :idAutomovel";

		  return namedParameterJdbcTemplate.queryForObject(sql, 
				  getSqlParameterByModel(new Automovel(idAutomovel)), new AutomovelMapper());
	}

	/*****************************************************************************/

	public List<Automovel> disponivelBuscarTodosAutomoveis() {
		String sql = "SELECT idAutomovel, nomeAutomovel, marcaAutomovel, "
				+ "capacidadePassageirosAutomovel, anoAutomovel,"
				+ "pertencenteAutomovel,statusAutomovel,"
	 		    + "motivoAutomovel FROM JCN_tbsAutomovel"
	 		    + " WHERE statusAutomovel = 'Disponível'";
	 
		List<Automovel> lista = namedParameterJdbcTemplate.query(sql,getSqlParameterByModel(null),new AutomovelMapper());
		
		return lista;
	}

}
