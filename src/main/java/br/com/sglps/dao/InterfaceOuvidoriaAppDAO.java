package br.com.sglps.dao;

import java.util.List;

import br.com.sglps.model.OuvidoriaApp;

public interface InterfaceOuvidoriaAppDAO {
	
	public List<OuvidoriaApp> buscarTodasOuvidoriasApp();
	
	public void atualizarStatusOuvidoria(OuvidoriaApp ouvidoria);
	public OuvidoriaApp buscaStatusOuvidoriaPorId(Integer idOuvidoriaPac);

}
