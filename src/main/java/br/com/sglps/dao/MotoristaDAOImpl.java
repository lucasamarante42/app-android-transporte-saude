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


import br.com.sglps.model.Motorista;

//adicionando repositorio
@Repository
public class MotoristaDAOImpl implements InterfaceMotoristaDAO {

	// parametros jdbc
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

	}

	/*****************************************************************************/
	private SqlParameterSource getSqlParameterByModel(Motorista motorista) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();

		if (motorista != null) {

			paramSource.addValue("idMotorista", motorista.getIdMotorista());
			paramSource.addValue("nomeMotorista", motorista.getNomeMotorista());
			paramSource.addValue("celularMotorista", motorista.getCelularMotorista());
			paramSource.addValue("statusMotorista", motorista.getStatusMotorista());
			paramSource.addValue("motivoMotorista", motorista.getMotivoMotorista());

		}

		return paramSource;
	}

	/*****************************************************************************/

	private static final class MotoristaMapper implements RowMapper<Motorista> {
		public Motorista mapRow(ResultSet rs, int rowNum) throws SQLException {

			Motorista motorista = new Motorista();

			motorista.setIdMotorista(rs.getInt("idMotorista"));
			motorista.setNomeMotorista(rs.getString("nomeMotorista"));
			motorista.setCelularMotorista(rs.getString("celularMotorista"));
			motorista.setStatusMotorista(rs.getString("statusMotorista"));
			motorista.setMotivoMotorista(rs.getString("motivoMotorista"));

			return motorista;

		}
	}

	/*****************************************************************************/

	public void inserirMotorista(Motorista motorista) {
		String sql = "INSERT INTO JCN_tbsMotorista(nomeMotorista,celularMotorista,"
	 			+ "statusMotorista,motivoMotorista) values "
		 		+ "(:nomeMotorista, :celularMotorista, "
		 		+ ":statusMotorista, :motivoMotorista)";
		
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(motorista));

	}

	/*****************************************************************************/
	
	public void atualizarMotorista(Motorista motorista) {
		String sql = "UPDATE JCN_tbsMotorista SET "
	 		    + "nomeMotorista = :nomeMotorista, "
	 		    + "celularMotorista = :celularMotorista, "
		  		+ "statusMotorista = :statusMotorista, "
		  		+ "motivoMotorista = :motivoMotorista "
		  		+ " WHERE idMotorista = :idMotorista";

		  namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(motorista));

	}

	/*****************************************************************************/
	
	public List<Motorista> buscarTodosMotoristas() {
		String sql = "SELECT idMotorista, nomeMotorista, celularMotorista, "
				+ "statusMotorista, motivoMotorista "
				+ "FROM JCN_tbsMotorista";
	 
		List<Motorista> list = namedParameterJdbcTemplate.query(sql,getSqlParameterByModel(null),
				new MotoristaMapper());
		
		return list;
	}

	/*****************************************************************************/
	
	public Motorista buscarMotoristaPorId(Integer idMotorista) {
		String sql = "SELECT * FROM JCN_tbsMotorista WHERE idMotorista= :idMotorista";

		  return namedParameterJdbcTemplate.queryForObject(sql, 
				  getSqlParameterByModel(new Motorista(idMotorista)), new MotoristaMapper());
		
		
	}

	/*****************************************************************************/

	public List<Motorista> disponivelBuscarTodosMotoristas() {
		String sql = "SELECT idMotorista, nomeMotorista, celularMotorista, "
				+ "statusMotorista, motivoMotorista "
				+ "FROM JCN_tbsMotorista WHERE statusMotorista = 'Disponível'";
	 
		List<Motorista> lista = namedParameterJdbcTemplate.query(sql,getSqlParameterByModel(null),
				new MotoristaMapper());
		
		return lista;
	}

}
