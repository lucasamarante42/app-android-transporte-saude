package br.com.sglps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sglps.dao.InterfaceOuvidoriaAppDAO;
import br.com.sglps.model.OuvidoriaApp;


@Service
public class OuvidoriaAppServiceImpl implements InterfaceOuvidoriaAppService {

	
	//referencia InterfaceOuvidoriaAppDAO
	InterfaceOuvidoriaAppDAO ouvidoriaAppDAO;
	
	/*******************************************************************************/
	
	//setter
	@Autowired
	public void setOuvidoriaAppDAO(InterfaceOuvidoriaAppDAO ouvidoriaAppDAO) {
		this.ouvidoriaAppDAO = ouvidoriaAppDAO;
	}
		
	
	/*******************************************************************************/
	
	public List<OuvidoriaApp> buscarTodasOuvidoriasApp() {
			return ouvidoriaAppDAO.buscarTodasOuvidoriasApp();
	}

	/*******************************************************************************/

	public void atualizarStatusOuvidoria(OuvidoriaApp ouvidoria) {
		ouvidoriaAppDAO.atualizarStatusOuvidoria(ouvidoria);
		
	}

	/*******************************************************************************/

	public OuvidoriaApp buscaStatusOuvidoriaPorId(Integer idOuvidoriaPac) {
		return ouvidoriaAppDAO.buscaStatusOuvidoriaPorId(idOuvidoriaPac);
	}

	
		
	
	
	

}
