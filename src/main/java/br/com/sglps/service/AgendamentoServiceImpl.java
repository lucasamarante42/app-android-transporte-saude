package br.com.sglps.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sglps.dao.InterfaceAgendamentoDAO;
import br.com.sglps.model.Agendamento;



@Service
public class AgendamentoServiceImpl implements InterfaceAgendamentoService  {

	//referencia InterfaceAgendamentoDAO
	InterfaceAgendamentoDAO agendamentoDAO;
	
	/*******************************************************************************/
	
	@Autowired
	public void setAgendamentoDAO(InterfaceAgendamentoDAO agendamentoDAO) {
		this.agendamentoDAO = agendamentoDAO;
	}
	
	/*******************************************************************************/
	
	public void inserirAgendamento(Agendamento agendamento) {
		agendamentoDAO.inserirAgendamento(agendamento);
		
	}

	/*******************************************************************************/

	public void atualizarAgendamento(Agendamento agendamento) {
		agendamentoDAO.atualizarAgendamento(agendamento);
		
	}

	/*******************************************************************************/

	public List<Agendamento> buscarTodosAgendamentos() {
		return agendamentoDAO.buscarTodosAgendamentos();
	}
	
	/*******************************************************************************/

	public Agendamento buscarAgendamentoPorId(Integer idAgendamento) {
		return agendamentoDAO.buscarAgendamentoPorId(idAgendamento);
	}
	
	
	
	
	
	
	
	

}
