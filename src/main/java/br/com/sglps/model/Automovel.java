package br.com.sglps.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Automovel {

	private Integer idAutomovel;

	@NotEmpty(message = "Nome não pode estar vazio")
	@Size(max = 30, message = "Deve conter até 30 caracteres")
	private String nomeAutomovel;

	@NotEmpty(message = "Marca não pode estar vazio")
	@Size(max = 30, message = "Deve conter até 30 caracteres")
	private String marcaAutomovel;

	@NotNull(message = "Capacidade não pode estar vazio")
	private Integer capacidadePassageirosAutomovel;

	@NotNull(message = "Ano não pode estar vazio")
	private Integer anoAutomovel;

	@NotEmpty(message = "Pertencente não pode estar vazio")
	@Size(max = 30, message = "Deve conter até 30 caracteres")
	private String pertencenteAutomovel;

	@NotEmpty(message="Selecione o status")
	private String statusAutomovel;

	@Size(max = 240, message = "Deve conter até 240 caracteres")
	private String motivoAutomovel;

	// Constructor using fields
	public Automovel() {
		super();
	}

	// Constructor using fields (id)
	public Automovel(Integer idAutomovel) {
		super();
		this.idAutomovel = idAutomovel;
	}

	//getters and setters
	public Integer getIdAutomovel() {
		return idAutomovel;
	}

	public void setIdAutomovel(Integer idAutomovel) {
		this.idAutomovel = idAutomovel;
	}

	public String getNomeAutomovel() {
		return nomeAutomovel;
	}

	public void setNomeAutomovel(String nomeAutomovel) {
		this.nomeAutomovel = nomeAutomovel;
	}

	public String getMarcaAutomovel() {
		return marcaAutomovel;
	}

	public void setMarcaAutomovel(String marcaAutomovel) {
		this.marcaAutomovel = marcaAutomovel;
	}

	public Integer getCapacidadePassageirosAutomovel() {
		return capacidadePassageirosAutomovel;
	}

	public void setCapacidadePassageirosAutomovel(Integer capacidadePassageirosAutomovel) {
		this.capacidadePassageirosAutomovel = capacidadePassageirosAutomovel;
	}

	public Integer getAnoAutomovel() {
		return anoAutomovel;
	}

	public void setAnoAutomovel(Integer anoAutomovel) {
		this.anoAutomovel = anoAutomovel;
	}

	public String getPertencenteAutomovel() {
		return pertencenteAutomovel;
	}

	public void setPertencenteAutomovel(String pertencenteAutomovel) {
		this.pertencenteAutomovel = pertencenteAutomovel;
	}

	public String getStatusAutomovel() {
		return statusAutomovel;
	}

	public void setStatusAutomovel(String statusAutomovel) {
		this.statusAutomovel = statusAutomovel;
	}

	public String getMotivoAutomovel() {
		return motivoAutomovel;
	}

	public void setMotivoAutomovel(String motivoAutomovel) {
		this.motivoAutomovel = motivoAutomovel;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
