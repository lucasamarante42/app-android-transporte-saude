package br.com.sglps.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sglps.dao.InterfaceAvaliacaoAppDAO;
import br.com.sglps.model.AvaliacaoApp;



@Service
public class AvaliacaoAppServiceImpl implements InterfaceAvaliacaoAppService {

	
	//referencia InterfaceAvaliacaoAppDAO
	InterfaceAvaliacaoAppDAO avaliacaoAppDAO;
	
	/*******************************************************************************/
	
	//setter
	@Autowired
	public void setAvaliacaoAppDAO(InterfaceAvaliacaoAppDAO avaliacaoAppDAO) {
		this.avaliacaoAppDAO = avaliacaoAppDAO;
	}
	
	
	/*******************************************************************************/
	
	public List<AvaliacaoApp> buscarTodasAvaliacoesApp() {
		return avaliacaoAppDAO.buscarTodasAvaliacoesApp();
	}

	/*******************************************************************************/

	public void atualizarStatusAvaliacao(AvaliacaoApp avaliacao) {
		avaliacaoAppDAO.atualizarStatusAvaliacao(avaliacao);
		
	}

	/*******************************************************************************/

	public AvaliacaoApp buscaStatusAvaliacaoPorId(Integer idAvaliacaoPac) {
		return avaliacaoAppDAO.buscaStatusAvaliacaoPorId(idAvaliacaoPac);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
