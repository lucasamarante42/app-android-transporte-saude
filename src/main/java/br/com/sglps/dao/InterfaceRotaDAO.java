package br.com.sglps.dao;

import java.util.List;

import br.com.sglps.model.Rota;

public interface InterfaceRotaDAO {
	
	public void inserirRota(Rota rota);
	public void atualizarRota(Rota rota);
	
	public List<Rota> buscarTodasRotas();
	public Rota buscarRotaPorId(Integer idRota);	
	

}
