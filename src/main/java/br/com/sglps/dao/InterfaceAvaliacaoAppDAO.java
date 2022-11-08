package br.com.sglps.dao;

import java.util.List;

import br.com.sglps.model.AvaliacaoApp;

public interface InterfaceAvaliacaoAppDAO {
	
	public List<AvaliacaoApp> buscarTodasAvaliacoesApp();
	public void atualizarStatusAvaliacao(AvaliacaoApp avaliacao);
	public AvaliacaoApp buscaStatusAvaliacaoPorId(Integer idAvaliacaoPac);	
	

}
