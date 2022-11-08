package br.com.sglps.service;

import java.util.List;

import br.com.sglps.model.Motorista;

public interface InterfaceMotoristaService {
	public void inserirMotorista(Motorista motorista);
	public void atualizarMotorista(Motorista motorista);
	
	public List<Motorista> buscarTodosMotoristas();
	public Motorista buscarMotoristaPorId(Integer idMotorista);
	
	public List<Motorista> disponivelBuscarTodosMotoristas();
}
