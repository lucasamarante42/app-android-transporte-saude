package br.com.sglps.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Motorista {
	
	private Integer idMotorista;
	
	@NotEmpty(message="Nome não pode estar vazio")
	@Size(max = 60, message = "Deve conter até 60 caracteres")
	private String nomeMotorista;
	
	@NotEmpty(message="Celular não pode estar vazio")
	private String celularMotorista;
	
	@NotEmpty(message="Selecione o status")
	private String statusMotorista;
	
	@Size(max = 240, message = "Deve conter até 240 caracteres")
	private String motivoMotorista;


	//constructor using fields
	public Motorista() {
		super();
	}

	// Constructor using fields (id)
	public Motorista(Integer idMotorista) {
		super();
		this.idMotorista = idMotorista;
	}

	//getters and setters
	public Integer getIdMotorista() {
		return idMotorista;
	}

	public void setIdMotorista(Integer idMotorista) {
		this.idMotorista = idMotorista;
	}

	public String getNomeMotorista() {
		return nomeMotorista;
	}

	public void setNomeMotorista(String nomeMotorista) {
		this.nomeMotorista = nomeMotorista;
	}

	public String getCelularMotorista() {
		return celularMotorista;
	}

	public void setCelularMotorista(String celularMotorista) {
		this.celularMotorista = celularMotorista;
	}

	public String getStatusMotorista() {
		return statusMotorista;
	}

	public void setStatusMotorista(String statusMotorista) {
		this.statusMotorista = statusMotorista;
	}

	public String getMotivoMotorista() {
		return motivoMotorista;
	}

	public void setMotivoMotorista(String motivoMotorista) {
		this.motivoMotorista = motivoMotorista;
	}
	
	
	
	
	
	
	
	
	
	

}
