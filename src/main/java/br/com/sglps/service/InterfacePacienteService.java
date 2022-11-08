package br.com.sglps.service;

import java.util.List;

import br.com.sglps.model.Paciente;

public interface InterfacePacienteService {
	
	public void inserirPaciente(Paciente paciente);
	public void atualizarPaciente(Paciente paciente);
	
	public List<Paciente> buscarTodosPacientes();
	public Paciente buscarPacientePorId(Integer idPaciente);

}
