package br.com.sglps.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.sglps.model.Entrada;

public class EntradaMapper implements RowMapper<Entrada> {
	 
  
    public Entrada mapRow(ResultSet rs, int rowNum) throws SQLException {
 
        String userName = rs.getString("loginEntradaSistema");
        String password = rs.getString("senhaEntradaSistema");
 
        return new Entrada(userName, password);
    }
}
 