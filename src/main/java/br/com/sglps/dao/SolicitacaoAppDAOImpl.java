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

import br.com.sglps.model.SolicitacaoApp;

//adicionando repositorio
@Repository
public class SolicitacaoAppDAOImpl implements InterfaceSolicitacaoAppDAO {

	// parametros jdbc
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

	}

	/*****************************************************************************/
	private SqlParameterSource getSqlParameterByModel(SolicitacaoApp solicitacaoapp) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();

		if (solicitacaoapp != null) {

			paramSource.addValue("idSolicitacaoPacApp", solicitacaoapp.getIdSolicitacaoPacApp());
			paramSource.addValue("cpfPacienteSolicitacaoPacApp", solicitacaoapp.getCpfPacienteSolicitacaoPacApp());
			paramSource.addValue("dataSolicitacaoPacApp", solicitacaoapp.getDataSolicitacaoPacApp());
			paramSource.addValue("horaSolicitacaoPacApp", solicitacaoapp.getHoraSolicitacaoPacApp());
			paramSource.addValue("necessidadeAcompanhanteSolicitacaoPacApp",
					solicitacaoapp.getNecessidadeAcompanhanteSolicitacaoPacApp());
			paramSource.addValue("statusSolicitacaoPacApp", solicitacaoapp.getStatusSolicitacaoPacApp());

		}

		return paramSource;
	}

	/*****************************************************************************/

	private static final class SolicitacaoAppMapper implements RowMapper<SolicitacaoApp> {
		public SolicitacaoApp mapRow(ResultSet rs, int rowNum) throws SQLException {

			SolicitacaoApp solicitacaoapp = new SolicitacaoApp();

			solicitacaoapp.setIdSolicitacaoPacApp(rs.getInt("idSolicitacaoPacApp"));
			solicitacaoapp.setCpfPacienteSolicitacaoPacApp(rs.getString("cpfPacienteSolicitacaoPacApp"));
			solicitacaoapp.setDataSolicitacaoPacApp(rs.getString("dataSolicitacaoPacApp"));
			solicitacaoapp.setHoraSolicitacaoPacApp(rs.getString("horaSolicitacaoPacApp"));
			solicitacaoapp.setNecessidadeAcompanhanteSolicitacaoPacApp(
					rs.getString("necessidadeAcompanhanteSolicitacaoPacApp"));
			solicitacaoapp.setStatusSolicitacaoPacApp(rs.getString("statusSolicitacaoPacApp"));

			return solicitacaoapp;

		}
	}

	/*****************************************************************************/

	public List<SolicitacaoApp> buscarTodasSolicitacoesApp() {
		String sql = "SELECT idSolicitacaoPacApp, cpfPacienteSolicitacaoPacApp, "
				+ "dataSolicitacaoPacApp, horaSolicitacaoPacApp,"
				+ "necessidadeAcompanhanteSolicitacaoPacApp,"
				+ "statusSolicitacaoPacApp FROM JCN_tbsSolicitacaoPacienteApp";

		List<SolicitacaoApp> list = namedParameterJdbcTemplate.query(sql, 
				getSqlParameterByModel(null),
				new SolicitacaoAppMapper());

		return list;
	}

	/*****************************************************************************/

	public SolicitacaoApp buscarSolicitacaoPorId(Integer idSolicitacaoPacApp) {
		String sql = "SELECT * FROM JCN_tbsSolicitacaoPacienteApp WHERE idSolicitacaoPacApp= "
				+ " :idSolicitacaoPacApp";

		  return namedParameterJdbcTemplate.queryForObject(sql, 
				  getSqlParameterByModel(new SolicitacaoApp(idSolicitacaoPacApp)), new SolicitacaoAppMapper());
	}
	
	/*****************************************************************************/


	public void atualizarStatusSolicitacao(SolicitacaoApp solicitacao) {
		String sql = "UPDATE JCN_tbsSolicitacaoPacienteApp SET "
	 		    + "statusSolicitacaoPacApp = 'Já agendado' "
	 		    + " WHERE idSolicitacaoPacApp = :idSolicitacaoPacApp";

		  namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(solicitacao));
	}

}
