package br.com.sglps.service;

import java.util.List;

import br.com.sglps.model.Rota;

public interface InterfaceRotaService {
	
	public void inserirRota(Rota rota);
	public void atualizarRota(Rota rota);
	
	public List<Rota> buscarTodasRotas();
	public Rota buscarRotaPorId(Integer idRota);
	
	

}
