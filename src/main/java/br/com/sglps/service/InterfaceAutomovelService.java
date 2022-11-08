package br.com.sglps.service;

import java.util.List;

import br.com.sglps.model.Automovel;

public interface InterfaceAutomovelService {
	
	public void inserirAutomovel(Automovel automovel);	
	public void atualizarAutomovel(Automovel automovel);
	
	public List<Automovel> buscarTodosAutomoveis();
	public Automovel buscarAutomovelPorId(Integer idAutomovel);
	
	//public void excluirAutomovel(int idAutomovel);
	public List<Automovel> disponivelBuscarTodosAutomoveis();

	

}
