package br.com.sglps.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

public class Usuario {
	
	private Integer idUsuario;

    @NotEmpty(message="Nome não pode estar vazio")
    @Size(max = 80, message="Deve conter até 80 caracteres")
	private String nomeUsuario; 
     
    @NotEmpty(message="Cpf não pode estar vazio")
    @CPF(message="Cpf inválido")
	private String cpfUsuario;
      
    
    @NotEmpty(message="Cargo não pode estar vazio")
    @Size(max = 40, message="Deve conter até 40 caracteres")
	private String cargoUsuario;
    
    @NotEmpty(message="Celular não pode estar vazio")
    @Size(max = 18, message="Deve conter até 18 caracteres")
	private String celularUsuario;
	
    @Email(message="Email inválido")
	private String emailUsuario;
	 
	 	 
	//Constructor using fields 
	public Usuario() {
		super();
	}

    //Constructor using fields (id)
	public Usuario(Integer idUsuario) {
		super();
		this.idUsuario = idUsuario;
	}

	
	//getters and setters
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public String getCargoUsuario() {
		return cargoUsuario;
	}

	public void setCargoUsuario(String cargoUsuario) {
		this.cargoUsuario = cargoUsuario;
	}

	public String getCelularUsuario() {
		return celularUsuario;
	}

	public void setCelularUsuario(String celularUsuario) {
		this.celularUsuario = celularUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	
	
	
	 
	 
	
	

}
