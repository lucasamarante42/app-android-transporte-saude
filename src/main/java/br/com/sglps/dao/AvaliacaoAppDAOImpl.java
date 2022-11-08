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

import br.com.sglps.model.AvaliacaoApp;

//adicionando repositorio
@Repository
public class AvaliacaoAppDAOImpl implements InterfaceAvaliacaoAppDAO {

	// parametros jdbc
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

	}

	/*****************************************************************************/
	private SqlParameterSource getSqlParameterByModel(AvaliacaoApp avaliacaoapp) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();

		if (avaliacaoapp != null) {

			paramSource.addValue("idAvaliacaoPac", avaliacaoapp.getIdAvaliacaoPac());
			paramSource.addValue("cpfPacienteAvaliacaoPac", avaliacaoapp.getCpfPacienteAvaliacaoPac());
			paramSource.addValue("dataAvaliacaoPac", avaliacaoapp.getDataAvaliacaoPac());
			paramSource.addValue("avaliacaoAvaliacaoPac", avaliacaoapp.getAvaliacaoAvaliacaoPac());
			paramSource.addValue("mensagemAvaliacaoPac", avaliacaoapp.getMensagemAvaliacaoPac());
			paramSource.addValue("statusAvaliacaoPac", avaliacaoapp.getStatusAvaliacaoPac());

		}

		return paramSource;
	}

	/*****************************************************************************/

	private static final class AvaliacaoAppMapper implements RowMapper<AvaliacaoApp> {
		public AvaliacaoApp mapRow(ResultSet rs, int rowNum) throws SQLException {

			AvaliacaoApp avaliacaoapp = new AvaliacaoApp();

			avaliacaoapp.setIdAvaliacaoPac(rs.getInt("idAvaliacaoPac"));
			avaliacaoapp.setCpfPacienteAvaliacaoPac(rs.getString("cpfPacienteAvaliacaoPac"));
			avaliacaoapp.setDataAvaliacaoPac(rs.getString("dataAvaliacaoPac"));
			avaliacaoapp.setAvaliacaoAvaliacaoPac(rs.getString("avaliacaoAvaliacaoPac"));
			avaliacaoapp.setMensagemAvaliacaoPac(rs.getString("mensagemAvaliacaoPac"));
			avaliacaoapp.setStatusAvaliacaoPac(rs.getString("statusAvaliacaoPac"));

			return avaliacaoapp;

		}
	}

	/*****************************************************************************/

	public List<AvaliacaoApp> buscarTodasAvaliacoesApp() {
		String sql = "SELECT idAvaliacaoPac, cpfPacienteAvaliacaoPac, "
				+ "dataAvaliacaoPac, avaliacaoAvaliacaoPac,"
				+ "mensagemAvaliacaoPac,"
				+ "statusAvaliacaoPac FROM JCN_tbsAvaliacaoPaciente";

		List<AvaliacaoApp> list = namedParameterJdbcTemplate.query(sql, 
				getSqlParameterByModel(null),new AvaliacaoAppMapper());

		return list;
	}

	/*****************************************************************************/

	public void atualizarStatusAvaliacao(AvaliacaoApp avaliacao) {
		String sql = "UPDATE JCN_tbsAvaliacaoPaciente SET "
					+ "statusAvaliacaoPac = 'Já visualizado' "
					+ " WHERE idAvaliacaoPac = :idAvaliacaoPac";		
		
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(avaliacao));
		
	}

	/*****************************************************************************/
	
	public AvaliacaoApp buscaStatusAvaliacaoPorId(Integer idAvaliacaoPac) {
		String sql = "SELECT * FROM JCN_tbsAvaliacaoPaciente WHERE idAvaliacaoPac= :idAvaliacaoPac";

		  return namedParameterJdbcTemplate.queryForObject(sql, 
				  getSqlParameterByModel(new AvaliacaoApp(idAvaliacaoPac)), new AvaliacaoAppMapper());
	}

}
