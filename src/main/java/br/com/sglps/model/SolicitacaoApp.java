package br.com.sglps.model;

public class SolicitacaoApp {

	private Integer idSolicitacaoPacApp;
	private String cpfPacienteSolicitacaoPacApp;
	private String dataSolicitacaoPacApp;
	private String horaSolicitacaoPacApp;
	private String necessidadeAcompanhanteSolicitacaoPacApp;
	private String statusSolicitacaoPacApp;
	

	// Constructor using fields
	public SolicitacaoApp() {
		super();
	}

	// Constructor using fields (id)
	public SolicitacaoApp(Integer idSolicitacaoPacApp) {
		super();
		this.idSolicitacaoPacApp = idSolicitacaoPacApp;
	}

	//getters and setters
	public Integer getIdSolicitacaoPacApp() {
		return idSolicitacaoPacApp;
	}

	public void setIdSolicitacaoPacApp(Integer idSolicitacaoPacApp) {
		this.idSolicitacaoPacApp = idSolicitacaoPacApp;
	}

	public String getCpfPacienteSolicitacaoPacApp() {
		return cpfPacienteSolicitacaoPacApp;
	}

	public void setCpfPacienteSolicitacaoPacApp(String cpfPacienteSolicitacaoPacApp) {
		this.cpfPacienteSolicitacaoPacApp = cpfPacienteSolicitacaoPacApp;
	}

	public String getDataSolicitacaoPacApp() {
		return dataSolicitacaoPacApp;
	}

	public void setDataSolicitacaoPacApp(String dataSolicitacaoPacApp) {
		this.dataSolicitacaoPacApp = dataSolicitacaoPacApp;
	}

	public String getHoraSolicitacaoPacApp() {
		return horaSolicitacaoPacApp;
	}

	public void setHoraSolicitacaoPacApp(String horaSolicitacaoPacApp) {
		this.horaSolicitacaoPacApp = horaSolicitacaoPacApp;
	}

	public String getNecessidadeAcompanhanteSolicitacaoPacApp() {
		return necessidadeAcompanhanteSolicitacaoPacApp;
	}

	public void setNecessidadeAcompanhanteSolicitacaoPacApp(String necessidadeAcompanhanteSolicitacaoPacApp) {
		this.necessidadeAcompanhanteSolicitacaoPacApp = necessidadeAcompanhanteSolicitacaoPacApp;
	}

	public String getStatusSolicitacaoPacApp() {
		return statusSolicitacaoPacApp;
	}

	public void setStatusSolicitacaoPacApp(String statusSolicitacaoPacApp) {
		this.statusSolicitacaoPacApp = statusSolicitacaoPacApp;
	}
	
	
	
	
	
	

}
