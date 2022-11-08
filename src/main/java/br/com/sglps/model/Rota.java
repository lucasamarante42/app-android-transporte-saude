package br.com.sglps.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Rota {

	private Integer idRota;
	
	@NotEmpty(message="Destino da rota não pode estar vazio")
	@Size(max = 345, message = "Deve conter até 345 caracteres")
	private String destinoRota;
	
	@NotEmpty(message = "Distância não pode estar vazio")
	@Size(max = 5, message = "Deve conter até 5 caracteres")
	private String distanciaRota;
	
	@NotEmpty(message="Tempo da rota não pode estar vazio")
	private String tempoEstimadoRota;

		
	//constructor using fields
	public Rota() {
		super();
	}

	// Constructor using fields (id)
	public Rota(Integer idRota) {
		super();
		this.idRota = idRota;
	}

	
	//getters and setters
	public Integer getIdRota() {
		return idRota;
	}

	public void setIdRota(Integer idRota) {
		this.idRota = idRota;
	}

	public String getDestinoRota() {
		return destinoRota;
	}

	public void setDestinoRota(String destinoRota) {
		this.destinoRota = destinoRota;
	}

	public String getDistanciaRota() {
		return distanciaRota;
	}

	public void setDistanciaRota(String distanciaRota) {
		this.distanciaRota = distanciaRota;
	}

	public String getTempoEstimadoRota() {
		return tempoEstimadoRota;
	}

	public void setTempoEstimadoRota(String tempoEstimadoRota) {
		this.tempoEstimadoRota = tempoEstimadoRota;
	}
	
	
	
	
	
	
}
