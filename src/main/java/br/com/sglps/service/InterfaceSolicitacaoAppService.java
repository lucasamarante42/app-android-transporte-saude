package br.com.sglps.service;

import java.util.List;

import br.com.sglps.model.SolicitacaoApp;

public interface InterfaceSolicitacaoAppService {
	
	public List<SolicitacaoApp> buscarTodasSolicitacoesApp();
	public SolicitacaoApp buscarSolicitacaoPorId(Integer idSolicitacaoPacApp);
	public void atualizarStatusSolicitacao(SolicitacaoApp solicitacao);	

}
