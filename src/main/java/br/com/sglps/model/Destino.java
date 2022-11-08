package br.com.sglps.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Destino {
	
	private Integer idDestino;
		
	@NotEmpty(message="Local não pode estar vazio")
	@Size(max = 150, message="Deve conter até 150 caracteres")
	private String nomeLocalDestino;	
	
	@NotEmpty(message="Endereço não pode estar vazio")
	@Size(max = 150, message="Deve conter até 150 caracteres")
	private String enderecoDestino;
	
	
	@NotEmpty(message="Cidade não pode estar vazio")
	@Size(max = 40, message="Deve conter até 40 caracteres")
	private String cidadeDestino;
	
	
	@NotEmpty(message="Telefone não pode estar vazio")
	private String telefoneDestino;


	//constructor using fields
	public Destino() {
		super();
	}

	// Constructor using fields (id)
	public Destino(Integer idDestino) {
		super();
		this.idDestino = idDestino;
	}

	//getters and setters
	public Integer getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Integer idDestino) {
		this.idDestino = idDestino;
	}

	public String getNomeLocalDestino() {
		return nomeLocalDestino;
	}

	public void setNomeLocalDestino(String nomeLocalDestino) {
		this.nomeLocalDestino = nomeLocalDestino;
	}

	public String getEnderecoDestino() {
		return enderecoDestino;
	}

	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}

	public String getCidadeDestino() {
		return cidadeDestino;
	}

	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}

	public String getTelefoneDestino() {
		return telefoneDestino;
	}

	public void setTelefoneDestino(String telefoneDestino) {
		this.telefoneDestino = telefoneDestino;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
