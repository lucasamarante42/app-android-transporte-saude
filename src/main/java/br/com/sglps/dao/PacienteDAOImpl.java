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

import br.com.sglps.model.Paciente;

//adicionando repositorio
@Repository
public class PacienteDAOImpl implements InterfacePacienteDAO {

	// parametros jdbc
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

	}

	/*****************************************************************************/
	private SqlParameterSource getSqlParameterByModel(Paciente paciente) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();

		if (paciente != null) {

			paramSource.addValue("idPaciente", paciente.getIdPaciente());
			paramSource.addValue("cpfPaciente", paciente.getCpfPaciente());
			paramSource.addValue("nomePaciente", paciente.getNomePaciente());
			paramSource.addValue("dataNascimentoPaciente", paciente.getDataNascimentoPaciente());
			paramSource.addValue("celularPaciente", paciente.getCelularPaciente());
			paramSource.addValue("emailPaciente", paciente.getEmailPaciente());
			paramSource.addValue("historicoPaciente", paciente.getHistoricoPaciente());
			paramSource.addValue("necessidadeEspecialPaciente", paciente.getNecessidadeEspecialPaciente());
			paramSource.addValue("necessidadeAcompanhantePaciente", paciente.getNecessidadeAcompanhantePaciente());
			paramSource.addValue("hemodialisePaciente", paciente.getHemodialisePaciente());

		}

		return paramSource;
	}

	/*****************************************************************************/

	private static final class PacienteMapper implements RowMapper<Paciente> {
		public Paciente mapRow(ResultSet rs, int rowNum) throws SQLException {

			Paciente paciente = new Paciente();

			paciente.setIdPaciente(rs.getInt("idPaciente"));
			paciente.setCpfPaciente(rs.getString("cpfPaciente"));
			paciente.setNomePaciente(rs.getString("nomePaciente"));
			paciente.setDataNascimentoPaciente(rs.getString("dataNascimentoPaciente"));
			paciente.setCelularPaciente(rs.getString("celularPaciente"));
			paciente.setEmailPaciente(rs.getString("emailPaciente"));
			paciente.setHistoricoPaciente(rs.getString("historicoPaciente"));
			paciente.setNecessidadeEspecialPaciente(rs.getString("necessidadeEspecialPaciente"));
			paciente.setNecessidadeAcompanhantePaciente(rs.getString("necessidadeAcompanhantePaciente"));
			paciente.setHemodialisePaciente(rs.getString("hemodialisePaciente"));

			return paciente;

		}
	}

	/*****************************************************************************/

	public void inserirPaciente(Paciente paciente) {
		String sql = "INSERT INTO JCN_tbsPaciente("
				+ "cpfPaciente,"
				+ "nomePaciente,"
				+ "dataNascimentoPaciente,"
				+ "celularPaciente,"
				+ "emailPaciente,"
				+ "historicoPaciente,"
				+ "necessidadeEspecialPaciente,"
				+ "necessidadeAcompanhantePaciente,"
	 			+ "hemodialisePaciente) values "
		 		+ "(:cpfPaciente, :nomePaciente, "
		 		+ ":dataNascimentoPaciente, :celularPaciente, "
		 		+ ":emailPaciente, :historicoPaciente,"
		 		+ ":necessidadeEspecialPaciente, :necessidadeAcompanhantePaciente,"
		 		+ ":hemodialisePaciente)";
		
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(paciente));

	}

	/*****************************************************************************/

	public void atualizarPaciente(Paciente paciente) {
		String sql = "UPDATE JCN_tbsPaciente SET "
	 		    + "cpfPaciente = :cpfPaciente, "
	 		    + "nomePaciente = :nomePaciente, "
		  		+ "dataNascimentoPaciente = :dataNascimentoPaciente, "
		  		+ "celularPaciente = :celularPaciente,"
		  		+ "emailPaciente = :emailPaciente,"
		  		+ "historicoPaciente = :historicoPaciente,"
		  		+ "necessidadeEspecialPaciente = :necessidadeEspecialPaciente,"
		  		+ "necessidadeAcompanhantePaciente = :necessidadeAcompanhantePaciente,"
		  		+ "hemodialisePaciente = :hemodialisePaciente"
		  		+ " WHERE idPaciente = :idPaciente";

		  namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(paciente));

	}

	/*****************************************************************************/

	public List<Paciente> buscarTodosPacientes() {
		String sql = "SELECT idPaciente, "
				+ "cpfPaciente, "
				+ "nomePaciente, "
				+ "dataNascimentoPaciente,"
				+ "celularPaciente,"
				+ "emailPaciente,"
				+ "historicoPaciente,"
				+ "necessidadeEspecialPaciente,"
				+ "necessidadeAcompanhantePaciente,"
				+ "hemodialisePaciente"
				+ " FROM JCN_tbsPaciente";
	 
		List<Paciente> list = namedParameterJdbcTemplate.query(sql,getSqlParameterByModel(null),
				new PacienteMapper());
		
		return list;
	}

	/*****************************************************************************/

	public Paciente buscarPacientePorId(Integer idPaciente) {
		String sql = "SELECT * FROM JCN_tbsPaciente WHERE idPaciente= :idPaciente";

		  return namedParameterJdbcTemplate.queryForObject(sql, 
				  getSqlParameterByModel(new Paciente(idPaciente)), new PacienteMapper());
	}

}
