package br.com.sglps.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

public class Paciente {
	
	private Integer idPaciente;
	
	@NotEmpty(message="Cpf não pode estar vazio")
    @CPF(message="Cpf inválido")
	private String cpfPaciente;
	
	@NotEmpty(message="Nome não pode estar vazio")
    @Size(max = 80, message="Deve conter até 80 caracteres")
	private String nomePaciente;
	
	@NotEmpty(message="Data não pode estar vazia")
    @Size(max = 15, message="Deve conter até 15 caracteres")
	private String dataNascimentoPaciente;
	
	@NotEmpty(message="Celular não pode estar vazio")
    @Size(max = 18, message="Deve conter até 18 caracteres")
	private String celularPaciente;
	
	@Email(message="Email inválido")
	private String emailPaciente;
	
	@Size(max = 325, message="Deve conter até 325 caracteres")
	private String historicoPaciente;
	
	@NotEmpty(message="Selecione a necessidade especial")
	private String necessidadeEspecialPaciente;
	
	@NotEmpty(message="Selecione a necessidade acompanhante")
	private String necessidadeAcompanhantePaciente;
	
	@NotEmpty(message="Selecione a hemodiálise")
	private String hemodialisePaciente;

	
	//constructor using fields
	public Paciente() {
		super();
	}


	// Constructor using fields (id)
	public Paciente(Integer idPaciente) {
		super();
		this.idPaciente = idPaciente;
	}

	
	//getters and setters
	public Integer getIdPaciente() {
		return idPaciente;
	}


	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}


	public String getCpfPaciente() {
		return cpfPaciente;
	}


	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}


	public String getNomePaciente() {
		return nomePaciente;
	}


	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}


	public String getDataNascimentoPaciente() {
		return dataNascimentoPaciente;
	}


	public void setDataNascimentoPaciente(String dataNascimentoPaciente) {
		this.dataNascimentoPaciente = dataNascimentoPaciente;
	}


	public String getCelularPaciente() {
		return celularPaciente;
	}


	public void setCelularPaciente(String celularPaciente) {
		this.celularPaciente = celularPaciente;
	}


	public String getEmailPaciente() {
		return emailPaciente;
	}


	public void setEmailPaciente(String emailPaciente) {
		this.emailPaciente = emailPaciente;
	}


	public String getHistoricoPaciente() {
		return historicoPaciente;
	}


	public void setHistoricoPaciente(String historicoPaciente) {
		this.historicoPaciente = historicoPaciente;
	}


	public String getNecessidadeEspecialPaciente() {
		return necessidadeEspecialPaciente;
	}


	public void setNecessidadeEspecialPaciente(String necessidadeEspecialPaciente) {
		this.necessidadeEspecialPaciente = necessidadeEspecialPaciente;
	}


	public String getNecessidadeAcompanhantePaciente() {
		return necessidadeAcompanhantePaciente;
	}


	public void setNecessidadeAcompanhantePaciente(String necessidadeAcompanhantePaciente) {
		this.necessidadeAcompanhantePaciente = necessidadeAcompanhantePaciente;
	}


	public String getHemodialisePaciente() {
		return hemodialisePaciente;
	}


	public void setHemodialisePaciente(String hemodialisePaciente) {
		this.hemodialisePaciente = hemodialisePaciente;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
