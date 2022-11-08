package br.com.sglps.service;

import java.util.List;

import br.com.sglps.model.Destino;

public interface InterfaceDestinoService {
	
	public void inserirDestino(Destino destino);	
	public void atualizarDestino(Destino destino);
	
	public List<Destino> buscarTodosDestinos();
	public Destino buscarDestinoPorId(Integer idDestino);	
	
	

}
