package br.com.sglps.dao;

import java.util.List;


import br.com.sglps.model.SolicitacaoApp;;

public interface InterfaceSolicitacaoAppDAO {
		
	
	public List<SolicitacaoApp> buscarTodasSolicitacoesApp();
	public SolicitacaoApp buscarSolicitacaoPorId(Integer idSolicitacaoPacApp);
	public void atualizarStatusSolicitacao(SolicitacaoApp solicitacao);		
	

}
