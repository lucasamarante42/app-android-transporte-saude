package br.com.sglps.service;

import java.util.List;

import br.com.sglps.model.AvaliacaoApp;

public interface InterfaceAvaliacaoAppService {
	
	public List<AvaliacaoApp> buscarTodasAvaliacoesApp();
	public void atualizarStatusAvaliacao(AvaliacaoApp avaliacao);
	public AvaliacaoApp buscaStatusAvaliacaoPorId(Integer idAvaliacaoPac);	

}
