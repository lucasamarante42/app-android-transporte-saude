package br.com.sglps.model;


public class AvaliacaoApp {
	
	
	private Integer idAvaliacaoPac;
	private String cpfPacienteAvaliacaoPac;
	private String dataAvaliacaoPac;
	private String avaliacaoAvaliacaoPac;
	private String mensagemAvaliacaoPac;
	private String statusAvaliacaoPac;
	
	
	//Constructor using fields
	public AvaliacaoApp() {
		super();
	}

	//Contructor using id
	public AvaliacaoApp(Integer idAvaliacaoPac) {
		super();
		this.idAvaliacaoPac = idAvaliacaoPac;
	}

	//getters and setters
	public Integer getIdAvaliacaoPac() {
		return idAvaliacaoPac;
	}

	public void setIdAvaliacaoPac(Integer idAvaliacaoPac) {
		this.idAvaliacaoPac = idAvaliacaoPac;
	}

	public String getCpfPacienteAvaliacaoPac() {
		return cpfPacienteAvaliacaoPac;
	}

	public void setCpfPacienteAvaliacaoPac(String cpfPacienteAvaliacaoPac) {
		this.cpfPacienteAvaliacaoPac = cpfPacienteAvaliacaoPac;
	}

	public String getDataAvaliacaoPac() {
		return dataAvaliacaoPac;
	}

	public void setDataAvaliacaoPac(String dataAvaliacaoPac) {
		this.dataAvaliacaoPac = dataAvaliacaoPac;
	}

	public String getAvaliacaoAvaliacaoPac() {
		return avaliacaoAvaliacaoPac;
	}

	public void setAvaliacaoAvaliacaoPac(String avaliacaoAvaliacaoPac) {
		this.avaliacaoAvaliacaoPac = avaliacaoAvaliacaoPac;
	}

	public String getMensagemAvaliacaoPac() {
		return mensagemAvaliacaoPac;
	}

	public void setMensagemAvaliacaoPac(String mensagemAvaliacaoPac) {
		this.mensagemAvaliacaoPac = mensagemAvaliacaoPac;
	}

	public String getStatusAvaliacaoPac() {
		return statusAvaliacaoPac;
	}

	public void setStatusAvaliacaoPac(String statusAvaliacaoPac) {
		this.statusAvaliacaoPac = statusAvaliacaoPac;
	}
	
	
	
	
	
	
	

}
