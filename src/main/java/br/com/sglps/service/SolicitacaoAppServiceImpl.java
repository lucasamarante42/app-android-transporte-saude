package br.com.sglps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sglps.dao.InterfaceSolicitacaoAppDAO;
import br.com.sglps.model.SolicitacaoApp;


@Service
public class SolicitacaoAppServiceImpl implements InterfaceSolicitacaoAppService {

	//referencia InterfaceSolicitacaoAppDAO
	InterfaceSolicitacaoAppDAO solicitacaoAppDAO;
	
	/*******************************************************************************/
	
	//getters and setters (apenas o set*
	@Autowired
	public void setSolicitacaoAppDAO(InterfaceSolicitacaoAppDAO solicitacaoAppDAO){
		this.solicitacaoAppDAO = solicitacaoAppDAO;
	}
	
	
	/*******************************************************************************/
	
	public List<SolicitacaoApp> buscarTodasSolicitacoesApp() {
		return solicitacaoAppDAO.buscarTodasSolicitacoesApp();
	}

	/*******************************************************************************/

	public SolicitacaoApp buscarSolicitacaoPorId(Integer idSolicitacaoPacApp) {
		return solicitacaoAppDAO.buscarSolicitacaoPorId(idSolicitacaoPacApp);
	}
	
	/*******************************************************************************/


	public void atualizarStatusSolicitacao(SolicitacaoApp solicitacao) {
		solicitacaoAppDAO.atualizarStatusSolicitacao(solicitacao);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
