package br.com.sglps.dao;

import java.util.List;

import br.com.sglps.model.Paciente;

public interface InterfacePacienteDAO {
	
	public void inserirPaciente(Paciente paciente);
	public void atualizarPaciente(Paciente paciente);
	
	public List<Paciente> buscarTodosPacientes();
	public Paciente buscarPacientePorId(Integer idPaciente);	
		
	

}
