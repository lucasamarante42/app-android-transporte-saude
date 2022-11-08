package br.com.sglps.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sglps.dao.InterfaceRotaDAO;
import br.com.sglps.model.Rota;


@Service
public class RotaServiceImpl implements InterfaceRotaService  {

	//referencia InterfaceRotaDAO
	InterfaceRotaDAO rotaDAO;
	
	/*******************************************************************************/
	
	@Autowired
	public void setRotaDAO(InterfaceRotaDAO rotaDAO) {
		this.rotaDAO = rotaDAO;
	}
	
	/*******************************************************************************/
	
	
	public void inserirRota(Rota rota) {
		rotaDAO.inserirRota(rota);
		
	}

	/*******************************************************************************/

	public void atualizarRota(Rota rota) {
		rotaDAO.atualizarRota(rota);		
	}

	/*******************************************************************************/
	
	public List<Rota> buscarTodasRotas() {
		return rotaDAO.buscarTodasRotas();
	}

	/*******************************************************************************/
	
	public Rota buscarRotaPorId(Integer idRota) {
		return rotaDAO.buscarRotaPorId(idRota);
	}
	
	
	
	
	
	
	
	

}
