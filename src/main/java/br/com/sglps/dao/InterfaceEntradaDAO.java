package br.com.sglps.dao;

import java.util.List;

import br.com.sglps.model.Entrada;


public interface InterfaceEntradaDAO {
	
	public Entrada findUserInfo(String userName);
    
    // [USER,AMIN,..]
    public List<String> getUserRoles(String userName);
}
