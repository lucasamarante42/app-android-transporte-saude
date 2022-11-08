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

import br.com.sglps.model.Agendamento;
import br.com.sglps.model.Automovel;
import br.com.sglps.model.Destino;
import br.com.sglps.model.Motorista;
import br.com.sglps.model.Rota;

//adicionando repositorio
@Repository
public class AgendamentoDAOImpl implements InterfaceAgendamentoDAO {

	// parametros jdbc
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

	}

	/*****************************************************************************/

	private SqlParameterSource getSqlParameterByModel(Agendamento agendamento) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();

		if (agendamento != null) {

			paramSource.addValue("idAgendamento", agendamento.getIdAgendamento());
			paramSource.addValue("cpfPacienteAgendamento", agendamento.getCpfPacienteAgendamento());
			paramSource.addValue("idDestinoAgendamento", agendamento.getIdDestinoAgendamento());
			paramSource.addValue("idMotoristaAgendamento", agendamento.getIdMotoristaAgendamento());
			paramSource.addValue("idAutomovelAgendamento", agendamento.getIdAutomovelAgendamento());
			paramSource.addValue("idRotaAgendamento", agendamento.getIdRotaAgendamento());
			paramSource.addValue("dataAgendamento", agendamento.getDataAgendamento());
			paramSource.addValue("horaAgendamento", agendamento.getHoraAgendamento());
			paramSource.addValue("necessidadeAcompanhanteAgendamento", agendamento.getNecessidadeAcompanhanteAgendamento());
			paramSource.addValue("statusAgendamento", agendamento.getStatusAgendamento());

		}

		return paramSource;
	}

	/*****************************************************************************/

	
	private static final class AgendamentoMapper implements RowMapper<Agendamento> {
		public Agendamento mapRow(ResultSet rs, int rowNum) throws SQLException {

			Agendamento agendamento = new Agendamento();
			Destino destino = new Destino();
			Motorista motorista = new Motorista();
			Automovel automovel = new Automovel();
			Rota rota = new Rota();
			
			destino.setIdDestino(rs.getInt("destino.idDestino"));
			destino.setNomeLocalDestino(rs.getString("destino.nomeLocalDestino"));
			destino.setEnderecoDestino(rs.getString("destino.enderecoDestino"));
			destino.setCidadeDestino(rs.getString("destino.cidadeDestino"));
			destino.setTelefoneDestino(rs.getString("destino.telefoneDestino"));
			
			motorista.setIdMotorista(rs.getInt("motorista.idMotorista"));
			motorista.setNomeMotorista(rs.getString("motorista.nomeMotorista"));
			motorista.setCelularMotorista(rs.getString("motorista.celularMotorista"));
			motorista.setStatusMotorista(rs.getString("motorista.statusMotorista"));
			motorista.setMotivoMotorista(rs.getString("motorista.motivoMotorista"));
			
			automovel.setIdAutomovel(rs.getInt("automovel.idAutomovel"));
			automovel.setNomeAutomovel(rs.getString("automovel.nomeAutomovel"));
			automovel.setMarcaAutomovel(rs.getString("automovel.marcaAutomovel"));
			automovel.setCapacidadePassageirosAutomovel(rs.getInt("automovel.capacidadePassageirosAutomovel"));
			automovel.setAnoAutomovel(rs.getInt("automovel.anoAutomovel"));
			automovel.setPertencenteAutomovel(rs.getString("automovel.pertencenteAutomovel"));
			automovel.setStatusAutomovel(rs.getString("automovel.statusAutomovel"));
			automovel.setMotivoAutomovel(rs.getString("automovel.motivoAutomovel"));
			
			rota.setIdRota(rs.getInt("rota.idRota"));
			rota.setDestinoRota(rs.getString("rota.destinoRota"));
			rota.setDistanciaRota(rs.getString("rota.distanciaRota"));
			rota.setTempoEstimadoRota(rs.getString("rota.tempoEstimadoRota"));
			
			
			agendamento.setIdAgendamento(rs.getInt("idAgendamento"));
			agendamento.setCpfPacienteAgendamento(rs.getString("cpfPacienteAgendamento"));
			agendamento.setIdDestinoAgendamento(rs.getInt("idDestinoAgendamento"));
			agendamento.setIdMotoristaAgendamento(rs.getInt("idMotoristaAgendamento"));
			agendamento.setIdAutomovelAgendamento(rs.getInt("idAutomovelAgendamento"));
			agendamento.setIdRotaAgendamento(rs.getInt("idRotaAgendamento"));
			agendamento.setDataAgendamento(rs.getString("dataAgendamento"));
			agendamento.setHoraAgendamento(rs.getString("horaAgendamento"));
			agendamento.setNecessidadeAcompanhanteAgendamento(rs.getString("necessidadeAcompanhanteAgendamento"));
			agendamento.setStatusAgendamento(rs.getString("statusAgendamento"));
						
						
			//destino.setIdDestino(agendamento.getIdDestinoAgendamento());			
			//destino.setNomeLocalDestino(agendamento.getNomeLocalDestinoAgendamento());
			agendamento.setDestino(destino);
			agendamento.setMotorista(motorista);
			agendamento.setAutomovel(automovel);
			agendamento.setRota(rota);
			
			
			//motorista.setIdMotorista(agendamento.getIdMotoristaAgendamento());
			//agendamento.setMotorista(motorista);
			
			//automovel.setIdAutomovel(agendamento.getIdAutomovelAgendamento());
			//agendamento.setAutomovel(automovel);
			
			//rota.setIdRota(agendamento.getIdRotaAgendamento());
			//agendamento.setRota(rota);
			
			return agendamento;

		}
	}

	/*****************************************************************************/

		
	public void inserirAgendamento(Agendamento agendamento) {
		String sql = "INSERT INTO JCN_tbsAgendamento("
				+ "cpfPacienteAgendamento,"
				+ "idDestinoAgendamento,"
	 			+ "idMotoristaAgendamento,"
	 			+ "idAutomovelAgendamento,"
	 			+ "idRotaAgendamento,"
	 			+ "dataAgendamento,"
	 			+ "horaAgendamento,"
	 			+ "necessidadeAcompanhanteAgendamento,"
	 			+ "statusAgendamento) values "
		 		+ "(:cpfPacienteAgendamento, "
		 		+ ":idDestinoAgendamento, "
		 		+ ":idMotoristaAgendamento,"
		 		+ ":idAutomovelAgendamento,"
		 		+ ":idRotaAgendamento,"
		 		+ ":dataAgendamento,"
		 		+ ":horaAgendamento,"
		 		+ ":necessidadeAcompanhanteAgendamento,"
		 		+ ":statusAgendamento)";
		
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(agendamento));

	}

	
	/*****************************************************************************/

		
	public void atualizarAgendamento(Agendamento agendamento) {
		String sql = "UPDATE JCN_tbsAgendamento SET "
	 		    + "cpfPacienteAgendamento = :cpfPacienteAgendamento, "
	 		    + "idDestinoAgendamento = :idDestinoAgendamento, "
		  		+ "idMotoristaAgendamento = :idMotoristaAgendamento, "
		  		+ "idAutomovelAgendamento = :idAutomovelAgendamento, "
		  		+ "idRotaAgendamento = :idRotaAgendamento, "
		  		+ "dataAgendamento = :dataAgendamento, "
		  		+ "horaAgendamento = :horaAgendamento,"
		  		+ "necessidadeAcompanhanteAgendamento = :necessidadeAcompanhanteAgendamento,"
		  		+ "statusAgendamento = :statusAgendamento "
		  		+ " WHERE idAgendamento = :idAgendamento";

		  namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(agendamento));

	}

	/*****************************************************************************/

	public List<Agendamento> buscarTodosAgendamentos() {
		/* String sql = "SELECT idAgendamento, "
				+ "cpfPacienteSolicitacaoPacApp, "
				+ "idDestinoAgendamento, "
				+ "idMotoristaAgendamento, "
				+ "idAutomovelAgendamento, "
				+ "idRotaAgendamento, "
				+ "dataSolicitacaoPacApp, "
				+ "horaSolicitacaoPacApp, "
				+ "statusAgendamento "
				+ "FROM JCN_tbsAgendamento"; */
		/*String sql = "SELECT * FROM JCN_tbsAgendamento AS agendamento INNER JOIN JCN_tbsDestino AS destino"
				+ " ON agendamento.idDestinoAgendamento = destino.idDestino INNER JOIN"
				+ " JCN_tbsMotorista AS motorista ON agendamento.idMotoristaAgendamento = motorista.idMotorista "
				+ " INNER JOIN JCN_tbsAutomovel AS automovel ON agendamento.idAutomovelAgendamento = "
				+ " automovel.idAutomovel INNER JOIN JCN_tbsRota AS rota ON agendamento.idRotaAgendamento ="
				+ " rota.idRota ORDER BY agendamento.dataSolicitacaoPacAPP ASC ";*/
		
		String sql = "SELECT agendamento.*, destino.*, motorista.*, "
				+ " automovel.*, rota.*  FROM "
				+ " JCN_tbsAgendamento AS agendamento INNER JOIN JCN_tbsDestino AS destino "
				+ " ON agendamento.idDestinoAgendamento = destino.idDestino INNER JOIN "
				+ " JCN_tbsMotorista AS motorista ON agendamento.idMotoristaAgendamento = motorista.idMotorista "
				+ " INNER JOIN JCN_tbsAutomovel AS automovel ON agendamento.idAutomovelAgendamento = "
				+ " automovel.idAutomovel INNER JOIN JCN_tbsRota AS rota ON agendamento.idRotaAgendamento = "
				+ " rota.idRota ORDER BY agendamento.dataAgendamento DESC";
					 
		
	 
		List<Agendamento> list = namedParameterJdbcTemplate.query(sql,getSqlParameterByModel(null),
				new AgendamentoMapper());
		
		return list;
	}
	
	/*****************************************************************************/

	public Agendamento buscarAgendamentoPorId(Integer idAgendamento) {
		//String sql = "SELECT * FROM JCN_tbsAgendamento WHERE idAgendamento= :idAgendamento";
		String sql = "SELECT agendamento.*, destino.*, motorista.*, "
				+ " automovel.*, rota.*  FROM "
				+ " JCN_tbsAgendamento AS agendamento INNER JOIN JCN_tbsDestino AS destino "
				+ " ON agendamento.idDestinoAgendamento = destino.idDestino INNER JOIN "
				+ " JCN_tbsMotorista AS motorista ON agendamento.idMotoristaAgendamento = motorista.idMotorista "
				+ " INNER JOIN JCN_tbsAutomovel AS automovel ON agendamento.idAutomovelAgendamento = "
				+ " automovel.idAutomovel INNER JOIN JCN_tbsRota AS rota ON agendamento.idRotaAgendamento = "
				+ " rota.idRota WHERE idAgendamento= :idAgendamento ";

		  return namedParameterJdbcTemplate.queryForObject(sql, 
				  getSqlParameterByModel(new Agendamento(idAgendamento)), new AgendamentoMapper());
	}

}
