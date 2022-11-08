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

import br.com.sglps.model.OuvidoriaApp;

//adicionando repositorio
@Repository
public class OuvidoriaAppDAOImpl implements InterfaceOuvidoriaAppDAO {

	// parametros jdbc
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

	}

	/*****************************************************************************/
	private SqlParameterSource getSqlParameterByModel(OuvidoriaApp ouvidoriaapp) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();

		if (ouvidoriaapp != null) {

			paramSource.addValue("idOuvidoriaPac", ouvidoriaapp.getIdOuvidoriaPac());
			paramSource.addValue("cpfPacienteOuvidoriaPac", ouvidoriaapp.getCpfPacienteOuvidoriaPac());
			paramSource.addValue("dataOuvidoriaPac", ouvidoriaapp.getDataOuvidoriaPac());
			paramSource.addValue("tipoOuvidoriaPac", ouvidoriaapp.getTipoOuvidoriaPac());
			paramSource.addValue("descricaoOuvidoriaPac", ouvidoriaapp.getDescricaoOuvidoriaPac());
			paramSource.addValue("statusOuvidoriaPac", ouvidoriaapp.getStatusOuvidoriaPac());

		}

		return paramSource;
	}

	/*****************************************************************************/

	private static final class OuvidoriaAppMapper implements RowMapper<OuvidoriaApp> {
		public OuvidoriaApp mapRow(ResultSet rs, int rowNum) throws SQLException {

			OuvidoriaApp ouvidoriaapp = new OuvidoriaApp();

			ouvidoriaapp.setIdOuvidoriaPac(rs.getInt("idOuvidoriaPac"));
			ouvidoriaapp.setCpfPacienteOuvidoriaPac(rs.getString("cpfPacienteOuvidoriaPac"));
			ouvidoriaapp.setDataOuvidoriaPac(rs.getString("dataOuvidoriaPac"));
			ouvidoriaapp.setTipoOuvidoriaPac(rs.getString("tipoOuvidoriaPac"));
			ouvidoriaapp.setDescricaoOuvidoriaPac(rs.getString("descricaoOuvidoriaPac"));
			ouvidoriaapp.setStatusOuvidoriaPac(rs.getString("statusOuvidoriaPac"));

			return ouvidoriaapp;

		}
	}

	/*****************************************************************************/

	public List<OuvidoriaApp> buscarTodasOuvidoriasApp() {
		String sql = "SELECT idOuvidoriaPac, cpfPacienteOuvidoriaPac, "
				+ "dataOuvidoriaPac, tipoOuvidoriaPac,"
				+ "descricaoOuvidoriaPac,"
				+ "statusOuvidoriaPac FROM JCN_tbsOuvidoriaPaciente";

		List<OuvidoriaApp> list = namedParameterJdbcTemplate.query(sql, 
				getSqlParameterByModel(null),new OuvidoriaAppMapper());

		return list;
	}

	/*****************************************************************************/
	
	
	public void atualizarStatusOuvidoria(OuvidoriaApp ouvidoria){
		String sql = "UPDATE JCN_tbsOuvidoriaPaciente SET "
				+ "statusOuvidoriaPac = 'Já visualizado' "
				+ " WHERE idOuvidoriaPac = :idOuvidoriaPac";		
		
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(ouvidoria));
		
	}
	
	
	/*****************************************************************************/


	public OuvidoriaApp buscaStatusOuvidoriaPorId(Integer idOuvidoriaPac) {
		String sql = "SELECT * FROM JCN_tbsOuvidoriaPaciente WHERE idOuvidoriaPac= :idOuvidoriaPac";

		  return namedParameterJdbcTemplate.queryForObject(sql, 
				  getSqlParameterByModel(new OuvidoriaApp(idOuvidoriaPac)), new OuvidoriaAppMapper());
	}

}
