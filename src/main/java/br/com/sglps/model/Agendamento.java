package br.com.sglps.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

public class Agendamento {
	
	
	
	private Integer idAgendamento;
	
	@NotEmpty(message="Cpf não pode estar vazio")
    @CPF(message="Cpf inválido")
	private String cpfPacienteAgendamento;
	
	@Min(value=0, message="Selecione o destino")
	private Integer idDestinoAgendamento;
	
	@Min(value=0, message="Selecione o motorista")
	private Integer idMotoristaAgendamento;
	
	@Min(value=0, message="Selecione o automóvel")
	private Integer idAutomovelAgendamento;
	
	@Min(value=0, message="Selecione a rota")
	private Integer idRotaAgendamento;
	
	@NotEmpty(message="Data não pode estar vazia")
	private String dataAgendamento;
	
	@NotEmpty(message="Hora não pode estar vazia")
	private String horaAgendamento;
	
	@NotEmpty(message="Selecione a necessidade acompanhante")
	private String necessidadeAcompanhanteAgendamento;
	
	@NotEmpty(message="Selecione o status")
	private String statusAgendamento;
	
	
	
	private Destino destino;
		
	private Motorista motorista;
	
	private Automovel automovel;
	
	private Rota rota;
	

	

	
	//consstructor using fields
	public Agendamento() {
		super();
	}

	// Constructor using fields (id)
	public Agendamento(Integer idAgendamento) {
		super();
		this.idAgendamento = idAgendamento;
	}

	//getters and setters
	public Integer getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(Integer idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public String getCpfPacienteAgendamento() {
		return cpfPacienteAgendamento;
	}

	public void setCpfPacienteAgendamento(String cpfPacienteAgendamento) {
		this.cpfPacienteAgendamento = cpfPacienteAgendamento;
	}

	public Integer getIdDestinoAgendamento() {
		return idDestinoAgendamento;
	}

	public void setIdDestinoAgendamento(Integer idDestinoAgendamento) {
		this.idDestinoAgendamento = idDestinoAgendamento;
	}

	public Integer getIdMotoristaAgendamento() {
		return idMotoristaAgendamento;
	}

	public void setIdMotoristaAgendamento(Integer idMotoristaAgendamento) {
		this.idMotoristaAgendamento = idMotoristaAgendamento;
	}

	public Integer getIdAutomovelAgendamento() {
		return idAutomovelAgendamento;
	}

	public void setIdAutomovelAgendamento(Integer idAutomovelAgendamento) {
		this.idAutomovelAgendamento = idAutomovelAgendamento;
	}

	public Integer getIdRotaAgendamento() {
		return idRotaAgendamento;
	}

	public void setIdRotaAgendamento(Integer idRotaAgendamento) {
		this.idRotaAgendamento = idRotaAgendamento;
	}

	public String getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(String dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public String getHoraAgendamento() {
		return horaAgendamento;
	}

	public void setHoraAgendamento(String horaAgendamento) {
		this.horaAgendamento = horaAgendamento;
	}

	public String getStatusAgendamento() {
		return statusAgendamento;
	}

	public void setStatusAgendamento(String statusAgendamento) {
		this.statusAgendamento = statusAgendamento;
	}

	
	
	public String getNecessidadeAcompanhanteAgendamento() {
		return necessidadeAcompanhanteAgendamento;
	}

	public void setNecessidadeAcompanhanteAgendamento(String necessidadeAcompanhanteAgendamento) {
		this.necessidadeAcompanhanteAgendamento = necessidadeAcompanhanteAgendamento;
	}

	//getters and setters objects
	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}

	
	
		
	
	
	
	
	
	
	
	
	

}
