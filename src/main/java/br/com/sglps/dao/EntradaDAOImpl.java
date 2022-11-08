package br.com.sglps.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sglps.mapper.EntradaMapper;
import br.com.sglps.model.Entrada;

 
@Service
@Transactional
public class EntradaDAOImpl extends JdbcDaoSupport implements InterfaceEntradaDAO {
 
    @Autowired
    public EntradaDAOImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
  
 
    public Entrada findUserInfo(String userName) {
        String sql = "SELECT u.loginEntradaSistema,u.senhaEntradaSistema "
                + " FROM JCN_DPFE_tbsEntradaSistema u WHERE u.loginEntradaSistema = ? ";
 
        Object[] params = new Object[] { userName };
        EntradaMapper mapper = new EntradaMapper();
        
        try {
            Entrada entrada = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return entrada;
            
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
 
 
    public List<String> getUserRoles(String userName) {
        String sql = "SELECT r.tipoRegras "
                + " FROM JCN_DPFE_tbsRegras r WHERE r.loginRegras = ? ";
         
        Object[] params = new Object[] { userName };
         
        List<String> roles = this.getJdbcTemplate().queryForList(sql,params, String.class);
         
        return roles;
    }
     
}