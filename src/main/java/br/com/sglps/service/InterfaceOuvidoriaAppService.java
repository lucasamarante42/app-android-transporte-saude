package br.com.sglps.service;

import java.util.List;

import br.com.sglps.model.OuvidoriaApp;

public interface InterfaceOuvidoriaAppService {
	
	
	public List<OuvidoriaApp> buscarTodasOuvidoriasApp();
	public void atualizarStatusOuvidoria(OuvidoriaApp ouvidoria);
	public OuvidoriaApp buscaStatusOuvidoriaPorId(Integer idOuvidoriaPac);


}
