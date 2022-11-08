package br.com.sglps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sglps.dao.InterfacePacienteDAO;
import br.com.sglps.model.Paciente;


@Service
public class PacienteServiceImpl implements InterfacePacienteService {

	
	//referencia InterfacePacienteDAO
	InterfacePacienteDAO pacienteDAO;
	
	/*******************************************************************************/
	
	@Autowired
	public void setPacienteDAO(InterfacePacienteDAO pacienteDAO) {
		this.pacienteDAO = pacienteDAO;
	}
	
	
	/*******************************************************************************/

	
	public void inserirPaciente(Paciente paciente) {
		pacienteDAO.inserirPaciente(paciente);
		
	}

	/*******************************************************************************/


	public void atualizarPaciente(Paciente paciente) {
		pacienteDAO.atualizarPaciente(paciente);
		
	}
	
	/*******************************************************************************/


	public List<Paciente> buscarTodosPacientes() {
		return pacienteDAO.buscarTodosPacientes();
	}

	/*******************************************************************************/

	
	public Paciente buscarPacientePorId(Integer idPaciente) {
		return pacienteDAO.buscarPacientePorId(idPaciente);
	}
	
	
	
	
	
	
	
	
	
	

}
