package br.com.sglps.service;

import java.util.List;

import br.com.sglps.model.Agendamento;

public interface InterfaceAgendamentoService {
	
		
	public void inserirAgendamento(Agendamento agendamento);
	public void atualizarAgendamento(Agendamento agendamento);
	
	public List<Agendamento> buscarTodosAgendamentos();
	public Agendamento buscarAgendamentoPorId(Integer idAgendamento);
		
	

}
